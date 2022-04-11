package com.tenable.gift.model;

public class GiftExchangeDetails {

	String giverId;
	String receiverId;
	
	public GiftExchangeDetails() {
	}
	
	public GiftExchangeDetails(String giverId,String receiverId) {
		this.giverId  = giverId;
		this.receiverId = receiverId;
	}
	
	public String getGiverId() {
		return giverId;
	}
	public void setGiverId(String giverId) {
		this.giverId = giverId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	
	
}
