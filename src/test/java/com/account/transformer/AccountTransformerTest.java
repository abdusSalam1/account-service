package com.account.transformer;

import com.account.domain.Account;
import com.account.model.AccountModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTransformerTest {

    private AccountTransformer accountTransformer;

    @BeforeEach
    public void setup() {
        accountTransformer = new AccountTransformer();
    }

    @Test
    public void whenNullAccountModelShouldReturnNullEntity() {
        //given
        AccountModel accountModel = null;
        //when
        Account account = accountTransformer.toEntity(accountModel);
        //then
        Assertions.assertNull(account);
    }

    @Test
    public void whenAccountModelShouldReturnEntity() {
        //given
        AccountModel accountModel = AccountModel.builder()
                .name("test_name")
                .email("test@email.com")
                .phoneNumber("1234")
                .password("1234")
                .build();
        //when
        Account account = accountTransformer.toEntity(accountModel);
        //then
        Assertions.assertNotNull(account);
        Assertions.assertEquals("test_name", account.getName());
        Assertions.assertEquals("test@email.com", account.getEmail());
        Assertions.assertEquals("1234", account.getPhoneNumber());
        Assertions.assertEquals("1234", account.getPassword());
    }

    @Test
    public void whenNullAccountShouldReturnEmptyModel() {
        //given
        Account account = null;
        //when
        AccountModel accountModel = accountTransformer.toModel(account);
        //then
        Assertions.assertNull(accountModel);
    }

    @Test
    public void whenAccountShouldReturnConvertedModel() {
        //given
        Account account = Account.builder()
                .id(123L)
                .name("test_name")
                .email("test@email.com")
                .phoneNumber("1234")
                .password("1234")
                .build();
        //when
        AccountModel accountModel = accountTransformer.toModel(account);
        //then
        Assertions.assertNotNull(accountModel);
        Assertions.assertEquals(123L, accountModel.getId());
        Assertions.assertEquals("test_name", accountModel.getName());
        Assertions.assertEquals("test@email.com", accountModel.getEmail());
        Assertions.assertEquals("1234", account.getPhoneNumber());
    }

}