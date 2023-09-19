package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.fetchTransactionDTO;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class fetchTransactionStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;


    public fetchTransactionDTO  FetchTransactionDTO;
    public void prepareFetchTransactionPayload(){
       FetchTransactionDTO = fetchTransactionDTO
               .builder()
               .corporate("LQFLEET")
               .fromDate("2022-01-22T14:15:22Z")
               .toDate("2023-04-11T14:15:22Z")
               .pageNumber("0")
               .pageSize("10")
               .parentEntityId("9841175642")
               .build();
    }
    public void executeFetchTransactionPayload(Response loginresponse){

        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.FetchTransaction(FetchTransactionDTO,accessToken,refreshToken);
        System.out.println("Working for executeRequest2");

    }
    public void VerifyResponse(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }
}
