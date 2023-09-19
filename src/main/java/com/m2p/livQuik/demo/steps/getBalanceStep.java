package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.GenerateOtpDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class getBalanceStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;
    public Response response;
    public GenerateOtpDto generateOtpDto;
 public void preparegetBalance(){
     generateOtpDto = GenerateOtpDto
             .builder()
             .entityId("9841175642")
             .build();
 }
 public void executegetBalanceRequest(Response loginresponse){
     String accessToken = loginresponse.jsonPath().get("accessToken");
     String reFreshToken = loginresponse.jsonPath().get("refreshToken");
     response = apiCallSetup.getBalance(generateOtpDto,accessToken,reFreshToken);
 }
    public void VerifygetBalance(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
 }

}
