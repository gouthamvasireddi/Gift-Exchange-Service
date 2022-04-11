package com.tenable.gift.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tenable.gift.constants.EndPoints;
import com.tenable.gift.model.GiftExchangeDetails;
import com.tenable.gift.processor.GiftExchangeProcessor;


@RestController
@RequestMapping(value = EndPoints.V1)
public class GiftExchangeController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GiftExchangeController.class);
	
	@Autowired
	GiftExchangeProcessor processor;
	
	@RequestMapping(value = EndPoints.GIFT_EXCHANGE_LIST,method = RequestMethod.GET , produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public ResponseEntity<List<GiftExchangeDetails>> getGiftExchangeList(){
		
		return new ResponseEntity<>(processor.getMemberExchangeDetails(),HttpStatus.OK);
	}
	
	@RequestMapping(value = EndPoints.GIFT_EXCHANGE_SHUFFLE,method = RequestMethod.POST , produces = {MediaType.APPLICATION_JSON_VALUE}) 
	public ResponseEntity<?> postGiftExchangeShuffleRequest(){
		
		processor.shuffleExchangeList();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	/*
	 * @RequestMapping(value = EndPoints.GIFT_EXCHANGE_HISTORY,method =
	 * RequestMethod.POST , produces = {MediaType.APPLICATION_JSON_VALUE}) public
	 * ResponseEntity<?> postGiftExchangeShuffleRequest(@RequestBody Gig){
	 * 
	 * 
	 * return new ResponseEntity<>(null,HttpStatus.ACCEPTED); }
	 */
}
