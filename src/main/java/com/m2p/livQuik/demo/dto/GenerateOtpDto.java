package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GenerateOtpDto {

    String mobile;
    String entityId;
    //Below one is for get cardlist API
//    String entityId;

}
