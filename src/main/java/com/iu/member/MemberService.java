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
	
	public int memberUpdate(MemberDTO memberDTO,MultipartFile file,HttpSession session,String check) throws Exception{
		FileSaver fileSaver = new FileSaver();
		String filepath = session.getServletContext().getRealPath("resources/upload");
		if(check.equals("true")){
		File f2=new File(filepath, memberDTO.getFname());
		f2.delete();
		File f = new File(filepath);
		if(!f.exists()){
			f.mkdirs();
		}
		String fileName="null";
		if(file!=null){
				fileName=fileSaver.saver(file, filepath);
		memberDTO.setFname(fileName);
		memberDTO.setOname(file.getOriginalFilename());
		}else{
			memberDTO.setFname(fileName);
			memberDTO.setOname("null");
		}
		}
		return memberDAO.memberUpdate(memberDTO);
	}
	public int memberDelete(MemberDTO memberDTO,HttpSession session) throws Exception{
		String filepath = session.getServletContext().getRealPath("resources/upload");
		FileSaver fileSaver=new FileSaver();
		fileSaver.fileDelete(filepath, memberDTO.getFname());
		
		return memberDAO.memberDelete(memberDTO);
	}
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	public String memberidcheck(String id) throws Exception{
		return memberDAO.memberidcheck(id);
	}
	
}
