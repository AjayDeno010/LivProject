package com.m2p.livQuik.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateCustomerDto {

    public String mobile;

    @JsonProperty("keyValue")
    public KeyValueDTO keyValue;


    public UpdateCustomerDto(String mobile, KeyValueDTO keyValue) {
        this.mobile = mobile;
        this.keyValue = keyValue;
    }

    // Getters and setters

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public KeyValueDTO getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(KeyValueDTO keyValue) {
        this.keyValue = keyValue;
    }
}
