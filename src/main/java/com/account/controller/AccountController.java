package com.account.controller;

import com.account.handler.AccountHandler;
import com.account.model.AccountModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountHandler accountHandler;

    @PostMapping
    public AccountModel createAccount(@RequestBody AccountModel model){
        return accountHandler.createAccount(model);
    }

    @PutMapping("/{accountId}")
    public AccountModel updateAccount(@PathVariable String accountId, @RequestBody AccountModel model){
        return accountHandler.updateAccount(accountId, model);
    }
}