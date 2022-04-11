package com.tenable.gift.provider;

import java.util.List;

import com.tenable.gift.model.GiftExchangeDetails;

public interface GiftExchangeProvider {
	
	public List<GiftExchangeDetails> getGiftExchangeMemberList();
	public void setGiftExchangeDetails(List<GiftExchangeDetails> giftExchangeDetails);

}