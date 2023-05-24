package com.servlet.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="enrollMember",urlPatterns = {"/enrollMember.do"})
public class EnrollMemberServlet extends HttpServlet{

	
	private static final long serialVersionUID = 8943647513626935483L;
	
	public EnrollMemberServlet() {
		
	
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//post방식으로 보냇을떄 영어랑 숫자를 제외한 글자는 꺠진다.
		//인코딩처리하자!
		//HttpServletRequest.setCharacterEncoding()메소드 이용
		req.setCharacterEncoding("UTF-8");
		String id= req.getParameter("id");
		String password= req.getParameter("password");
		String name=req.getParameter("name");
		String nickname=req.getParameter("nickname");
		String email=req.getParameter("email");
		String[] hobby=req.getParameterValues("hobby");
		String marriage=req.getParameter("marriage");
		
		System.out.println(id);
		System.out.println(password);
		System.out.println(name);
		System.out.println(nickname);
		System.out.println(email);
		System.out.println(Arrays.toString(hobby));
		System.out.println(marriage);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//자기자신의 doGet를 불러온다. 
		//post로보내나 get으로보내나 doGet이실행된다.
		this.doGet(req,resp);
	}
	
	
}
