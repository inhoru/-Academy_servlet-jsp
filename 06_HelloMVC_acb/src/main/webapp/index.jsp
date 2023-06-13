<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/views/common/header.jsp" %>
<section id="content">
	<h2 align="center" style="margin-top:200px">
		안녕하세요,MVC입니다.
	</h2>
	<button id="memberAll">전체회원조회</button>
	<input type="text" id="id"><button>아이디조회</button>
	<div id="memberList"></div>
	<script>
	$("#memberAll").click(e=>{
		$.get("<%=request.getContextPath()%>/memberAll.do",
				data=>{
					const table=$("<table>");
					const header=$("<tr>");
					const headerdata=["아이디","이름","나이","성별","이메일","전화번호","주소","취미","가입일"];
					headerdata.forEach(e=>{
						const th=$("<th>").text(e);
						header.append(th);
					});
					table.append(header);
					data.forEach(m=>{
						const tr=$("<tr>");
							tr.append($("<td>").text(m.userId));
							tr.append($("<td>").text(m.userName));
							tr.append($("<td>").text(m.age));
							tr.append($("<td>").text(m.gender));
							tr.append($("<td>").text(m.email));
							tr.append($("<td>").text(m.phone));
							tr.append($("<td>").text(m.address));
							tr.append($("<td>").text(m.hobby));
							tr.append($("<td>").text(m.enrollDate));
						table.append(tr);
						});
					$("#memberList").html(table);
					})
				});
	
	$("#id").next().click(e=>{
	if($("#id").val()!==""){	
		$.get("<%=request.getContextPath()%>/searchMember.do?id="+$("#id").val(),
				data=>{
					const table=$("<table>");
					const header=$("<tr>");
					const headerdata=["아이디","이름","나이","성별","이메일","전화번호","주소","취미","가입일"];
					headerdata.forEach(e=>{
						const th=$("<th>").text(e);
						header.append(th);
					});
					table.append(header);
					data.forEach(m=>{
						const tr=$("<tr>");
							tr.append($("<td>").text(m.userId));
							tr.append($("<td>").text(m.userName));
							tr.append($("<td>").text(m.age));
							tr.append($("<td>").text(m.gender));
							tr.append($("<td>").text(m.email));
							tr.append($("<td>").text(m.phone));
							tr.append($("<td>").text(m.address));
							tr.append($("<td>").text(m.hobby));
							tr.append($("<td>").text(m.enrollDate));
						table.append(tr);
						});
					$("#memberList").html(table);
					})
	}
				});
	</script>
</section>
<%@ include file="/views/common/footer.jsp" %>		
