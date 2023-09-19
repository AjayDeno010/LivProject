package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountClosureDto {
String closureReason;
String ifscCode;
String accountName;
String accountNo;
String branch;
String changer;
String isCorporate;
String balance;
String entityId;
}
