package com.account.handler;

import com.account.model.AccountModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountHandler {
    public AccountModel createAccount(AccountModel model) {
        return null;
    }

    public AccountModel updateAccount(String accountId, AccountModel model) {
        return null;
    }
}
