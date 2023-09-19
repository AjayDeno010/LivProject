package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.ForgotMpinDTO;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForgotMpinStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;
    public Response response;
    protected ForgotMpinDTO forgotMpinDTO;

    public void prepareForgotMPINPayload() {
        forgotMpinDTO = ForgotMpinDTO
                .builder()
                .mobile("9841175642")
                .dob("01/06/2000")
                .build();
    }

    public void executeForgotMPINRequest() {
        response = apiCallSetup.ForgotMPIN(forgotMpinDTO);
    }

    @Step
    public void verifyForgotMPINRequestResponse() {
        System.out.println(response.getBody());
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }
}
