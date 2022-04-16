package com.account.handler;

import com.account.domain.Account;
import com.account.model.AccountModel;
import com.account.service.AccountService;
import com.account.transformer.Transformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountHandler {
    private final AccountService accountService;
    private final Transformer<AccountModel, Account> accountTransformer;

    public AccountModel createAccount(AccountModel model) {
        Account account = accountTransformer.toEntity(model);
        Account savedAccount = accountService.save(account);
        return accountTransformer.toModel(savedAccount);
    }

    public AccountModel updateAccount(String accountId, AccountModel model) {
        return null;
    }
}
