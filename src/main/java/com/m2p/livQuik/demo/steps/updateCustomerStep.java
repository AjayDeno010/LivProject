package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.KeyValueDTO;
import com.m2p.livQuik.demo.dto.LoginRequestDto;
import com.m2p.livQuik.demo.dto.UpdateCustomerDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static  org.hamcrest.Matchers.*;

@Component
public class updateCustomerStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;
    public Response response;

    public KeyValueDTO keyValueDTO;
    public UpdateCustomerDto updateCustomerDto;
    public LoginRequestDto loginRequestDto;

    public otpVerificationStep otpVerificationStep;
    public updateCustomerStep updateCustomerStep;
//    @Step
//    public void prepareLoginNewUserRequestPayLoad(){
//        loginRequestDto = LoginRequestDto
//                .builder()
//                .mobile("9841175642")
//                .mpin("1234")
//                .build();
//        System.out.println("Working for Requestpayload1");
//    }
//    @Step
//    public void executeLoginNewUserRequest(){
//        response= apiCallSetup.loginNewUser(loginRequestDto);
//        System.out.println("Working for ExecuteRequest1");
//    }


    @Step
    public void executeUpdateCustomerRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        response= apiCallSetup.UpdateCustomer( "9841175642","1234" ,accessToken);
        System.out.println("Working for executeRequest2");
    }
    @Step
    public void verifyupdateCustomerResponse(){
        verifyStatusIs200(response);
        verifythecontent(response);

    }
}
