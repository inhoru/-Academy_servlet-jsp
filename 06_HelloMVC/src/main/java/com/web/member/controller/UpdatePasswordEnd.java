package com.web.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.member.model.dto.MemberDTO;
import com.web.member.model.service.MemberService;

/**
 * Servlet implementation class changePassword
 */
@WebServlet("/member/updatePasswordEnd.do")
public class UpdatePasswordEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password_new=request.getParameter("password_new");
		HttpSession session2=request.getSession(true);
		String userId=(String)session2.getAttribute("userId");
		
		MemberDTO m=MemberDTO.builder().userId(userId).build();
		
		int result=new MemberService().updatePasswordEnd(m,password_new);
		String msg="",loc="";
		if(result>0) {
			msg="비밀번호가 변경되었습니다.";
			loc="/member/memberView.do";		
		}else {
			msg="현재비밀번호가 틀립니다.";
			loc="/member/updatePasswordEnd.do";		
		}
		
		request.getRequestDispatcher("/views/member/updatePasswordEnd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
