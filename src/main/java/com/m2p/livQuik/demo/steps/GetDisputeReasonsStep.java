package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.AddDisputeReasonDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetDisputeReasonsStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;


    public void executegetDisputeReasons(){
//        String accessToken = loginresponse.jsonPath().get("accessToken");
//        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response= apiCallSetup.getDisputeReasons();
    }
    public void VerifygetDisputeReasons(){

        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }
}
