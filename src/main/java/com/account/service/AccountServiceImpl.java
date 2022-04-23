package com.account.service;

import com.account.domain.Account;
import com.account.exception.AccountNotFoundException;
import com.account.exception.DuplicateAccountException;
import com.account.expert.MergeExpert;
import com.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final MergeExpert<Account> accountMergeExpert;

    @Override
    public Account save(Account account) throws DuplicateAccountException {
        if(accountRepository.findByEmailIgnoreCase(account.getEmail()) != null)
            throw new DuplicateAccountException();
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long accountId, Account account) throws AccountNotFoundException {
        Account accountFromDb = accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);
        Account mergedAccount = accountMergeExpert.merge(accountFromDb, account);
        return accountRepository.save(mergedAccount);
    }
}
