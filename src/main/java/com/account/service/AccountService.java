package com.account.service;

import com.account.domain.Account;
import com.account.exception.AccountNotFoundException;

public interface AccountService {
    Account save(Account account);

    Account update(Long accountId, Account account) throws AccountNotFoundException;
}
