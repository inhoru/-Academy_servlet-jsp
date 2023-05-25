package com.web.member.model.service;

import static com.web.member.common.JDBCTemplate.close;
import static com.web.member.common.JDBCTemplate.getConection;

import java.sql.Connection;

import com.web.member.model.dao.MemberDao;
import com.web.member.model.dto.MemberDTO;
public class MemberService {
	private MemberDao dao= new MemberDao();
	
	public MemberDTO checkMember(String userId,String password){
		Connection conn=getConection();
		MemberDTO m=dao.checkMember(conn,userId,password);
		close(conn);
		return m;
		
		
		
	}
}
