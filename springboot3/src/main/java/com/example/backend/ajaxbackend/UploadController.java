package com.example.backend.ajaxbackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class UploadController {
	@RequestMapping(value="/canvasupload",
			 produces="text/plain; charset=utf-8")	
	public String saveFile(MultipartFile mfile) {	    
	     String fileName =  mfile.getOriginalFilename();	  
	     byte[] content = null;
	     String result="OK";
		 File isDir = new File("c:/uploadtest");
		 if (!isDir.isDirectory()) {
			isDir.mkdirs();
		 }
	     try {
	    	 content =  mfile.getBytes();
	    	 File f = new File("c:/uploadtest/"+fileName);
	   		 FileOutputStream fos = new FileOutputStream(f);
	   		 fos.write(content);
	   		 fos.close();	   		 
	     } catch (IOException e) {
	    	 e.printStackTrace();
	    	 result="FAIL";
	     }	    
	    return result;
	}
	@RequestMapping(value="/canvasdownload",
			 produces="text/plain; charset=utf-8")	
	public String downloadFile() {	    
		String path = "c:/uploadtest/";
		char[] buffer =  null;		
		try {
			FileReader reader = new FileReader(path+"test.png");
			buffer = new 
					char[(int)(new File(path+"test.png").length())];
			reader.read(buffer);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	    return new String(buffer);
	}
}
