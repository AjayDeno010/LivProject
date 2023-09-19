package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.MarkDisputeTxnDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarkDisputeTxnStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;
    public MarkDisputeTxnDto markDisputeTxnDto;
    public void prepareMarkDisputeTxn(){
        markDisputeTxnDto = MarkDisputeTxnDto
                .builder()
                .disputeType("TRANSACTION")
                .txnRef("")
                .description("testing disputeeee")
                .reason("testing dispute middlewareee")
                .entityId("9841175642")
                .build();

    }
    public void executeMarkDisputeTxnRequest(Response loginresponse){
       String accessToken= loginresponse.jsonPath().get("accessToken");
       String refreshToken=loginresponse.jsonPath().get("refreshToken");
       response = apiCallSetup.MarkDisputeTxn(markDisputeTxnDto,accessToken,refreshToken);

    }
    public void VerifyMarkDisputeTxnResponse(){
        verifyStatusIs200(response);
        verifythecontent(response);

    }
}
