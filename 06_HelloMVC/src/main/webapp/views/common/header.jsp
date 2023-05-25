<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.web.member.model.dto.MemberDTO" %>
<%
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloMVC</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
</head>
<body>
    <div id="container">
        <header>
            <h1>HelloMVC</h1>
            <div class="login-container">
                <%if(loginMember==null){%>
                <form action="<%=request.getContextPath()%>/membercheck.do" id="loginFrm" method="post">
                    <table>
                        <tr>
                            <td>
                                <input type="text" name="userId" id="userId" placeholder="아이디">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="password" name="password" id="password" placeholder="패스워드" method="post">
                            </td>
                            <td>
                                <input type="submit" value="로그인">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label><input type="checkbox" name="saveId" id="saveId" for="saveId">아이디 저장</label>
                                <input type="button" value="회원가입">
                            </td>
                        </tr>
                    </table>
                </form>
                <%}else{ %>
                	<table id="logged-in">
                        <tr>
                            <td colspan="2">
                                <%=loginMember.getUserName()  %>님, 안녕하시지~ :)
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="button" value="내 정보 보기">
                            </td>
                            <td>
                                <input type="button" value="로그아웃">
                            </td>
                        </tr>

                    </table>
                <%} %>
            </div>
            <nav>
                <ul class="main-nav">
                    <li class="home"><a href="">Home</a></li>
                    <li class="notice"><a href="">공지사항</a></li>
                    <li class="borad"><a href="">게시판</a></li>
                </ul>
            </nav>
        </header>