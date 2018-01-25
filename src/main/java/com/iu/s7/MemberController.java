package com.iu.s7;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
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
	
	@RequestMapping(value="memberIdCheck")
	public void memberIdCheck(String id,Model model)throws Exception{
		String resultId=memberService.memberidcheck(id);
		if(resultId==null){
			model.addAttribute("message", "사용가능한 아이디입니다.");
		}else{
			model.addAttribute("message", "중복된 아이디입니다.");
		}
	}
	
	@RequestMapping(value="memberDelete")
	public String memberDelete(MemberDTO memberDTO,HttpSession session,RedirectAttributes ra) throws Exception{
		ModelAndView mv=new ModelAndView();
		int result=memberService.memberDelete(memberDTO,session);
		String s="fail";
		if(result>0){
			session.invalidate();
			s="Success";
		}
		ra.addAttribute("message", s);
		return "redirect:../";
		
	}
	
	@RequestMapping(value="memberUpdate",method=RequestMethod.GET)
	public void memberUpdate() throws Exception{
	}
	@RequestMapping(value="memberUpdate",method=RequestMethod.POST)
	public ModelAndView memberUpdate(MemberDTO memberDTO,HttpSession session,MultipartFile file,String check) throws Exception{
		ModelAndView mv=new ModelAndView();
		System.out.println("file"+file);
		int result=memberService.memberUpdate(memberDTO,file,session,check);
		String s="Fail";
		if(result>0){
			s="Success";
		}
		mv.addObject("message", s);
		mv.addObject("path", "memberView");
		mv.setViewName("common/result");
		session.setAttribute("member", memberDTO);
		return mv;
	}
	
	@RequestMapping(value="memberLogin",method=RequestMethod.GET)
	public void memberLogin() throws Exception{
		
	}
	
	
	@RequestMapping(value="memberLogin",method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO,HttpSession session) throws Exception{
		MemberDTO memberDTO2=null;
		memberDTO2=memberService.memberLogin(memberDTO);
		ModelAndView mv=new ModelAndView();
		if(memberDTO2!=null){
		session.setAttribute("member", memberDTO2);
		mv.addObject("message", "Success");
		mv.addObject("path", "../");
		}else{
		mv.addObject("message", "Fail");
		mv.addObject("path", "memberLogin");
		}
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value="memberView")
	public void memberView() throws Exception{
	}
	
	
}
