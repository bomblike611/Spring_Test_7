package com.iu.member;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.util.FileSaver;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int memberJoin(MemberDTO memberDTO,MultipartFile file,HttpSession session) throws Exception{
		String filePath=session.getServletContext().getRealPath("resources/upload");
		File f=new File(filePath);
		if(!f.exists()){
			f.mkdir();
		}
		FileSaver fileSaver=new FileSaver();
		String fileName=fileSaver.saver(file, filePath);
		memberDTO.setFname(fileName);
		memberDTO.setOname(file.getOriginalFilename());
		
		return memberDAO.memberJoin(memberDTO);
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberDelete(memberDTO);
	}
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	public String memberidcheck(String id) throws Exception{
		return memberDAO.memberidcheck(id);
	}
}
