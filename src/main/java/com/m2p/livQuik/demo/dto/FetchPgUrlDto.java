package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FetchPgUrlDto {
    String customerMobileNo;
    String customerId;
    String txnAmount;

}
