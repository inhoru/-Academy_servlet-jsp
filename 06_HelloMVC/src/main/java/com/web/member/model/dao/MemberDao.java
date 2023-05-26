package com.web.member.model.dao;

import static com.web.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.web.member.model.dto.MemberDTO;

public class MemberDao {
	private Properties sql = new Properties();// final로 설정하느게좋다 변할일이없기에
	{
		String path = MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public MemberDTO checkMember(Connection conn,String userId, String password){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO m=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("checkMember"));
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=getMember(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
	public int addMembers(Connection conn, MemberDTO m){
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("addMembers"));
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, String.valueOf(m.getGender()));
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, String.join(",",m.getHobby()));
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	public MemberDTO selectByUserId(Connection conn, String userId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO m = null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectByUserId"));
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=getMember(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	
		
		private MemberDTO getMember(ResultSet rs) throws SQLException{
			return MemberDTO.builder()
					.userId(rs.getString("userid"))
					.password(rs.getString("password"))
					.userName(rs.getString("username"))
					.age(rs.getInt("age"))
					.gender(rs.getString("gender").charAt(0))
					.email(rs.getString("email"))
					.phone(rs.getString("phone"))
					.address(rs.getString("address"))
					.hobby(rs.getString("hobby").split(","))
					.enrollDate(rs.getDate("enrolldate"))
					.build();
		
	}
}
