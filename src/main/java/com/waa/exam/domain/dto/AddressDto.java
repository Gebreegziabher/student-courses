package com.waa.exam.domain.dto;

import lombok.Data;

@Data//Getters, RequiredAttributesConstructor, equals, hashcode, toString
public class AddressDto {
    private int id;
    private String city;
    private String state;
    private String zipcode;
}
