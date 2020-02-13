package com.mlaku.dev.poc.controllers;

import com.mlaku.dev.poc.domain.Account;
import com.mlaku.dev.poc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/all",produces = "application/json" )
    public List<Account> listAccounts(){
        System.out.println(accountService.getAllAccounts().size());
        accountService.getAllAccounts().forEach(e->System.out.println(e));
        return accountService.getAllAccounts();
    }
}
