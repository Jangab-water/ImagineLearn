package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	int cnt = 0;
	String name = null;
   MemberDTO info =null;
   ArrayList<MemberDTO> list = null;

	// db 접속
	public void conn() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://woong1224.cpdgsj9aizuv.us-east-2.rds.amazonaws.com/ImagineLearn";
			String user = "nam1224";
			String password = "qwer1224";
			conn = DriverManager.getConnection(url, user, password);

			// 디비 접속 하는경로 유알아이 유저 패스워드

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 접속 해제
	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원가입
	public int join(MemberDTO dto) { // 조인
		// 만약에 memberdto 타입이든 객체든 들어오면 (레퍼런스 변수가 한개인)
		conn();

		try {
			// sql 실행
			String sql = "insert into MEMBER values(?,?,?,?,?,?)";
			/* num.nextval ->시퀀스 자동증가 */
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId()); // dto.getname()
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getEmail());
			psmt.setString(4, dto.getName());
			psmt.setString(5, dto.getAge());
			psmt.setString(6, dto.getGender());
			
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
		// 인설트 (추가가되면) cnt = 1이되요 기존에 0이라고 설정했다면
	}



	public MemberDTO login(MemberDTO dto) { //로그인

		conn();

		try {
			// sql 실행
			String sql = "select * from  MEMBER where id=? and pw=?";
			/* num.nextval ->시퀀스 자동증가 */
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId()); // dto.getname()
			psmt.setString(2, dto.getPw());
		    rs=psmt.executeQuery();
			if(rs.next()) {
				String id =rs.getString(1);
				String pw =rs.getString(2);
				String name=rs.getString(4);
			  //담아야돼 
				
				info = new MemberDTO(id,pw,name);
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return info;

	}
	// 로그인
	
	
	
	
	public int update(MemberDTO dto) { // 조인
		// 만약에 memberdto 타입이든 객체든 들어오면 (레퍼런스 변수가 한개인)
		conn();

		try {
			// sql 실행
			String sql = "update MEMBER set pw=?, email=? where id=?";
			/* num.nextval ->시퀀스 자동증가 */
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getId());
			
			
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
		// 인설트 (추가가되면) cnt = 1이되요 기존에 0이라고 설정했다면
	}

	
	
	
	

}
