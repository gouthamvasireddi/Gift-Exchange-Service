package com.tenable.gift.processor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tenable.gift.model.GiftExchangeDetails;
import com.tenable.gift.provider.GiftExchangeProvider;
import com.tenable.gift.provider.MemberProvider;

@Component
public class GiftExchangeProcessor {
	
	@Autowired
	Map<String, List<String>> giftsHistory;
	
	@Autowired
	GiftExchangeProvider giftExchangeProvider;
	
	@Autowired
	MemberProvider memberProvider;
	
	
	public List<GiftExchangeDetails> getMemberExchangeDetails(){
		
		List<GiftExchangeDetails> list = giftExchangeProvider.getGiftExchangeMemberList();
		if(list.size() != 0 || memberProvider.getAllMembersKeys().size() < 2)
			return list;
		else
			shuffleExchangeList();
		
		return giftExchangeProvider.getGiftExchangeMemberList();
	}
	
	public void shuffleExchangeList() {
		
		List<GiftExchangeDetails> resultList = new ArrayList<>();
				
		List<String> memberKeys = memberProvider.getAllMembersKeys();
		
		List<String> referenceKeys = new ArrayList<>(memberKeys);
		
		Collections.shuffle(referenceKeys);
		
		for(String memberId : memberKeys) {
			int i = -1;
			for(i =referenceKeys.size()-1 ;i>=0;i--) {
				
				if(memberId == referenceKeys.get(i) || (giftsHistory.get(memberId) != null && giftsHistory.get(memberId).contains(referenceKeys.get(i)))) {
					continue;
				}
				
				break;
			}
			
			if(i != -1) {
				resultList.add(new GiftExchangeDetails(memberId, referenceKeys.get(i)));
				referenceKeys.remove(i);
			}
		}
		
		
		giftExchangeProvider.setGiftExchangeDetails(resultList);
		
	}
	

}
