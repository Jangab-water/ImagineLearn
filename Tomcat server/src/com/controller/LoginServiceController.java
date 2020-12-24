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
		// �������� ����ϴ� �ѱ��� �ٲٴ� �޼ҵ�
		PrintWriter out = response.getWriter();
		// �ƿ������ͷ� ��� ����
		
		request.setCharacterEncoding("EUC-KR");
		//�޾ƿ°ſ� ���� �ѱ۷� �ٲٴ� �޼ҵ�
		
	
		
		// ȭ�鿡 �������� view �� �ƿ� ������
		System.out.println("�α��� ��Ʈ�ѷ� ���ӿϷ�");
		
		
	
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		
		 System.out.println(id);
		 System.out.println(pw);
		
		
		
		MemberDTO DTO = new MemberDTO(id,pw);
		
		MemberDAO DAO= new MemberDAO();
		
		MemberDTO info=DAO.login(DTO);
		// sql ���� ���� ��񿡼� �̾Ƴ� email ,pw -> �Է��ؼ� �̸��� �н����� �� sql Ȯ�� 
		// �ּҰ� -> Ŭ���� dto ��ü (x)
		
		// dto ���� dao �����ؾ߰���
		
		if(info != null) {
			
			System.out.println("�α��� ���� �߽��ϴ�");
			
			HttpSession session = request.getSession();
			// ���Ǻҷ��Ծ��
			
			
			session.setAttribute("login_info", info);
			// ���� �Է¿Ϸ�
			
			response.sendRedirect("elen-master/main.jsp");
			
		
			
			
			
		}
		
		
		else{
			System.out.println("�α��ν���");
			
			
			response.sendRedirect("elen-master/main.jsp?login_fail=n");
		}
		
		
	}

}
