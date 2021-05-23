package kr.co.jie.dto;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
	private String name;
	private MultipartFile file;
	private String filedesc;
	
	public FileDTO() {
		
	}

	public FileDTO(String name, MultipartFile file, String filedesc) {
		super();
		this.name = name;
		this.file = file;
		this.filedesc = filedesc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFiledesc() {
		return filedesc;
	}

	public void setFiledesc(String filedesc) {
		this.filedesc = filedesc;
	}
	
	
}
