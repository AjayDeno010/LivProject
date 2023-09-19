package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.FetchPgUrlDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class fetchPgUrlStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;

    public FetchPgUrlDto fetchPgUrlDto;

    public void PreparefetchPgUrlRequest(){
        fetchPgUrlDto = FetchPgUrlDto
                .builder()
                .customerId("9841175642")
                .customerMobileNo("9841175642")
                .txnAmount("10")
                .build();
    }
    public void executefetchPgUrl(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.FetchPgUrl(fetchPgUrlDto,accessToken,refreshToken);
        System.out.println("Working for executeRequest2");
    }
    public void VerifyfetchPgUrlRequest(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }

}
