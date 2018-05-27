package com.example.server.controllers;

import com.example.server.models.Account;
import com.example.server.services.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController)
                .build();
    }

    @Test
    public void testFindAllShouldReturnSuccess() throws Exception {
        when(accountService.findAll()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/account/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindByIdShouldReturnSuccess() throws Exception {
        final Long id = 123L;

        Account account = Account.builder().id(id).build();
        given(accountService.findById(id)).willReturn(account);

        mockMvc.perform(get("/account/" + id))
                .andExpect(status().isOk());
    }

}
