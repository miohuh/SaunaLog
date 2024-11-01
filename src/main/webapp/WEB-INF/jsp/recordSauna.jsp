<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/nav/header.jsp" />
<body>
<jsp:include page="/WEB-INF/jsp/nav/nav.jsp" />

	<div class="container">
		<h1>データ登録</h1>
		<% if (msg != null) { %>
			<p><%=msg%></p>
		<% } %>
		<form action="Save" method="post"class="record-form">
			<div class="form-group">
				<label>施設名：</label> <input type="text" name="name">
			</div>
			<div class="form-group">
				<label for="type">施設タイプ：</label> <select name="type" id="type">
					<option value="温浴施設">温浴施設</option>
					<option value="プライベートサウナ">プライベートサウナ</option>
					<option value="男性専用">男性専用</option>
					<option value="女性専用">女性専用</option>
					<option value="キャンプ・グランピング施設">キャンプ・グランピング施設</option>
					<option value="その他">その他</option>
				</select>
			</div>
			<div class="form-group">
				<label for="adress">住所：</label> <input type="text" name="adress" id="adress">
			</div>
			<div class="form-group">
				<label for="url">URL：</label> <input type="url" name="url" id="url">
			</div>
			<div class="form-group">
				<label for="impression">感想：</label>
				<textarea name="impression" id="impression" rows="4" cols="60"></textarea>
			</div>
			<div class="form-group">
				<label for="point1">＃：</label> <input type="text" name="point1" id="point1">
			</div>
			<div class="form-group">
				<label for="point2">＃：</label> <input type="text" name="point2" id="point2">
			</div>
			<div class="form-group">
				<label for="point3">＃：</label> <input type="text" name="point3" id="point3">
			</div>
			<div class="form-group">
				<label for="star">☆：</label> <select id="star" name="star">
					<option value="1">１</option>
					<option value="2">２</option>
					<option value="3" selected>３</option>
					<option value="4">４</option>
					<option value="5">５</option>
				</select>
			</div>
			<input type="submit" value="確認する">
			<br>
			<br>
			<br>
		</form>
	</div>


</body>
</html>