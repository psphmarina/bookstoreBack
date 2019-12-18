package com.ip.bookstoreip.serivce;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.ip.bookstoreip.entity.Author;
import com.ip.bookstoreip.entity.Files;
import com.ip.bookstoreip.repository.FileRepository;
@Service
public class FileService {
	@Autowired
    private final FileRepository fileRepository;
	
	 public FileService(FileRepository fileRepository){
	        this.fileRepository = fileRepository;
	    }

		public void createFile( Files file){
	        fileRepository.save(file);
	    }
		public List<Files> findAllById(Integer id){
	        return fileRepository.findAllById(id);
	    }
}
