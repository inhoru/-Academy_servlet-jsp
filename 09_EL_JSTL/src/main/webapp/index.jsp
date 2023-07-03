<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>액션태그 활용하기</h2>
	<p>jsp페이지에서 java코드를 html태그 방식으로 작성할 수 있게 해주는 태크</p>
	<ul>
		<li>표준액션태그 : 기본 jsp에서 제공하는 태그</li>
		<li>커스텀 액션태크(JSTL) : 별도 jar파일로 제공하는 태그 *jar파일을 추가해야 사용이 가능</li>
	</ul>
	<h3>표준액션태크 이용하기</h3>
	<p>태그를 작성할때 jsp prefix를 사용함</p>
	<%-- 	예)<jsp:태그명></jsp:태그명> --%>
	<h3>jsp:include태그 활용하기</h3>
	<p>다른 jsp페이지를 불러와 출력해주는 태그</p>
	<%-- <%@ include %> 태그와 비슷 한 기능 --%>
	<p>jsp : include page="불러올페이지경로작성"</p>
	<a href="<%=request.getContextPath()%>/views/includeTest.jsp">jsp:include테스트</a>

	<h3>커스텀액션태그 -> JSTL이용하기</h3>
	<h4>EL표현식활용하기</h4>
	<p>java코드로 생성된 데이터를 페이지에 출력해주는 표현식</p>
	<p><%-- ${ } --%>->공용객체(request,session,Application) 저장된 데이터를 불러와 출력함</p>
	<h3>
		<a herf="<%=request.getContextPath()%>/views/el/elest.jsp">EL사용하기</a>
	</h3>

</body>
</html>