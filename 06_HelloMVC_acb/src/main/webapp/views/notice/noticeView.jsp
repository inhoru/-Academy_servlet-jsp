<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.web.notice.model.vo.Notice" %>
<%@ include file="/views/common/header.jsp" %>
<%
Notice n=(Notice)request.getAttribute("notice");

%>
 <style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    div.dowonload-container{
    	cursor: pointer;
    }
    </style>
<section id="notice-container">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><%=n.getNoticeTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%=n.getNoticeWriter() %></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            
            <td>
           	<%if(n.getFilePath()!=null) {%>
           	<div class="dowonload-container" onclick="fileDownload('<%=n.getFilePath()%>');">
           		<img src="<%=request.getContextPath()%>/images/file.png" width="20">
           		<span><%=n.getFilePath() %></span>
           	</div>
           	<%} %>
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%=n.getNoticeContent() %></td>
        </tr>
        <%if(loginMember!=null&&
        	(loginMember.getUserId().equals("admin")||
        			loginMember.getUserId().equals(n.getNoticeWriter()))){%>
        			
        <tr>
            <th colspan="2">
                <input type="button" value="수정하기" onclick="">
                <input type="button" value="삭제하기" onclick="">
            </th>
        </tr>
        <%} %>
    </table>
    <script>
const fileDownload=(filename)=>{
	location.assign("<%=request.getContextPath()%>/fileDownload.do?name="+filename)
	alert("파일다운로드");
}    
    
    </script>
    </section>
<%@ include file="/views/common/footer.jsp" %>