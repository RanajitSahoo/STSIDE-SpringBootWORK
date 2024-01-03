package com.jsp.BookAPIOTO.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.BookAPIOTO.Helper.FileUploadHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class fileUploadController {
	@Autowired
	private FileUploadHelper fileHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());
//		System.out.println(file.getSize());

		try {

			// validation
			if (file.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request most contain a file");
			}

			//
			if (!file.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Only jpeg content types are allowed");
			}
			
			boolean f = fileHelper.uploadFile(file);
			 if(f) {
				 return ResponseEntity.ok("File is SuccessFully Uploaded");
			 }

		} catch (Exception e) {
			e.printStackTrace();
		}

		// file upload code

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong? try it again!!");
	}

}
