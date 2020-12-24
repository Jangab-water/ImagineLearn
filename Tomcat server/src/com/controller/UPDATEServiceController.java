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

/**
 * Servlet implementation class UPDATEServiceController
 */
@WebServlet("/UPDATEServiceController")
public class UPDATEServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		response.setCharacterEncoding("EUC-KR");
		// 서블릿에서 출력하는 한국말 바꾸는 메소드
		PrintWriter out = response.getWriter();
		// 아웃프린터로 출력 설정
		
		request.setCharacterEncoding("EUC-KR");
		//받아온거에 대한 한글로 바꾸는 메소드
		
		HttpSession session = request.getSession();
		// 세션불러왔어요
		
		
		
		MemberDTO login_info = (MemberDTO) session.getAttribute("login_info");
	
		
		// 세션 입력완료
	
		System.out.println("업데이트 컨트롤러 접속완료");
		
		int cnt=0;

		
		String id =login_info.getId();
		String pw =request.getParameter("pw");
		String email =request.getParameter("email");
	
		
		
		  
	       MemberDTO DTO = new MemberDTO(id,pw,email);
	 
	       
	       
	     
	       
	       
	       
	       
	       MemberDAO DAO = new MemberDAO();
	      
	      cnt  =DAO.update(DTO);
	    
	    
           System.out.println(pw);
	        System.out.println(email);
	       
			
			 
			
	      
	      
	    
	      // 세션을 생성하는거에요 서블릿에서만 해야하고 jsp 안해도되요 (내장으로 시스템이 장착되어있어요)
	    
	      
	      
	      if (cnt>0) {
	   	   
	   	   System.out.println("디비에 값 추가성공");
	   	   
	   	   response.sendRedirect("elen-master/main.jsp?update_success=y");
		
	   	  
	     
	   	   
	   	   
	      }
	      else {
	   	   System.out.println("디비에 값 추가 실패");
	   	response.sendRedirect("elen-master/main.jsp?update_success=n");
	      }
			
		
		
		
		
		
		
		
		
	}

}
