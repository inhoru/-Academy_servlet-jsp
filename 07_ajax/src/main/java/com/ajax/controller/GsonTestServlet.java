package com.ajax.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.web.admin.service.AdminService;
import com.web.member.model.vo.Member;

/**
 * Servlet implementation class GsonTestServlet
 */
@WebServlet("/gsontest.do")
public class GsonTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GsonTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Member> list=new AdminService().searchBykeyword("userId", "a", 1, 30);
		Member m=list.get(0);
		//Gson라이브러리를 이용해서 json파싱하기
		//Gson클래스를 생성한다.
		Gson gson=new Gson();
		//파싱해주는 메소드를 제공 -> toJson("Json으로 변경할객체","[outputStream]");
		response.setContentType("application/json;charset=utf-8");
		gson.toJson(m,response.getWriter());
//		리스톨 할떄 list 쓴다
//		gson.toJson(list,response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}