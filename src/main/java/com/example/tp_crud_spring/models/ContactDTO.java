package com.example.tp_crud_spring.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ContactDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
