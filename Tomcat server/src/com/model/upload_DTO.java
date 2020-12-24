package com.model;

public class upload_DTO {
	private int num;
	private String title;
	private String writer;
	private String fileName;
	private String content;
	private String day;
	
	public upload_DTO(String title, String writer, String fileName, String content) {
		this.title = title;
		this.writer = writer;
		this.fileName = fileName;
		this.content = content;
	}


	public upload_DTO(int num, String title, String writer, String fileName, String content) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.fileName = fileName;
		this.content = content;
	
	}
	
	public upload_DTO(int num,  String fileName) {
		this.num = num;
	
		this.fileName = fileName;
		
	
	}
	
	public upload_DTO(int num, String title, String writer, String fileName ) {
		this.num = num;
		this.title = title;
		this.writer = writer;
		this.fileName = fileName;
	
	
	}

	public upload_DTO(String fileName) {

		this.fileName = fileName;
	
	
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
}
