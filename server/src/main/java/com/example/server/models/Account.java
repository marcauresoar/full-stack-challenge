package com.example.server.models;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    private Long id;
    private String agency;
    private String number;
    private String digit;
    private Client client;
    private List<Statement> statements;
}
