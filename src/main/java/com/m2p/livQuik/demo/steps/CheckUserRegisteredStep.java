package com.m2p.livQuik.demo.steps;


import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.CheckUserRegisteredDTO;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class CheckUserRegisteredStep extends Assert {

    @Autowired
    ApiCallSetup apiCallSetup;

    public Response response;
    public CheckUserRegisteredDTO checkUserRegisteredDTO;
    //Prepare Request Payload
    public void prepareCheckUserRegisteredPayload(){

         checkUserRegisteredDTO = CheckUserRegisteredDTO
                 .builder()
                 .mobile("9841175642")
                 .appGuid("ch123")
                 .build();

    }
    public void executeCheckUserRegisteredRequest(){response=apiCallSetup.CheckUserRegistered(checkUserRegisteredDTO);
    }
    public void verifyRequest(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }
}
