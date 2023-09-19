package com.m2p.livQuik.demo;

import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

@SpringBootTest
class DemoTests extends BaseTest {

	@Autowired
	protected LivQuickFlow livQuickFlow;
	@Test(priority = 1)
	public void OTPVerification() {
		livQuickFlow
				.OTPVerification();
	}
	@Test(priority = 2)
	public void OTPGenerate(){
		livQuickFlow
				.OTPGenerate();

	}
	@Test(priority=3)
	public void updateCustomer(){
		livQuickFlow
				.updateCustomer();

	}
	@Test(priority=4)
	public void CheckIfUserRegistered(){
		livQuickFlow
				.CheckifUserRegistered();

	}
	@Test(priority = 5)
	public void customerDetailsByMobile(){
		livQuickFlow
				.detailsByMobile();

	}
	@Test(priority = 6)
	public void FetchTransaction(){
		livQuickFlow
				.FtechTransactions();

	}
	@Test(priority = 7)
	public void ForgotMPIN(){
		livQuickFlow
				.ForgotMPIN();

	}
	@Test(priority = 8)
	public void getCardDetails(){
		livQuickFlow
				.GetCardList();
	}
    @Test(priority = 9)
	public void VKYCLink(){
		livQuickFlow
				.VKYCLink();
	}
	@Test(priority = 10)
	public void GetBalance(){
		livQuickFlow
				.GetBalance();

	}
     @Test(priority = 11)
	public void GenerateHash(){
		livQuickFlow
				.GenerateHash();
	 }
	 @Test(priority = 12)
	public void fetchVkycLink(){
		livQuickFlow
				.FetchVkycLink();

	 }
	 @Test(priority = 13)
	public void fetchPgUrl(){
		livQuickFlow
				.fetchPgUrl();
	 }
	 @Test(priority = 14)
	public void fetchVehicleTransactions(){
		livQuickFlow
				.FetchVehicleByTransaction();
	 }
	 @Test(priority = 15)
	public void fetchVehicleByparent(){
		livQuickFlow
				.fetchVehiclesByParent();
	 }
	 @Test(priority = 16)
	public void Fetch_dispute_by_entity(){
		livQuickFlow
				.Fetch_dispute_by_entity();
	 }
//	 @Test
//	 public void Add_Dispute_Reason(){
//		livQuickFlow
//				.Add_Dispute_Reason();
//	 }
     @Test(priority = 17)
	public void getDisputeReasons(){
		livQuickFlow
				.getDisputeReasons();
	 }
	 @Test(priority = 18)
	public void Replace_tag_request(){
		livQuickFlow
				.Replace_tag_request();
	 }
 @Test(priority = 19)
	public void tag_Fitment_Certificate(){
		livQuickFlow
				.tagFitmentCertificate();
 }
 @Test(priority = 20)
	public void Mark_dispute_txn(){
		livQuickFlow
				.Mark_dispute_txn();
 }
 @Test(priority = 21)
	public void GetBanners(){
		livQuickFlow
				.GetBanners();
 }
	@Test(priority = 22)
	public void SearchVehicle(){
		livQuickFlow
				.SearchVehicle();
	}
	@Test(priority = 23)
	public void FetchUPIUrl(){
		livQuickFlow
				.FetchUPIUrl();
	}
	@Test(priority = 24)
	public void AccountClosure(){
		livQuickFlow
				.AccountClosure();
	}
	@Test(priority = 24)
	public void GetAccountClosureReason(){
		livQuickFlow
				.GetAccountClosureReason();
	}

}
