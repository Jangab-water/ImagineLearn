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
		// �������� ����ϴ� �ѱ��� �ٲٴ� �޼ҵ�
		PrintWriter out = response.getWriter();
		// �ƿ������ͷ� ��� ����
		
		request.setCharacterEncoding("EUC-KR");
		//�޾ƿ°ſ� ���� �ѱ۷� �ٲٴ� �޼ҵ�
		
	
		out.print("����ٴٴݴٴ�");
		// ȭ�鿡 �������� view �� �ƿ� ������
		System.out.println("ȸ������ ��Ʈ�ѷ� ���ӿϷ�");
		
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
      // ������ �����ϴ°ſ��� ���������� �ؾ��ϰ� jsp ���ص��ǿ� (�������� �ý����� �����Ǿ��־��)
      session.setAttribute("join_name", name);
     
      
      
      if (cnt>0) {
   	   
   	   System.out.println("��� �� �߰�����");
   	   
   	   response.sendRedirect("elen-master/main.jsp?join_success=y");
	
   	  
     
   	   
   	   
      }
      else {
   	   System.out.println("��� �� �߰� ����");
   	response.sendRedirect("elen-master/main.jsp?join_fail=n");
      }
		
		
		
		
		
	}

}