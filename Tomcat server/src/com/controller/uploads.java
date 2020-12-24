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

		// 이미지를 어디다 저장을 할 것인지
		String saveDri = request.getServletContext().getRealPath("/img");
		// 이미지의 크기 지정
		int maxSize = 5 * 1024 * 1024;
		// 사진의 인코딩 설정
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
			System.out.println("업로드 성공");

			upload_DTO img = dao.selectOne(dto);
			String img_name = img.getFileName();
			System.out.println("가져올 이미지 네임="+img_name);
			System.out.println("가져올 이미지 네임="+img_name);
			System.out.println("가져올 이미지 네임="+img_name);
			System.out.println("가져올 이미지 네임="+img_name);
			System.out.println("가져올 이미지 네임="+img_name);
			
		 //String upload_img1 = URLEncoder.encode(img_name, "EUC-KR") ;
			response.sendRedirect("http://221.156.60.13:9902/?img_name="+img_name);}
			//elen-master/upload.jsp?img_name=?
			//http://221.156.60.13:9000/?img_name=
			// 여기에서 플라스크로 보내자.!..
           
		
			 else { System.out.println("업로드 실패"); }
			
	}

}
