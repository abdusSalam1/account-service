package com.account.handler;

import com.account.domain.Account;
import com.account.domain.NotificationType;
import com.account.exception.AccountNotFoundException;
import com.account.model.AccountModel;
import com.account.service.AccountService;
import com.account.service.NotificationService;
import com.account.transformer.Transformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountHandler {
    private final AccountService accountService;
    private final Transformer<AccountModel, Account> accountTransformer;
    private final NotificationService notificationService;

    public AccountModel createAccount(AccountModel model) {
        Account account = accountTransformer.toEntity(model);
        Account savedAccount = accountService.save(account);
        notificationService.sendEmail(NotificationType.CREATE_ACCOUNT, savedAccount.getEmail());
        return accountTransformer.toModel(savedAccount);
    }

    public AccountModel updateAccount(Long accountId, AccountModel model) throws AccountNotFoundException {
        Account account = accountTransformer.toEntity(model);
        Account updatedAccount = accountService.update(accountId, account);
        return accountTransformer.toModel(updatedAccount);
    }
}