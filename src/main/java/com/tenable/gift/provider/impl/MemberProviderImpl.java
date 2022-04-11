package com.tenable.gift.provider.impl;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.tenable.gift.model.Member;
import com.tenable.gift.provider.MemberProvider;
import com.tenable.gift.utility.IDGeneratorUtility;

@Repository
public class MemberProviderImpl implements MemberProvider {

	ConcurrentHashMap<String,Member> memberDataSource = new ConcurrentHashMap<String, Member>();

	@Override
	public String addMember(Member member) {

		if(member.getId() == null || member.getId() == "") member.setId(IDGeneratorUtility.generateID());
				
		memberDataSource.put(member.getId(), member);
		return member.getId();
	}
	
	@Override
	public List<String> getAllMembersKeys() {
		
		return Collections.list(memberDataSource.keys());
	}

	@Override
	public void updateMember(Member member) {

		memberDataSource.put(member.getId(), member);
	}

	@Override
	public Member getMember(String memberId) {

		return memberDataSource.get(memberId);
	}

	@Override
	public void deleteMember(String memberId) {

		memberDataSource.remove(memberId);
	}

}
