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
		// �������� ����ϴ� �ѱ��� �ٲٴ� �޼ҵ�
		PrintWriter out = response.getWriter();
		// �ƿ������ͷ� ��� ����
		
		request.setCharacterEncoding("EUC-KR");
		//�޾ƿ°ſ� ���� �ѱ۷� �ٲٴ� �޼ҵ�
		
		HttpSession session = request.getSession();
		// ���Ǻҷ��Ծ��
		
		
		
		MemberDTO login_info = (MemberDTO) session.getAttribute("login_info");
	
		
		// ���� �Է¿Ϸ�
	
		System.out.println("������Ʈ ��Ʈ�ѷ� ���ӿϷ�");
		
		int cnt=0;

		
		String id =login_info.getId();
		String pw =request.getParameter("pw");
		String email =request.getParameter("email");
	
		
		
		  
	       MemberDTO DTO = new MemberDTO(id,pw,email);
	 
	       
	       
	     
	       
	       
	       
	       
	       MemberDAO DAO = new MemberDAO();
	      
	      cnt  =DAO.update(DTO);
	    
	    
           System.out.println(pw);
	        System.out.println(email);
	       
			
			 
			
	      
	      
	    
	      // ������ �����ϴ°ſ��� ���������� �ؾ��ϰ� jsp ���ص��ǿ� (�������� �ý����� �����Ǿ��־��)
	    
	      
	      
	      if (cnt>0) {
	   	   
	   	   System.out.println("��� �� �߰�����");
	   	   
	   	   response.sendRedirect("elen-master/main.jsp?update_success=y");
		
	   	  
	     
	   	   
	   	   
	      }
	      else {
	   	   System.out.println("��� �� �߰� ����");
	   	response.sendRedirect("elen-master/main.jsp?update_success=n");
	      }
			
		
		
		
		
		
		
		
		
	}

}
