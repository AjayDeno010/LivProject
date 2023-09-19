package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.FetchVehicleTransactionsDto;
import com.m2p.livQuik.demo.dto.GetCardListDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetchdisputebyentityStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;
    public GetCardListDto getCardListDto;

    public void PrepareFetchdisputebyentityStepPayload() {
        getCardListDto = GetCardListDto
                .builder()
                .entityId("9841175642")
                .build();
    }
    public void executeFetchdisputebyentityStep(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.Fetchdisputebyentity(getCardListDto,accessToken,refreshToken);
    }
    public void VerifyFetchdisputebyentityStep(){

        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }
}
