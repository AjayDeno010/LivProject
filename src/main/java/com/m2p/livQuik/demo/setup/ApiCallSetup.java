package com.m2p.livQuik.demo.setup;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import com.m2p.livQuik.demo.constants.EndpointConstants;

import static io.restassured.RestAssured.given;


@Component
public class ApiCallSetup {
    public Response response;


    @Step
    public Response loginNewUser(Object body) {
        return

                given()
                        .body(body)
                        .filter(new AllureRestAssured())
//                        .header("TENANT", "LQFLEET")
                        .header("Content-Type", "application/json")
                        .when()
                        .post(EndpointConstants.Login_New_User);


    }

    @Step
    public Response validateOTP(Object body, String accessToken) {
        return
                given()
                        .body(body)
                        .filter(new AllureRestAssured())
//                .header("TENANT", "LQFLEET")
                        .header("Content-Type", "application/json")
                        .header("accessToken", accessToken)

                        .when()
                        .post(EndpointConstants.validateOtp);

    }

    @Step
    public Response otpGeneration(Object body) {
        return given()
                .body(body)
                .filter(new AllureRestAssured())
                //  .header("TENANT", "LQFLEET")
                .header("Content-Type", "application/json")
                .when()
                .post(EndpointConstants.GENERATE_OTP);
    }

    @Step
    public Response UpdateCustomer(String Mobile, String MPIN, String accessToken) {
        return given()
                .body("{\"mobile\":\"" + Mobile + "\",\"keyValue\":{\"mpin\":\"" + MPIN + "\"}}")
                .filter(new AllureRestAssured())
//                .header("TENANT", "LQFLEET")
                .header("Content-Type", "application/json")
                .header("accessToken", accessToken)
                .when()
                .post(EndpointConstants.GENERATE_OTP);


    }

    @Step
    public Response CheckUserRegistered(Object body) {
        return given()
                .body(body)
                .filter(new AllureRestAssured())
//                .header("TENANT", "LQFLEET")
                .header("Content-Type", "application/json")
                .header("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoibHFmbGVldCIsImlhdCI6MTY3OTYzMDU3M30.fMVGKsKlk88Lfjwa3ozJ400zCHct3VmiqiTTXtmRLws")
                .when()
                .post(EndpointConstants.checkUser);
    }

    @Step
    public Response FetchTransaction(Object body, String accessToken, String refreshToken) {
        return given()
                .body(body)
                .filter(new AllureRestAssured())
//                .header("TENANT", "LQFLEET")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + refreshToken)
                .when()
                .post(EndpointConstants.fetchTransactions);

    }

    @Step
    public Response CustomerDetails(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
                .filter(new AllureRestAssured())
//                .header("tenant", "lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.detailsByMobile);

    }

    @Step
    public Response ForgotMPIN(Object body) {
        return given()
                .body(body)
                .filter(new AllureRestAssured())
//                .header("TENANT", "LQFLEET")
                .header("Content-Type", "application/json")
                .when()
                .post(EndpointConstants.ForgotMPIN);


    }

    @Step
    public Response GetCardList(Object body, String accessToken, String RefreshToken) {
        return given()
                //.body("{\"entityId\": \""+Mobile+"\"}")
                .body(body)
                .filter(new AllureRestAssured())
                //  .header("tenant", "lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.getcardlist);

    }

    @Step
    public Response VKYCLink(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
                .filter(new AllureRestAssured())
//                .header("tenant", "lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.VKYCLink);


    }

    @Step
    public Response getBalance(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
                .filter(new AllureRestAssured())
//                .header("tenant", "lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.getBalance);


    }

    @Step
    public Response GenerateHash(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
                .filter(new AllureRestAssured())
                //    .header("tenant", "lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.generateHash);
    }

    @Step
    public Response FetchVkycLink(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
                //    .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.generateHash);

    }

    @Step
    public Response FetchPgUrl(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.fetchPgUrl);
    }

    @Step
    public Response FetchVehiclesByParent(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant", "LQFLEET")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.fetchvehicle);
    }

    @Step
    public Response fetchvehicleTransactions(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
                //        .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.fetchVehicleTransactions);
    }

    @Step
    public Response Fetchdisputebyentity(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant", "lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.Fetchdisputebyentity);
    }

    @Step
    public Response AddDisputeReason(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.AddDisputeReason);
    }

    @Step
    public Response getDisputeReasons() {
        return given()

//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .when()
                .post(EndpointConstants.getDisputeReasons);
    }

    @Step
    public Response Replacetagrequest(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.Replacetagrequest);
    }

    @Step
    public Response tagFitmentCertificate(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.tagFitmentCertificate);
    }

    @Step
    public Response MarkDisputeTxn(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.MarkDisputeTxn);
    }

    @Step
    public Response getBanners() {
        return given()
//                .header("TENANT", "LQFLEET")
                .header("Content-Type", "application/json")
                .when()
                .post(EndpointConstants.Getbanners);
    }

    @Step
    public Response SearchVehicle(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.SerachVehicle);
    }

    @Step
    public Response FetchUPIUrl(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.SerachVehicle);

    }
    @Step
    public Response AccountClosure(Object body, String accessToken, String RefreshToken) {
        return given()
                .body(body)
//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .header("accessToken", "Bearer" + " " + accessToken)
                .header("refreshToken", "Bearer" + " " + RefreshToken)
                .when()
                .post(EndpointConstants.AccountClosure);

    }
    @Step
    public Response GetAccountClosureReason() {
        return given()

//                .header("tenant","lqfleet")
                .header("Content-Type", "application/json")
                .when()
                .post(EndpointConstants.GetAccountClosureReason);

    }
}



