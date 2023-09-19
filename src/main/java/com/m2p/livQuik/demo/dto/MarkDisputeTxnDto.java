package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MarkDisputeTxnDto {
    String reason;
    String description;
    String disputeType;
    String txnRef;
    String entityId;
}
