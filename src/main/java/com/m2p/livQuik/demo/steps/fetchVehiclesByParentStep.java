package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.FetchVehiclesByParentDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class fetchVehiclesByParentStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;

    public FetchVehiclesByParentDto fetchVehiclesByParentDto;
    @Step
    public void preparefetchVehiclesByParentPayload(){
      fetchVehiclesByParentDto = FetchVehiclesByParentDto
              .builder()
              .parentEntityId("9841175642")
              .entityType("16")
              .pageNumber("0")
              .pageSize("200")
              .build();
    }
    @Step
    public void executefetchVehiclesByParentRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
        response = apiCallSetup.FetchVehiclesByParent(fetchVehiclesByParentDto,accessToken,refreshToken);

    }
    @Step
    public void VerifyfetchVehiclesByParentResponse(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }


}
