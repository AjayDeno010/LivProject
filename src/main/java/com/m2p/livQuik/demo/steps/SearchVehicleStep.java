package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.SearchVehicleDTO;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchVehicleStep extends Assert {
    @Autowired
    public ApiCallSetup apiCallSetup;
    public Response response;
    public SearchVehicleDTO searchVehicleDTO;

    public void prepareSearchVehiclePayLoad(){
        searchVehicleDTO = SearchVehicleDTO
                .builder()
                .entityid("9841175642")
                .vehicleNo("TN22BP8148")
                .build();

    }
    public void executeSearchVehicleRequest(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
      response = apiCallSetup.SearchVehicle(searchVehicleDTO,accessToken,refreshToken);
    }
    public void VerifySearchVehicleResponse(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();

    }
}
