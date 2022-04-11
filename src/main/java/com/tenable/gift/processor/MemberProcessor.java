package com.tenable.gift.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tenable.gift.model.Member;
import com.tenable.gift.provider.MemberProvider;

@Component
public class MemberProcessor {

	@Autowired
	MemberProvider memberProvider;

	public String addMember(Member member) {

		return memberProvider.addMember(member);
	}

	public void updateMember(Member member) {

		memberProvider.updateMember(member);
	}

	public Member getMember(String memberId) {

		return memberProvider.getMember(memberId);
	}
	
	public void deleteMember(String memberId) {

		memberProvider.getMember(memberId);
	}

}
