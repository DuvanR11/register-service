package org.example.infrastructure.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClientDTO implements Serializable {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
}