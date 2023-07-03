<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jstl을 적용하기 위해서는 반드시 페이지에 지시자로 taglib를 선언해야한다. -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core태그 활용하기</title>
</head>
<body>
<h3><c:out value="우와 코어태그로출력"/></h3>

<h2>set/out태그 이용하기</h2>
<p>
	c:out태그 : value속성에 있는 값을 페이지에 출력할 때 사용하는 태그<br/>
	c:set태그 : 내장객체영역에 데이터를 key value형식으로 저장할때 사용하는 태그<br/>
</p>
<ul>c:set태그 속성
	<li>var : key값(변수명)</li>
	<li>value : key에 저장될 값/ EL표현식, 리터럴 사용</li>
	<li>scope : 변수가 선언될 내장객체를 지정, request, session, application</li>
</ul>
<ul>c:out태그 속성
	<li>value : 출력될 데이터, EL표현식, 리터럴을 사용 </li>
	<li>default : 출력될 데이터가 없을때 대체로 출력하는 값</li>
	<li>escapeXml : value속성에 태그형식으로 작성했을때 태그로 해석할지 여부를 선택</li>
</ul>
<h3>변수선언하기</h3>
<c:set var="comment" value="점심 맛있게 먹었나요?"/>
<p>${comment }</p>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<p>절대경로 : ${path }</p>
<c:set var="test" value="requestData" scope="request"/>
<c:set var="test" value="sessionData" scope="session"/>
<c:set var="test" value="applicationData" scope="application"/>
<p>${test }</p>
<p>${sessionScope.test }</p>
<p>${applicationScope.test }</p>

<h3>c: out 태그로 데이터 출력하기</h3>
<p><c:out value="점심은 뭐드셨나요?"></c:out>
<p><c:out value="${path }"></c:out>
<!--밑에처럼 해도 위에랑 똑같은데 왜 위처럼할까? 보안때문이다.  -->
<p>${path }</p>
<!--예를 들어  -->
<c:set value="<script>location.assign('http://www.naver.com');</script>" var="testData"/>
<!--이렇게하면 바로 네이버로 이동을해서 피싱사이트로 이동하수도있다 -->
<%-- <div>${testData }</div> --%>
<!--이러면 바로이동하지않고 코드만 출려해줄수있다 -->
<div><c:out value="${testData }"/></div>
<!-- xml을 이용해서 스크립트문이왓을때 이동시킬지 말지 정할수가있다. -->
<div><c:out value="${testData }" escapeXml="true"/></div>

<p>${test11==null?"없음":test11 }</p>
<c:set value="있는값" var="test11"/>
<p><c:out value="${test11 }" default="없음"/></p>

<h3>c:url</h3>
<p>링크되는 주소값 데이터를 저장하는 태그 == c:set</p>
<c:url var="cesearch" value="http://search.naver.com/search.naver">
<c:param name="query" value="김찬은"/>
</c:url>
<a href="<c:out value='${cesearch}'/>">검색</a>










</body>
</html>