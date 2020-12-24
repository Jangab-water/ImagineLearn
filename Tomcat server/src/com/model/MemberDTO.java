package com.model;

public class MemberDTO {
	private String id = null;
	private String pw = null;
	private String email = null;
	private String name = null;
	private String age = null;
	private String gender = null;
	
	
	public MemberDTO() {
	
	}
	
	

	
	
	
	public MemberDTO(String id, String pw, String email, String name, String age, String gender) {
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	// 회원가입 전용
	
	
	//---------------------------
	
	public MemberDTO(String id, String pw) {
		
		this.id = id;
		this.pw = pw;
	
	}
	
	public MemberDTO(String id, String pw, String name) {
	
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	// 로그인 전용
	
	
	
	
	
	

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
}




