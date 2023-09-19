package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.ReplacetagrequestDto;
import com.m2p.livQuik.demo.dto.VerifyOTP;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReplacetagrequestStep extends Assert {
    @Autowired
    protected ApiCallSetup apiCallSetup;

    public Response response;
    public ReplacetagrequestDto replacetagrequestDto;
    @Step
    public void prepareReplacetagRequestPayLoad(){
     replacetagrequestDto = ReplacetagrequestDto
             .builder()
             .mobile("9841175642")
             .reason("Toll Fare Issue")
             .build();
    }
    @Step
    public void executeReplacetagRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.Replacetagrequest(replacetagrequestDto,accessToken,refreshToken);
        System.out.println("Working for executeRequest");
    }
    @Step
    public void verifyReplacetagrequestResponse(){
        System.out.println( response.getBody());
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }
}
