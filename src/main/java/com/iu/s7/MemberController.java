package com.iu.s7;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin",method=RequestMethod.GET)
	public void memberJoin() throws Exception{
	}
	
	@RequestMapping(value="memberJoin",method=RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO,RedirectAttributes ra,MultipartFile file,HttpSession session) throws Exception{
		int result=memberService.memberJoin(memberDTO,file,session);
		String message="Fail";
		if(result>0){
			message="Success";
		}
		ra.addAttribute("message", message);
		return "redirect:../";
	}
	
	
}
