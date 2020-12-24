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

	// db ����
	public void conn() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://woong1224.cpdgsj9aizuv.us-east-2.rds.amazonaws.com/ImagineLearn";
			String user = "nam1224";
			String password = "qwer1224";
			conn = DriverManager.getConnection(url, user, password);

			// ��� ���� �ϴ°�� ���˾��� ���� �н�����

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ���� ����
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

	// ȸ������
	public int join(MemberDTO dto) { // ����
		// ���࿡ memberdto Ÿ���̵� ��ü�� ������ (���۷��� ������ �Ѱ���)
		conn();

		try {
			// sql ����
			String sql = "insert into MEMBER values(?,?,?,?,?,?)";
			/* num.nextval ->������ �ڵ����� */
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
		// �μ�Ʈ (�߰����Ǹ�) cnt = 1�̵ǿ� ������ 0�̶�� �����ߴٸ�
	}



	public MemberDTO login(MemberDTO dto) { //�α���

		conn();

		try {
			// sql ����
			String sql = "select * from  MEMBER where id=? and pw=?";
			/* num.nextval ->������ �ڵ����� */
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId()); // dto.getname()
			psmt.setString(2, dto.getPw());
		    rs=psmt.executeQuery();
			if(rs.next()) {
				String id =rs.getString(1);
				String pw =rs.getString(2);
				String name=rs.getString(4);
			  //��ƾߵ� 
				
				info = new MemberDTO(id,pw,name);
			 }

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return info;

	}
	// �α���
	
	
	
	
	public int update(MemberDTO dto) { // ����
		// ���࿡ memberdto Ÿ���̵� ��ü�� ������ (���۷��� ������ �Ѱ���)
		conn();

		try {
			// sql ����
			String sql = "update MEMBER set pw=?, email=? where id=?";
			/* num.nextval ->������ �ڵ����� */
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
		// �μ�Ʈ (�߰����Ǹ�) cnt = 1�̵ǿ� ������ 0�̶�� �����ߴٸ�
	}

	
	
	
	

}
