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


@WebServlet("/LoginServiceController")
public class LoginServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("EUC-KR");
		// 서블릿에서 출력하는 한국말 바꾸는 메소드
		PrintWriter out = response.getWriter();
		// 아웃프린터로 출력 설정
		
		request.setCharacterEncoding("EUC-KR");
		//받아온거에 대한 한글로 바꾸는 메소드
		
	
		
		// 화면에 보여지는 view 단 아웃 프린터
		System.out.println("로그인 컨트롤러 접속완료");
		
		
	
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		
		 System.out.println(id);
		 System.out.println(pw);
		
		
		
		MemberDTO DTO = new MemberDTO(id,pw);
		
		MemberDAO DAO= new MemberDAO();
		
		MemberDTO info=DAO.login(DTO);
		// sql 문을 거쳐 디비에서 뽑아낸 email ,pw -> 입력해서 이메일 패스워드 디 sql 확인 
		// 주소값 -> 클래스 dto 자체 (x)
		
		// dto 설계 dao 설계해야겠죠
		
		if(info != null) {
			
			System.out.println("로그인 성공 했습니다");
			
			HttpSession session = request.getSession();
			// 세션불러왔어요
			
			
			session.setAttribute("login_info", info);
			// 세션 입력완료
			
			response.sendRedirect("elen-master/main.jsp");
			
		
			
			
			
		}
		
		
		else{
			System.out.println("로그인실패");
			
			
			response.sendRedirect("elen-master/main.jsp?login_fail=n");
		}
		
		
	}

}
