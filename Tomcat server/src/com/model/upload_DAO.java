package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class upload_DAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://woong1224.cpdgsj9aizuv.us-east-2.rds.amazonaws.com/ImagineLearn";
			String user = "nam1224";
			String password = "qwer1224";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int upload(upload_DTO dto) {
		int cnt = 0;
		
		getConnection();
		
		String sql = "insert into WEB_BOARD values(default,?)";
		try {
			psmt = conn.prepareStatement(sql);
		
			psmt.setString(1, dto.getFileName());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cnt;
	}
	
	
	
	public upload_DTO selectOne(upload_DTO dto) {
		
		getConnection();
		
		String sql = "select * from WEB_BOARD where FILENAME = ?";
		
		try {
			psmt =conn.prepareStatement(sql);
			psmt.setString(1, dto.getFileName());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				int num = rs.getInt(1);
				String fileName =rs.getString(2);
			
				System.out.println(num);
			
				System.out.println(fileName);
				
				dto = new upload_DTO(num, fileName);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
		
		
	}
}













