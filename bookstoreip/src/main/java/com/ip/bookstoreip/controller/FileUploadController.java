package com.ip.bookstoreip.controller;

import com.ip.bookstoreip.entity.Files;
import com.ip.bookstoreip.serivce.FileService;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile; 
@Controller
public class FileUploadController {
	@Autowired
    FileService fileService;
 
	 //@PostMapping("/savefile")
	    //public void fileUpload(@RequestParam("upload_file") MultipartFile file){
	 @RequestMapping(value="/savefile", method = RequestMethod.POST)
	 public @ResponseBody String fileUpdate(@RequestParam("upload_file") MultipartFile file) {
		 if (!file.isEmpty()) {
	            try {
	            	byte[] bytes;
			bytes = file.getBytes();  
			Files myfile1 = new Files();
			myfile1.setFilecontent(bytes);
			fileService.createFile(myfile1);
			return "Вы удачно загрузили ";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 
			e.printStackTrace();
			 return "Вам не удалось загрузить ";
		} 
		} else {
			 return "Пусто ";
		}
	    }
	 
}
