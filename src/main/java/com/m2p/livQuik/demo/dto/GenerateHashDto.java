package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GenerateHashDto {

            String  key;
            String  salt;
            String  txnid;
            String  amount;
            String  productinfo;
            String  firstname;
            String  email;

}
