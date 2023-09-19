package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FetchVehicleTransactionsDto {
    String vehicleId;
    String toDate;
    String fromDate;
    String pageSize;
   String pageNumber;
}

