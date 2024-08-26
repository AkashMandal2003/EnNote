package com.akash.ennote.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContactForm {

    private String name;
    private String email;
    private String message;


}
