package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginRequestDto {
    String entityid;
    String mobile;
    String mpin;
}
