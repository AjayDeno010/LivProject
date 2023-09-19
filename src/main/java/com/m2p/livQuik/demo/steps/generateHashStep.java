package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.GenerateHashDto;
import com.m2p.livQuik.demo.dto.GenerateOtpDto;
import com.m2p.livQuik.demo.dto.VerifyOTP;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class generateHashStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;
    public Response response;



 public GenerateHashDto generateHashDto;
    @Step
    public void prepareGenerateHashRequestPayLoad(){
     generateHashDto = GenerateHashDto
             .builder()
             .txnid("13a")
             .salt("Zasswd")
             .amount("200")
             .email("ajay.s@m2pfintech.com")
             .firstname("S")
             .key("a1ezew32")
             .productinfo("toll")
             .build();


    }
    @Step
    public void executeGenerateHashRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.GenerateHash(generateHashDto,accessToken,refreshToken);
        System.out.println("Working for executeRequest");
    }
    @Step
    public void verifyGenerateHashRequestResponse(){
        System.out.println( response.getBody());
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }
}
