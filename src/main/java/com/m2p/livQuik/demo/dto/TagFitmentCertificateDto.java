package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TagFitmentCertificateDto {
    Boolean sendEmail;
    String vehicleId;
}
