package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FetchVehiclesByParentDto {
    String parentEntityId;
    String pageNumber;
    String pageSize;
    String entityType;
}
