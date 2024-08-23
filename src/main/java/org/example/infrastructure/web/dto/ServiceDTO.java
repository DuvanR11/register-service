package org.example.infrastructure.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ServiceDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Double price;
}
