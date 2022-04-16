package com.account.expert;

import com.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMergeExpert implements MergeExpert<Account> {
    @Override
    public Account merge(Account oldValue, Account newValue) {
        return null;
    }
}
