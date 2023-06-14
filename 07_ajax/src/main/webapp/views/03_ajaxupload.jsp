<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>ajax파일 업로드시키기</title>
<script src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
	<h2>ajax를 이용해서 파일 업로드하기</h2>
	<input type="file" id="upFile" multiple>
	<button id="uploadBtn">업로드파일</button>
	<script>
		$("#uploadBtn").click(e=>{
			//js가 제공하는 FormData클래스를 이용함.
			const form=new FormData();
			//append로 서버에 전송할 데이터를 넣을 수 있음.
			//key:value형식으로 저장
			const fileInput=$("#upFile");
			console.log(fileInput);
			$.each(fileInput[0].files,(i,f)=>{
				form.append("upfile"+i,f);
			});
			form.append("name","유병승");
			$.ajax({
				url:"<%=request.getContextPath()%>/fileUpload",
				data:form,
				type:"post",
				processData:false,
				contentType:false,
				success:data=>{
					alert("업로드가 완료되었습니다.")
				},error:(r,m)=>{
					alert("업로드실패했습니다."+m);
				},complete:()=>{
					$("#upFile").val('');	
				}
			});
		});
	</script>
	
	<h2>업로드 이미지 미리보기 기능</h2>
	<img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQYAAADACAMAAADRLT0TAAAAJFBMVEXl5eX////29vbm5ubz8/P8/Pz5+fnv7+/p6enx8fHs7Ozi4uI2AdhhAAADuElEQVR4nO2c25KjIBBAjVxE/P//XSVCkh3MApuMNnXOvEzNpFJybFouLcMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAPBl1PozDG7WxUzq7Gv+EkrbWzlm9Gdf8BdY722NhCBiOvuiv8CiKy2sHnqLhzUWVLWF223sLz/MDRpsZ+GghqU2M2x0mB1aNNz60rB28aZo6EtDSHRf0XC1FKr+eUUf1bA9eVT8TRKf7RTCGp9YGjUs+S/77csvZ71BXo/HmBYN9vj79OTObnIW19bSZoyZz25yBve7EgL67Eb/pKnv/ydXG2WqwZ9gYc0dF8sPy3iKhquFw3KKhctlBzQE0BBAQwANATQE0BBo1WDbp129aLCzi0snyus2FdI1mNG9rBosi2uZlcjWYHRmMrA0TFJFazB+ya2jLcNcK0KyhnEPhYwJX9kzBGvYdiaza6rbYnOlB7katlh4s7JclynFavjLgnPeuxcrviY/SNVg3dPejptHa421VvsnEzV5UqiG+3LRvc1Om9RgY5/WkSpWsoRqeCrcmF5vunn8q2L8IFPDUxnPz7IPm5JGeX2QTA3hqrfUoHLFLyZ+myoOB5EaQjCEO55fz7dxmlEcDiI12Nj9j+rBpt2S61rD3ieO77aJnkrHUBI1pAR5XBx4b5Yq7hUiNcR7fVwcGLtN6V6gRA02fvo45GPAlBaTStQwxk8fPw9jzULpcEyihnjN754DuuL7BGvY+v67jh81FA6gRGrYR0fvNOwdp7RirHcNHUdDTJEFuWEosyBSQ3pgHn8kla90rCHNII/XVcy+aF06qRCpIe7RHCeHe8CoYepYw22OCyuHCXDvE8UVZSI1pGHk0c2OU4ridReRGlKvUAfDgjgFLe0TMjXcUpVzfjMi/bt4y0amBpv2anIe4mC7YsdGpoZH0bv62VS9KQj7m+UbFTI1xCLn8N76a2ONj6Uvy9T7PkXar7nH/iMFGP3Y5q6p9pCqYU2DTyLCJqYdtR+W9DdVU4UuVkOYNcThwdb69ObUrqfqlXaxGraKn1x5w94p6iwI1vD2JYhKC5I1hHyYr3dxtW+nSNawPi/yJxJM1aWRsjXkCiOVbygaFq5hK+t4OstnWR+dtqVcWLyG7X1Sq713zvlZNznoQ8MnQAMa0IAGNKABDWhAAxoaNFzq0B91ypkm1zvGgkNNNhqOSP0I1zvyiAOP7vz68Vf2erEQXhaZ3h2G9nHma+UFAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIAu+AO6aTCvOHgMKAAAAABJRU5ErkJggg==" width="100" height="100" id="profile">
	<input type="file" style="display:none" id="profileInput" accept="image/*">
	
	<input type="file" id="upfiles" multiple accept="images/*">
	<div id="uploadpreview">
	
	
	</div>
	<script>
	 	$("#profile").click(e=>{
	 		$("#profileInput").click();
	 	});
	 	
	 	$("#profileInput").change(e=>{
	 		const reader=new FileReader();
	 		reader.onload=e=>{
	 			//e.target.result속성에 변경된 file이 나옴.
	 			$("#profile").attr("src",e.target.result);
	 		}
	 		reader.readAsDataURL(e.target.files[0]);
	 	});
	 	
	 	$("#upfiles").change(e=>{
			$("#uploadpreview").html('');
	 		const files=e.target.files;
	 		$.each(files,(i,f)=>{
	 		const reader =new FileReader();
			reader.onload=e=>{
				const img=$("<img>").attr({
					src:e.target.result,"width" :"100","height":"100"
				});
				$("#uploadpreview").append(img);
			}	
			reader.readAsDataURL(f);
	 		})
	 		
	 	})
	 	
		
	 	
	 	
	</script>
	<style>
		#profile{
		border-radius:100px;
		border:3px solid yellow;
	}
	</style>
</body>
</html>