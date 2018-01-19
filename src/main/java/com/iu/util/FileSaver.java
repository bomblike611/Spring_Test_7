package com.iu.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {

	public String[] saver(MultipartFile [] file,String filePath){
		
		String [] fileName=null;
		
		for(int i=0;i<file.length;i++){
			
		}
	}
	
	public String fileSave(MultipartFile f,String filePath) throws Exception{
		//1.저장할 파일명 생성
		//iu.jpg
		String fileName=f.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName=UUID.randomUUID().toString()+fileName;
		
		File file = new File(filePath, fileName);
		
		f.transferTo(file);
		
		return fileName;
	}
	
	
	
}
