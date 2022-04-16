package com.account.expert;

import com.account.domain.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountMergeExpertTest {

    private AccountMergeExpert accountMergeExpert;

    @BeforeEach
    public void setup(){
        this.accountMergeExpert = new AccountMergeExpert();
    }

    @Test
    public void whenOldIsNullShouldReturnNew(){
        //given
        Account oldAccount = null;
        Account newAccount = Account.builder().id(12L).build();
        //when
        Account mergedAccount = accountMergeExpert.merge(oldAccount,newAccount);
        //then
        Assertions.assertNotNull(mergedAccount);
        Assertions.assertEquals(12L, mergedAccount.getId());
    }


    @Test
    public void whenNewIsNullShouldReturnOld(){
        //given
        Account oldAccount =  Account.builder().id(12L).build();
        Account newAccount = null;
        //when
        Account mergedAccount = accountMergeExpert.merge(oldAccount,newAccount);
        //then
        Assertions.assertNotNull(mergedAccount);
        Assertions.assertEquals(12L, mergedAccount.getId());
    }

}