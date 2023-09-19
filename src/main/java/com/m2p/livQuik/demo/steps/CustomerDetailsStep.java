package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.GenerateOtpDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsStep extends Assert {
    @Autowired
    public ApiCallSetup apiCallSetup;

    public Response response;

    public GenerateOtpDto generateOtpDto;

    public void prepareCustomerDetailsPayload(){
        generateOtpDto = GenerateOtpDto
                .builder()
                .mobile("9841175642")
                .build();

    }
    public void executeCustomerDetailsRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String reFreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.CustomerDetails(generateOtpDto,accessToken,reFreshToken);
        System.out.println("Working for executeRequest");

    }

    public void VerifyCustomerDetails(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }
}
