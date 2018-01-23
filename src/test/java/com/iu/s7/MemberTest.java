package com.iu.s7;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.iu.member.MemberDAO;
import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

public class MemberTest extends AbstractTest{
	
	@Inject
	private MemberDAO MemberDAO;
	
	@Inject
	private MemberController MemberController;
	
	private HttpSession session;
	@Inject
	private MemberService MemberService;
	
	@Test
	public void test() {
		MemberDTO memberDTO=new MemberDTO();
		memberDTO.setId("o");
		memberDTO.setPw("o");
		MemberDTO memberDTO2=null;
		try {
			memberDTO2=MemberService.memberLogin(memberDTO);
			assertNotNull(memberDTO2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
