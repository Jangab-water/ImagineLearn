package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;



@WebServlet("/JoinServiceController")
public class JoinServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");
		// 서블릿에서 출력하는 한국말 바꾸는 메소드
		PrintWriter out = response.getWriter();
		// 아웃프린터로 출력 설정
		
		request.setCharacterEncoding("EUC-KR");
		//받아온거에 대한 한글로 바꾸는 메소드
		
	
		out.print("선우다다닫다다");
		// 화면에 보여지는 view 단 아웃 프린터
		System.out.println("회원가입 컨트롤러 접속완료");
		
		int cnt=0;
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		String email =request.getParameter("email");
		String name =request.getParameter("name");
		String age =request.getParameter("age");
		String gender =request.getParameter("gender");
	
    
	
       
       MemberDTO DTO = new MemberDTO(id,pw,email,name,age,gender);
 
       
       
     
       
       
       
       
       MemberDAO DAO = new MemberDAO();
      
      cnt  =DAO.join(DTO);
    
    
        System.out.println(name); 
        System.out.println(email);
		
		 
		
      
      
      HttpSession session= request.getSession();
      // 세션을 생성하는거에요 서블릿에서만 해야하고 jsp 안해도되요 (내장으로 시스템이 장착되어있어요)
      session.setAttribute("join_name", name);
     
      
      
      if (cnt>0) {
   	   
   	   System.out.println("디비에 값 추가성공");
   	   
   	   response.sendRedirect("elen-master/main.jsp?join_success=y");
	
   	  
     
   	   
   	   
      }
      else {
   	   System.out.println("디비에 값 추가 실패");
   	response.sendRedirect("elen-master/main.jsp?join_fail=n");
      }
		
		
		
		
		
	}

}