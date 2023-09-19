package com.m2p.livQuik.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class fetchTransactionDTO {

    String pageSize;
    String corporate;
    String parentEntityId;
    String toDate;
    String fromDate;
    String pageNumber;

  /*  {
        "pageSize": "10",
            "pageNumber": 0,
            "fromDate": "2023-03-27",
            "toDate": "2023-06-19",
            "parentEntityId": "9841175642",
            "corporate": "LQPARTNER01"
    } */

}
