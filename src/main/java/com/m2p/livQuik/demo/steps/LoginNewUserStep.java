package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.LoginRequestDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginNewUserStep extends Assert {
    @Autowired
    protected ApiCallSetup apiCallSetup;

    public Response response;

    public LoginRequestDto loginRequestDto;

    public otpVerificationStep otpVerificationStep;
    public updateCustomerStep updateCustomerStep;
    public CustomerDetailsStep customerDetailsStep;
    @Step
    public void prepareLoginNewUserRequestPayLoad(){
        loginRequestDto = LoginRequestDto
                .builder()
                .mobile("9841175642")
                .mpin("1234")
                .build();
        System.out.println("Working for Requestpayload1");
    }
    @Step
    public void executeLoginNewUserRequest(){
        response= apiCallSetup.loginNewUser(loginRequestDto);
        System.out.println("Working for ExecuteRequest1");
    }
    @Step
    public void verifyResponse(){

        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
        System.out.println("Working for VerifyResponse1");

    }
    @Step
    public void prepareNextRequestPayload(){
       otpVerificationStep.prepareOTPverificationRequestPayLoad();

    }
//    @Step
//    public void prepareUpdatecustomerPayload(){
//        updateCustomerStep.prepareUpdatecustomerpayloadrequest();
//    }
   @Step
    public void prepareCustomerDetailsPayload(){
        customerDetailsStep.prepareCustomerDetailsPayload();
   }

}
