package com.empmng.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path , MultipartFile file) throws IOException {
		
		//file name
		String name = file.getOriginalFilename();
		//System.out.println("file name"+name);
		
		//Generate random file name
		String randomId = UUID.randomUUID().toString();
		String randomFileName = randomId.concat(name.substring(name.lastIndexOf(".")));
		
		//Full Path
		String filePath = path + File.separator + randomFileName;
		//System.out.println("full path of file"+filePath);
		
		//create folder if not created
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		
		//copy file
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return randomFileName;
	}

}
