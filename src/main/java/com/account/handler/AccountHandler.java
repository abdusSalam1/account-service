package com.account.handler;

import com.account.domain.Account;
import com.account.domain.notification.EmailNotificationEvent;
import com.account.domain.notification.NotificationEvent;
import com.account.domain.notification.NotificationType;
import com.account.exception.AccountNotFoundException;
import com.account.model.AccountModel;
import com.account.service.AccountService;
import com.account.transformer.Transformer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountHandler {
    private final AccountService accountService;
    private final Transformer<AccountModel, Account> accountTransformer;
    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;

    public AccountModel createAccount(AccountModel model) {
        Account account = accountTransformer.toEntity(model);
        Account savedAccount = accountService.save(account);
        NotificationEvent emailEvent = createEmailEvent(savedAccount.getEmail(), NotificationType.CREATE_ACCOUNT);
        kafkaTemplate.send(NotificationType.CREATE_ACCOUNT.toString(), emailEvent);
        return accountTransformer.toModel(savedAccount);
    }

    public AccountModel updateAccount(Long accountId, AccountModel model) throws AccountNotFoundException {
        Account account = accountTransformer.toEntity(model);
        Account updatedAccount = accountService.update(accountId, account);
        NotificationEvent emailEvent = createEmailEvent(updatedAccount.getEmail(), NotificationType.UPDATE_ACCOUNT);
        kafkaTemplate.send(NotificationType.UPDATE_ACCOUNT.toString(), emailEvent);
        return accountTransformer.toModel(updatedAccount);
    }

    private NotificationEvent createEmailEvent(String email, NotificationType type) {
        return EmailNotificationEvent.builder()
                .toEmail(email)
                .type(type)
                .build();
    }
}
