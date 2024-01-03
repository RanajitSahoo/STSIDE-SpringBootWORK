package com.jsp.BookAPIOTO.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	public final String UPLOAD_DIR="//Users//ranajitsahoo//Desktop//STS-SpringToolSuite//bootOnetoOneMappingAPI//src//main//resources//static//image";
	
	public boolean uploadFile(MultipartFile file) {
		boolean flag=false;
		
		try {
			
//			//read the file from multipartFile class
//			
//			InputStream is = file.getInputStream();
//			byte[] data=new byte[is.available()];
//			is.read(data);
//			
//			//write the file or upload the file into the actual folder or image folder
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			
//			
//			fos.flush();
//			fos.close();
			
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

}
