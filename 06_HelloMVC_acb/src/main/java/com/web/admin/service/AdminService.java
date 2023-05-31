package com.web.admin.service;

import static com.web.common.JDBCTemplate.close;
import static com.web.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.web.admin.dao.AdminDao;
import com.web.member.model.vo.Member;

public class AdminService {
	private AdminDao dao=new AdminDao();
	
	public List<Member> selectMemberAll(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberAll(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	public int selectMemberCount() {
		Connection conn=getConnection();
		int result =dao.selectMemberCount(conn);
		close(conn);
		return result;
	}
	
	public List<Member> searchBykeyword(String keyword, String type){
		Connection conn=getConnection();
		List<Member> list=dao.searchBykeyword(conn,keyword,type);
		close(conn);
		return list;
		
	}
}
