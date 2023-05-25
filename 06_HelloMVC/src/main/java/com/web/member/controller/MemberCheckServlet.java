package com.web.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.member.model.dto.MemberDTO;
import com.web.member.model.service.MemberService;

/**
 * Servlet implementation class MemberCheckServlet
 */
@WebServlet("/membercheck.do")
public class MemberCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	String userId=request.getParameter("userId");
	String password=request.getParameter("password");
		
		
		MemberDTO loginMember=new MemberService().checkMember(userId,password);
		//System.out.println(loginMember);
		//loginMember null을 기준으로 로그인처리여부를 결정가능
		if(loginMember!=null) {
			//로그인성공 -> 인증받음
			HttpSession session=request.getSession(true);
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath());
		}else {
			//로그인실패 -> 인증못받음
			//실패메세지 출력
			request.setAttribute("msg", "아이디,패스워스가 일치하지않습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
