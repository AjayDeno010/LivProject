package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.FetchVehicleTransactionsDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class fetchVehicleTransactionsStep extends Assert {
    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;
    public FetchVehicleTransactionsDto fetchVehicleTransactionsDto;
   public void PreparefetchVehicleTransactionsPayload(){
       fetchVehicleTransactionsDto = FetchVehicleTransactionsDto
               .builder()
               .vehicleId("TN22BP8148")
               .fromDate("2023-02-21")
               .toDate("2023-06-20")
               .pageNumber("0")
               .pageSize("4")
               .build();
   }
   public void executeFetchVehicleTransactions(Response loginresponse){
       String accessToken = loginresponse.jsonPath().get("accessToken");
       String refreshToken = loginresponse.jsonPath().get("refreshToken");
     response= apiCallSetup.fetchvehicleTransactions(fetchVehicleTransactionsDto,accessToken,refreshToken);
   }
    public void VerifyFetchVehicleTaransaction(){

        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }
}
