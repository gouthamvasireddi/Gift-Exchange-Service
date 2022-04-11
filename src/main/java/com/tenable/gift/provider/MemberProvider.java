package com.tenable.gift.provider;

import java.util.List;

import com.tenable.gift.model.Member;

public interface MemberProvider {
	
	public String addMember(Member member);
	public void updateMember(Member member);
	public Member getMember(String memberId);
	public void deleteMember(String memberId);
	public List<String> getAllMembersKeys();
	
}