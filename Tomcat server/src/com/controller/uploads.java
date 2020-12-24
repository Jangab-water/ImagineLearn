package com.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.upload_DAO;
import com.model.upload_DTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/uploads")
public class uploads extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("EUC-KR");

		// �̹����� ���� ������ �� ������
		String saveDri = request.getServletContext().getRealPath("/img");
		// �̹����� ũ�� ����
		int maxSize = 5 * 1024 * 1024;
		// ������ ���ڵ� ����
		String encoding = "EUC-KR";

		MultipartRequest multi = new MultipartRequest(request, saveDri, maxSize, encoding,
				new DefaultFileRenamePolicy());
		/*
		 * String title = multi.getParameter("title"); String writer =
		 * multi.getParameter("writer");
		 */
		
		
		String fileName = multi.getFilesystemName("fileName");
		
		
		

		upload_DTO dto = new upload_DTO(fileName);
		upload_DAO dao = new upload_DAO();
		int cnt = dao.upload(dto);

		
		if (cnt > 0) {
			System.out.println("���ε� ����");

			upload_DTO img = dao.selectOne(dto);
			String img_name = img.getFileName();
			System.out.println("������ �̹��� ����="+img_name);
			System.out.println("������ �̹��� ����="+img_name);
			System.out.println("������ �̹��� ����="+img_name);
			System.out.println("������ �̹��� ����="+img_name);
			System.out.println("������ �̹��� ����="+img_name);
			
		 //String upload_img1 = URLEncoder.encode(img_name, "EUC-KR") ;
			response.sendRedirect("http://221.156.60.13:9902/?img_name="+img_name);}
			//elen-master/upload.jsp?img_name=?
			//http://221.156.60.13:9000/?img_name=
			// ���⿡�� �ö�ũ�� ������.!..
           
		
			 else { System.out.println("���ε� ����"); }
			
	}

}
