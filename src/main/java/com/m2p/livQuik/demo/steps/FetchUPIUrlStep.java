package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.FetchUPIUrlDTO;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetchUPIUrlStep extends Assert {
    @Autowired
    public ApiCallSetup apiCallSetup;
    public Response response;
    public FetchUPIUrlDTO fetchUPIUrlDTO;
    @Step
    public void prepareFetchUPIUrlRequestPayLoad(){
     fetchUPIUrlDTO = FetchUPIUrlDTO
             .builder()
             .name("")
             .vehicleNo("")
             .build();
    }
    @Step
    public void executeFetchUPIUrlpayload(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response = apiCallSetup.FetchUPIUrl(fetchUPIUrlDTO,accessToken,refreshToken);
    }
    @Step
    public void VerifyFetchUPIUrlRequest(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }
}
