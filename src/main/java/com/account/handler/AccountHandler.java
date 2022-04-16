package com.account.handler;

import com.account.model.AccountModel;
import com.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountHandler {
    private final AccountService accountService;

    public AccountModel createAccount(AccountModel model) {
        return null;
    }

    public AccountModel updateAccount(String accountId, AccountModel model) {
        return null;
    }
}
