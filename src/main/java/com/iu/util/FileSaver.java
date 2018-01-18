package com.iu.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {

	public String fileSave(MultipartFile f,String filePath) throws Exception{
		String fileName=f.getOriginalFilename();
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName=UUID.randomUUID().toString()+fileName;
		
		File file = new File(filePath, fileName);
		
		f.transferTo(file);
		
		return fileName;
	}
	
	
	
}
