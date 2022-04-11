package com.tenable.gift.provider.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tenable.gift.model.GiftExchangeDetails;
import com.tenable.gift.provider.GiftExchangeProvider;

@Repository
public class GiftExchangeProviderImpl implements GiftExchangeProvider{

	private List<GiftExchangeDetails> details = new ArrayList<>(); 
	private Object object = new Object();
	
	@Override
	public List<GiftExchangeDetails> getGiftExchangeMemberList() {
		return details;
	}

	@Override
	public void setGiftExchangeDetails(List<GiftExchangeDetails> giftExchangeDetails) {
		synchronized (object) {
			this.details = giftExchangeDetails; 
		}
		
	}

}
