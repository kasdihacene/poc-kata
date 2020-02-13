package com.mlaku.dev.poc.repository;

import com.mlaku.dev.poc.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryTest {

    @Mock
    private AccountRepository accountRepository;

    private Optional<Account> account;

    @Before
    public void setUp() throws Exception {
        account = Optional.of(new Account());
        account.get().setUser_id(2L);
        account.get().setEmail("TEST&@mail");
        account.get().setUsername("Hacene");
        account.get().setPassword("TESTpasse2020");
        account.get().setCreatedOn(new Date());
    }

    @Test
    public void get_account_test(){
        shouldCreateOneAccount();
        accountRepository.findById(2L);
    }

    private void shouldCreateOneAccount(){
        Mockito.when(accountRepository.findById(2L)).thenReturn(account);
    }
}