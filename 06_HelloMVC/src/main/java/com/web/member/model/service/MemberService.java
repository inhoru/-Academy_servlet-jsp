package com.web.member.model.service;

import static com.web.member.common.JDBCTemplate.close;
import static com.web.member.common.JDBCTemplate.commit;
import static com.web.member.common.JDBCTemplate.getConnection;
import static com.web.member.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.web.member.model.dao.MemberDao;
import com.web.member.model.dto.MemberDTO;
public class MemberService {
	private MemberDao dao= new MemberDao();
	
	public MemberDTO checkMember(String userId,String password){
		Connection conn=getConnection();
		MemberDTO m=dao.checkMember(conn,userId,password);
		close(conn);
		return m;
		
		
		
	}
	
	public int addMembers(MemberDTO m){
		Connection conn=getConnection();
		int result =dao.addMembers(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result; 
		
	}
	public MemberDTO selectByUserId(String userId) {
		Connection conn=getConnection();
		MemberDTO m=dao.selectByUserId(conn,userId);
		close(conn);
		return m;
	}
	public int memberUpdate(MemberDTO m) {
		Connection conn=getConnection();
		int result =dao.memberUpdate(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	public int updatePasswordEnd(MemberDTO m,String password_new) {
		Connection conn=getConnection();
		int result =dao.updatePasswordEnd(conn,m,password_new);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
}
	
