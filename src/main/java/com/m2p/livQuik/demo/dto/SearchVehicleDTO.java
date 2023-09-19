package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SearchVehicleDTO {
    String vehicleNo;
    String entityid;
}
