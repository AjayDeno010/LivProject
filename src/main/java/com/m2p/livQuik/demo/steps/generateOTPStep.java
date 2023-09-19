package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.GenerateOtpDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class generateOTPStep extends Assert {
    
    @Autowired
    ApiCallSetup apiCallSetup;

    public GenerateOtpDto generateOtpDto;

    public Response response;

    @Step
    public void preparePayloadforOTPgeneration(){
        generateOtpDto = GenerateOtpDto
                .builder()
                .mobile("9841175642")
                .build();
    }

    @Step
    public void executeOTPgenerationRequest(){
        response = apiCallSetup.otpGeneration(generateOtpDto);
    }
    @Step
    public void verifyOTPGenerateResponse(){
      verifyStatusIs200(response);
        verifythecontent(response);

        response.getBody();
        System.out.println("Working for VerifyResponse1");
    }
}
