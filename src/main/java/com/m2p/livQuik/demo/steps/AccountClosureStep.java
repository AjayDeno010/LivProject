package com.m2p.livQuik.demo.steps;

import com.m2p.livQuik.demo.assertions.Assert;
import com.m2p.livQuik.demo.dto.AccountClosureDto;
import com.m2p.livQuik.demo.setup.ApiCallSetup;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class AccountClosureStep extends Assert {

    @Autowired
    ApiCallSetup apiCallSetup;
    public Response response;
    public AccountClosureDto accountClosureDto;
    public void prepareAccountClosurePayload(){
        accountClosureDto = AccountClosureDto
                .builder()
                .accountName("")
                .balance("")
                .closureReason("")
                .branch("")
                .isCorporate("")
                .ifscCode("")
                .accountNo("")
                .changer("")
                .entityId("")
                .build();

    }
    public void executeAccountClosure(Response loginresponse){
        String accessToken = loginresponse.jsonPath().get("accessToken");
        String refreshToken = loginresponse.jsonPath().get("refreshToken");
      response=  apiCallSetup.AccountClosure(accountClosureDto,accessToken,refreshToken);
    }
    public void verifyAccountClosure(){
        verifyStatusIs200(response);
        verifythecontent(response);
        response.getBody();
    }

}
