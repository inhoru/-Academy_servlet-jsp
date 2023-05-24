package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherViewServlet
 */
@WebServlet("/dispatcherView.do")
public class DispatcherViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DispatcherViewServlet 실행!");
		
		
		
//		RequestDispatcher rd=request.getRequestDispatcher("/dispatcherView.do");
//		rd.forward(request, response);
		// 위에서 여기로 보낸 데이터도 바로사용이가능하다 왜냐하면 주소가 바뀌지않기때문이다.

//		request.getParameterMap().entrySet()
//		.forEach(System.out::println);

		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		double height = Double.parseDouble(request.getParameter("height"));
		String color = request.getParameter("color");
		String[] animals2 = request.getParameterValues("animal");
		String lunch = request.getParameter("lunch");
		String info = request.getParameter("info");
		
		//setAttribute로 저장된 데이터 가져오기
		//HttpServletRequest.getAttribute("key값")메소드를 이용
		String data=(String)request.getAttribute("testData");//반환값은 Object(형변환이가능하다.)

		response.setContentType("text/html;charset=utf-8");
		// 2. 응답데이터 보내기
		// 1)문자열데이터 : 문자열 스트림으로 전송 -> getWriter();
		// 2)바이너리데이터 : 파일 스트림으로 전송 -> getOutputStream();
		PrintWriter out = response.getWriter();
		// 3. 원하는 데이터 전송하기
		out.write("<h3>내가 만든 첫 응답페이지</h3>");

		String html = "<html>";
		html += "<head>";
		html += "<title>개인취향테스트</title>";
		html += "</head>";
		html += "<body>";
		html += "<h3>개인취향결과</h3>";
		html +="<h1>getAttribuyte값 : "+data+"</h1>";
		html += "<h4>" + name + "님의 개인취향 확인결과</h4>";
		html += "<h4>당신의 이름은" + name + "이고 나이는" + age + "살 이고, ";
		html += "키는 " + height + "cm입니다.</h4>";
		html += "<h4>좋아하는 색은 <span style='color:" + color + "'>" + color + "</span>";
		html += "입니다.</h4>";
		html += "<ul>좋아하는 동물";
		for (String animal : animals2) {
			String src = "";
			switch (animal) {
			case "강아지":
				src = "https://image.dongascience.com/Photo/2020/03/5bddba7b6574b95d37b6079c199d7101.jpg";
				break;
			case "고양이":
				src = "https://i.namu.wiki/i/PdTjBRRO3itMFTmxOK9OpV6RF-Awabg2Re6I3D2BJy6eSMwE41B7WhvRZ0j_7rbNcogNsNUxkZlAHiVGuHjb9w.webp";
				break;
			case "펭귄":
				src = "https://i1.sndcdn.com/artworks-cDzKQJGISQrJvOrp-xc9rnA-t500x500.jpg";
				break;
			case "기린":
				src = "https://ichef.bbci.co.uk/news/1024/branded_korean/10814/production/_115540676_photocredit-ishaqbini.jpg";
				break;
			}
			html += "<li><img src='" + src + "' width=200 height=200></li>";
		}
		html += "</ul>";
		html += "<P>오늘의 점심은 " + lunch + "입니다.</p>";
		html += "<h3>당신은 " + info + "</h3>";
		html += "</body>";
		html += "</html>";
		out.write(html);
		
		

	}
	
	

	// .forEach(e-> System.out.println(e));

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
