package com.tenable.gift.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tenable.gift.constants.EndPoints;
import com.tenable.gift.model.Member;
import com.tenable.gift.processor.MemberProcessor;

@RestController
@RequestMapping(value = EndPoints.V1)
public class MemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberProcessor memberProssor;

	@RequestMapping(value = EndPoints.MEMBER + "/{memberId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getMember(@PathVariable(value = "memberId", required = true) String memberId) {

		Member member = memberProssor.getMember(memberId);
		if (member == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(memberProssor.getMember(memberId), HttpStatus.OK);

	}
	
	@RequestMapping(value = EndPoints.MEMBER + "/{memberId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteMember(@PathVariable(value = "memberId", required = true) String memberId) {

		memberProssor.deleteMember(memberId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@RequestMapping(value = EndPoints.MEMBER, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addMember(@Valid @RequestBody Member member) {

		member.setId(null);
		String id = memberProssor.addMember(member);

		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = EndPoints.MEMBER + "/{memberId}", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateMember(@Valid @RequestBody Member member,@PathVariable(value = "memberId", required = true) String memberId) {

		member.setId(memberId);
		memberProssor.updateMember(member);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
