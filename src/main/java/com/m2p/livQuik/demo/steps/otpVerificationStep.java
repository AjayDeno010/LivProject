package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.VerifyOTP;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class otpVerificationStep extends Assert {
    @Autowired
    protected ApiCallSetup apiCallSetup;

    public Response response;

    public VerifyOTP verifyOTP;

    @Step
    public void prepareOTPverificationRequestPayLoad(){
        verifyOTP = VerifyOTP
                .builder()
                .otp("123456")
                .mobile("9841175642")
                .build();
    }
    @Step
    public void executeOTPverificationRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        response= apiCallSetup.validateOTP(verifyOTP, accessToken);
        System.out.println("Working for executeRequest");
    }
    @Step
    public void verifyOTPverificationRequestResponse(){
        System.out.println( response.getBody());
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }

}
