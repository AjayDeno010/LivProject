package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.AccountClosureDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAccountClosureReasonStep extends Assert {
   public Response response;
   @Autowired
    ApiCallSetup apiCallSetup;

    public void executeAccountClosureReason(){
     response= apiCallSetup.GetAccountClosureReason();
    }
    public void verifyAccountClosureReason(){
        verifyStatusIs200(response);
        verifythecontent(response);
    }
}
