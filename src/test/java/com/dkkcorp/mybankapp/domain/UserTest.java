package com.dkkcorp.mybankapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;
    private Account account;
    @Before
    public void setUp(){
        account=new Account();
        user=new User();
    }

    @Test
    public void addAccount() {
        user.addAccount(account);
        assertEquals(account,user.getAccount().get(0));
    }

    @Test
    public void addAddress() {
    }

    @Test
    public void addAcontact() {
    }
}