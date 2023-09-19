package com.m2p.livQuik.demo;

import com.m2p.livQuik.demo.dto.GenerateOtpDto;
import com.m2p.livQuik.demo.dto.TagFitmentCertificateDto;
import com.m2p.livQuik.demo.steps.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LivQuickFlow {
    @Autowired
    protected  getBalanceStep GetBalanceStep;
    @Autowired
    protected  ReplacetagrequestStep replacetagrequestStep;
    @Autowired
    protected  GetDisputeReasonsStep getDisputeReasonsStep;

    @Autowired
    protected LoginNewUserStep loginNewUserStep;
    @Autowired
    protected generateOTPStep GnerateOTPStep;

   @Autowired
   protected updateCustomerStep updateCustomerStep;

    @Autowired
    protected otpVerificationStep otpVerificationStep;

    @Autowired
    protected CheckUserRegisteredStep checkUserRegisteredStep;

    @Autowired
    protected fetchTransactionStep FetchTransactionStep;

    @Autowired
    protected CustomerDetailsStep customerDetailsStep;

    @Autowired
    protected  ForgotMpinStep forgotMpinStep;
    @Autowired
    protected getCardListStep GetCardListStep;

    @Autowired
    protected  GetVKYCLinkStep getVKYCLinkStep;

    @Autowired
    protected  generateHashStep GenerateHashStep;

    @Autowired
    protected fetchVkycLinkStep FetchVkycLinkStep;
    @Autowired
    protected fetchPgUrlStep FetchPgUrlStep;
    @Autowired
    protected fetchVehiclesByParentStep FetchVehiclesByParentStep;

    @Autowired
    protected   fetchVehicleTransactionsStep FetchVehicleTransactionsStep;
    @Autowired
    protected  FetchdisputebyentityStep fetchdisputebyentityStep;
    @Autowired
    protected  AddDisputeReasonStep addDisputeReasonStep;
    @Autowired
    protected  TagFitmentCertificateStep tagFitmentCertificateStep;
    @Autowired
    protected  MarkDisputeTxnStep markDisputeTxnStep;
    @Autowired
    protected  GetBannersStep getBannersStep;
    @Autowired
    protected  SearchVehicleStep searchVehicleStep;
    @Autowired
    protected  AccountClosureStep accountClosureStep;
    @Autowired
    protected  FetchUPIUrlStep fetchUPIUrlStep;
    @Autowired
    protected  GetAccountClosureReasonStep getAccountClosureReasonStep;
    public LivQuickFlow OTPVerification(){

        loginNewUserStep.prepareLoginNewUserRequestPayLoad();
        loginNewUserStep.executeLoginNewUserRequest();
        loginNewUserStep.verifyResponse();
       otpVerificationStep.prepareOTPverificationRequestPayLoad();
        otpVerificationStep.executeOTPverificationRequest(loginNewUserStep.response);
        otpVerificationStep.verifyOTPverificationRequestResponse();

        return this;

   }
   public LivQuickFlow OTPGenerate(){
       //Generate Test Data
       GnerateOTPStep.preparePayloadforOTPgeneration();
       //Fire API Call
       GnerateOTPStep.executeOTPgenerationRequest();
       //Validate Response
       GnerateOTPStep.verifyOTPGenerateResponse();
        return this;
   }
   public LivQuickFlow updateCustomer(){
       loginNewUserStep.prepareLoginNewUserRequestPayLoad();
       loginNewUserStep.executeLoginNewUserRequest();
       loginNewUserStep.verifyResponse();
       updateCustomerStep.executeUpdateCustomerRequest(loginNewUserStep.response);
       updateCustomerStep.verifyupdateCustomerResponse();
        return this;
   }
   public LivQuickFlow CheckifUserRegistered(){
         checkUserRegisteredStep.prepareCheckUserRegisteredPayload();
         checkUserRegisteredStep.executeCheckUserRegisteredRequest();
         checkUserRegisteredStep.verifyRequest();

        return this;
   }
   public LivQuickFlow FtechTransactions(){
       loginNewUserStep.prepareLoginNewUserRequestPayLoad();
       loginNewUserStep.executeLoginNewUserRequest();
       loginNewUserStep.verifyResponse();
      FetchTransactionStep.prepareFetchTransactionPayload();
       FetchTransactionStep.executeFetchTransactionPayload(loginNewUserStep.response);
       FetchTransactionStep.VerifyResponse();
        return this;
   }
   public LivQuickFlow detailsByMobile(){
       loginNewUserStep.prepareLoginNewUserRequestPayLoad();
       loginNewUserStep.executeLoginNewUserRequest();
       loginNewUserStep.verifyResponse();
       customerDetailsStep.prepareCustomerDetailsPayload();
        customerDetailsStep.executeCustomerDetailsRequest(loginNewUserStep.response);
        customerDetailsStep.VerifyCustomerDetails();
        return this;
   }
  public LivQuickFlow ForgotMPIN(){
        forgotMpinStep.prepareForgotMPINPayload();
        forgotMpinStep.executeForgotMPINRequest();
        forgotMpinStep.verifyForgotMPINRequestResponse();
        return  this;
  }
 public LivQuickFlow GetCardList(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     GetCardListStep.prepareGetCardList();
     GetCardListStep.executGetCardList(loginNewUserStep.response);
     GetCardListStep.VerifyGetcardList();
        return  this;
 }
 public LivQuickFlow VKYCLink(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
        getVKYCLinkStep.prepareVKYCLinkPayLoad();
        getVKYCLinkStep.executeVKYCLinkReq(loginNewUserStep.response);
        getVKYCLinkStep.VerifyVKYCLink();
        return this;
 }
 public LivQuickFlow GetBalance(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     GetBalanceStep.preparegetBalance();
     GetBalanceStep.executegetBalanceRequest(loginNewUserStep.response);
     GetBalanceStep.VerifygetBalance();
        return this;

 }
 public LivQuickFlow GenerateHash(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     GenerateHashStep.prepareGenerateHashRequestPayLoad();
     GenerateHashStep.executeGenerateHashRequest(loginNewUserStep.response);
     GenerateHashStep.verifyGenerateHashRequestResponse();
        return  this;
 }
 public LivQuickFlow FetchVkycLink(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     FetchVkycLinkStep.preparefetchVkycLinkPayLoad();
     FetchVkycLinkStep.executefetchVkycLinkRequest(loginNewUserStep.response);
     FetchVkycLinkStep.verifyfetchVkycLinkRequestResponse();
        return  this;
 }
 public LivQuickFlow fetchPgUrl(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     FetchPgUrlStep.PreparefetchPgUrlRequest();
     FetchPgUrlStep.executefetchPgUrl(loginNewUserStep.response);
     FetchPgUrlStep.VerifyfetchPgUrlRequest();

        return this;
 }
 public LivQuickFlow fetchVehiclesByParent(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     FetchVehiclesByParentStep.preparefetchVehiclesByParentPayload();
     FetchVehiclesByParentStep.executefetchVehiclesByParentRequest(loginNewUserStep.response);
     FetchVehiclesByParentStep.VerifyfetchVehiclesByParentResponse();
        return this;
 }
 public LivQuickFlow FetchVehicleByTransaction(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     FetchVehicleTransactionsStep.PreparefetchVehicleTransactionsPayload();
     FetchVehicleTransactionsStep.executeFetchVehicleTransactions(loginNewUserStep.response);
     FetchVehicleTransactionsStep.VerifyFetchVehicleTaransaction();
        return this;
 }
 public LivQuickFlow Fetch_dispute_by_entity(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     fetchdisputebyentityStep.PrepareFetchdisputebyentityStepPayload();
     fetchdisputebyentityStep.executeFetchdisputebyentityStep(loginNewUserStep.response);
     fetchdisputebyentityStep.VerifyFetchdisputebyentityStep();
        return  this;
 }
 public LivQuickFlow Add_Dispute_Reason(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     addDisputeReasonStep.PrepareaddDisputeReasonPayload();
     addDisputeReasonStep.executeaddDisputeReason(loginNewUserStep.response);
     addDisputeReasonStep.VerifyaddDisputeReason();
        return this;

 }
 public LivQuickFlow getDisputeReasons(){
        getDisputeReasonsStep.executegetDisputeReasons();
        getDisputeReasonsStep.VerifygetDisputeReasons();
        return this;
 }
 public LivQuickFlow Replace_tag_request(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
        replacetagrequestStep.prepareReplacetagRequestPayLoad();
        replacetagrequestStep.executeReplacetagRequest(loginNewUserStep.response);
        replacetagrequestStep.verifyReplacetagrequestResponse();
        return this;
 }
 public LivQuickFlow tagFitmentCertificate(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     tagFitmentCertificateStep.preparetagFitmentCertificatePayLoad();
     tagFitmentCertificateStep.executetagFitmentCertificateRequest(loginNewUserStep.response);
     tagFitmentCertificateStep.verifytagFitmentCertificateResponse();
        return this;
 }
 public LivQuickFlow Mark_dispute_txn(){
     loginNewUserStep.prepareLoginNewUserRequestPayLoad();
     loginNewUserStep.executeLoginNewUserRequest();
     loginNewUserStep.verifyResponse();
     markDisputeTxnStep.prepareMarkDisputeTxn();
     markDisputeTxnStep.executeMarkDisputeTxnRequest(loginNewUserStep.response);
     markDisputeTxnStep.VerifyMarkDisputeTxnResponse();
        return this;
 }
 public LivQuickFlow GetBanners(){
        getBannersStep.executeGetBannersRequest();
        getBannersStep.verifyGetBannersRequest();
        return this;
 }
    public LivQuickFlow SearchVehicle(){
        loginNewUserStep.prepareLoginNewUserRequestPayLoad();
        loginNewUserStep.executeLoginNewUserRequest();
        loginNewUserStep.verifyResponse();
       searchVehicleStep.prepareSearchVehiclePayLoad();
       searchVehicleStep.executeSearchVehicleRequest(loginNewUserStep.response);
       searchVehicleStep.prepareSearchVehiclePayLoad();
       searchVehicleStep.VerifySearchVehicleResponse();
        return this;
    }
    public LivQuickFlow FetchUPIUrl(){
        loginNewUserStep.prepareLoginNewUserRequestPayLoad();
        loginNewUserStep.executeLoginNewUserRequest();
        loginNewUserStep.verifyResponse();
        fetchUPIUrlStep.prepareFetchUPIUrlRequestPayLoad();
        fetchUPIUrlStep.executeFetchUPIUrlpayload(loginNewUserStep.response);
        fetchUPIUrlStep.VerifyFetchUPIUrlRequest();
        return  this;
    }
    public LivQuickFlow AccountClosure(){
        loginNewUserStep.prepareLoginNewUserRequestPayLoad();
        loginNewUserStep.executeLoginNewUserRequest();
        loginNewUserStep.verifyResponse();
       accountClosureStep.prepareAccountClosurePayload();
       accountClosureStep.executeAccountClosure(loginNewUserStep.response);
       accountClosureStep.verifyAccountClosure();
        return  this;
    }
    public LivQuickFlow GetAccountClosureReason(){
       getAccountClosureReasonStep.executeAccountClosureReason();
       getAccountClosureReasonStep.verifyAccountClosureReason();
        return  this;
    }

}




