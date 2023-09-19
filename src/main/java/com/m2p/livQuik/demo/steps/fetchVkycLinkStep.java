package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.FetchVkycLinkDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class fetchVkycLinkStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;
    public Response response;
    public FetchVkycLinkDto fetchVkycLinkDto;
    @Step
    public void preparefetchVkycLinkPayLoad(){
        fetchVkycLinkDto = FetchVkycLinkDto
                .builder()
                .corporate("LQPARTNER01")
                .mobile("9841175642")
                .build();
    }
    @Step
    public void executefetchVkycLinkRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.FetchVkycLink(fetchVkycLinkDto,accessToken, refreshToken);
    }
    @Step
    public void verifyfetchVkycLinkRequestResponse(){
        System.out.println( response.getBody());
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }
}
