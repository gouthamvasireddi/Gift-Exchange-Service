package com.tenable.gift;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tenable.gift.controller.GiftExchangeController;
import com.tenable.gift.controller.MemberController;
import com.tenable.gift.model.GiftExchangeDetails;
import com.tenable.gift.model.Member;

@SpringBootTest
class GiftExchangeServiceApplicationTests {

	@Autowired
	private MemberController memberController;
	
	@Autowired
	private GiftExchangeController giftController;

	@Test
	public void positiveTest() throws Exception {
		
		Member m1 = new Member("MEM1","John");
		Member m2 = new Member("MEM2","Snow");
		
		memberController.addMember(m1);
		memberController.addMember(m2);
		
		List<GiftExchangeDetails> result = giftController.getGiftExchangeList().getBody();;
		
		assertThat(result.size()).isEqualTo(2);
		
		for(GiftExchangeDetails detail : result) {
			if(detail.getGiverId() == m1.getId())
				assertThat(detail.getReceiverId()).isEqualTo(m2.getId());
			
			if(detail.getGiverId() == m2.getId())
				assertThat(detail.getReceiverId()).isEqualTo(m1.getId());
		}
	}
	
	

}
