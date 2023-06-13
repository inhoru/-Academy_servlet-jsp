<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.web.member.model.vo.Member"%>
    <%
    List<Member> members = (List) request.getAttribute("membersAll");
    %>
<!DOCTYPE html>
<table id="tbl-member">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입날짜</th>
			</tr>
			<%
			if (members.isEmpty()) {
			%>
			<tr>
				<td colspan="9">가입된회원이없습니다.</td>
			</tr>
			<%
			} else {
			for (Member m : members) {
			%>
			<tr>
				<td><%=m.getUserId()%></td>
				<td><%=m.getUserName()%></td>
				<td><%=m.getGender()%></td>
				<td><%=m.getAge()%></td>
				<td><%=m.getPhone()%></td>
				<td><%=m.getEmail()%></td>
				<td><%=m.getAddress()%></td>
				<td><%=Arrays.toString(m.getHobby()) %></td>
				<td><%=m.getEnrollDate()%></td>
			</tr>
			<%
			}
			}
			%>


		</thead>
	</table>