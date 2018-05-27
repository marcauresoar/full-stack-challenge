package com.example.server.controllers;

import com.example.server.services.StatementService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class StatementControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StatementService statementService;

    @InjectMocks
    private StatementController statementController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(statementController)
                .build();
    }

    @Test
    public void testFindAllByAccountIdShouldReturnSuccess() throws Exception {
        final Long id = 123L;

        when(statementService.findAllByAccountId(id)).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/statement/list/" + id))
                .andExpect(status().isOk());
    }

}
