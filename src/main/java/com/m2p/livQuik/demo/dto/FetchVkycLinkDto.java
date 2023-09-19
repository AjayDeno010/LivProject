package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FetchVkycLinkDto {
    String mobile;
    String corporate;
}
