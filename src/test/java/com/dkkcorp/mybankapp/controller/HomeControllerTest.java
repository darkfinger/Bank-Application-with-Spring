package com.dkkcorp.mybankapp.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;

public class HomeControllerTest {

    private HomeController homeController;
    @Mock
    private Model model;

    @Before
    public void setUp() throws RuntimeException {
        MockitoAnnotations.initMocks(this);
        homeController=new HomeController();
    }

    @Test
    public void home() {
        String vi=homeController.home(model);
        assertEquals("index",vi);
    }
}