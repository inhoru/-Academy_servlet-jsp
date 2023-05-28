<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.web.member.model.dto.MemberDTO"%>
	<%
	MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div#updatePassword-container {
	
}

div#updatePassword-container table {
	margin: 0 auto;
	border-spacing: 20px;
}

div#updatePassword-container table tr:last-of-type td {
	text-align: center;
}

</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
</head>
<body>
	<div id="updatePassword-container">
		<form name="updatePwdFrm"
			action="<%=request.getContextPath()%>/member/updatePasswordEnd.do"
			method="post" onsubmit=""> 
			<table>
				<tr>
					<th>현재 비밀번호</th>
					<td><input type="password" name="password" id="password"
						required></td>
				</tr>
				<tr>
					<th>변경할 비밀번호</th>
					<td><input type="password" name="password_new"
						id="password_new" required></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="password_chk" required><br>
					</td>
				</tr>
				<tr>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="변경" onclick="return fn_validate3();"/>&nbsp; 
					<input type="button" value="닫기" ></td>
				</tr>
			</table>

		</form>
	</div>

</body>
<script>
	$("#password_chk").keyup(e=>{
	const password=$("#password_new").val();
	const passwordCheck=$(e.target).val();
	let color,msg;
	if(password==passwordCheck){
		color="green";msg="비밀번호가 일치합니다."
	}else{
		color="red";msg="비밀번호가 일치하지않습니다."
	}
	const td =$(e.target).parents("tr").next().find("td").html("");
	$("<p>").css("color",color).text(msg).appendTo(td);
	
});
	const fn_validate3=()=>{
		const password=$("#password").val();
		if(password!=<%=loginMember.getPassword()%>){
			alert("현재비밀번호가 틀립니다.")
			return false;
		}else{
			alert("비밀번호가 변경되었습니다.")		
		}
	};
	const btn=document.querySelector("input[type=button]");
	btn.addEventListener("click",e=>{
		close();
	});
</script>
</html>