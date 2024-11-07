<%@page import="model.SaunaData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
SaunaData saunaData = (SaunaData)session.getAttribute("saunaData");
%>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/nav/header.jsp" />
<body>
<jsp:include page="/WEB-INF/jsp/nav/nav.jsp" />

	<div class="container">
	<% if (saunaData == null) { %>
		<h1>データ登録</h1>
	<% } else { %>
		<h1>データ更新</h1>
	<% } %>
		<% if (msg != null) { %>
			<p><%=msg%></p>
		<% } %>
		<form action="Save" method="post"class="record-form">
			<div class="form-group">
				<label>施設名：</label> <input type="text" name="name" <%if(saunaData != null){%>value="<%=saunaData.getName() %>"<%}%>>
			</div>
			<div class="form-group">
				<label for="type">施設タイプ：</label> <select name="type" id="type">
					<option value="温浴施設"<%if(saunaData != null && saunaData.getType().equals("温浴施設")){%> selected<%}%>>温浴施設</option>
					<option value="プライベートサウナ"<%if(saunaData != null && saunaData.getType().equals("プライベートサウナ")){%> selected<%}%>>プライベートサウナ</option>
					<option value="男性専用"<%if(saunaData != null && saunaData.getType().equals("男性専用")){%> selected<%}%>>男性専用</option>
					<option value="女性専用"<%if(saunaData != null && saunaData.getType().equals("女性専用")){%> selected<%}%>>女性専用</option>
					<option value="キャンプ・グランピング施設"<%if(saunaData != null && saunaData.getType().equals("キャンプ・グランピング施設")){%> selected<%}%>>キャンプ・グランピング施設</option>
					<option value="その他"<%if(saunaData != null && saunaData.getType().equals("その他")){%> selected<%}%>>その他</option>
				</select>
			</div>
			<div class="form-group">
				<label for="adress">住所：</label> <input type="text" name="adress" id="adress"<%if(saunaData != null){%>value="<%=saunaData.getAdress() %>"<%}%>>
			</div>
			<div class="form-group">
				<label for="url">URL：</label> <input type="url" name="url" id="url" <%if(saunaData != null){%>value="<%=saunaData.getUrl() %>"<%}%>>
			</div>
			<div class="form-group">
				<label for="impression">感想：</label>
				<textarea name="impression" id="impression" rows="4" cols="60" ><%if(saunaData != null){ %> <%=saunaData.getImpression()%> <% } %></textarea>
			</div>
			<div class="form-group">
				<label for="point1">＃：</label> <input type="text" name="point1" id="point1"<%if(saunaData != null){%>value="<%=saunaData.getPoint1() %>"<%}%>>
			</div>
			<div class="form-group">
				<label for="point2">＃：</label> <input type="text" name="point2" id="point2"<%if(saunaData != null){%>value="<%=saunaData.getPoint2() %>"<%}%>>
			</div>
			<div class="form-group">
				<label for="point3">＃：</label> <input type="text" name="point3" id="point3"<%if(saunaData != null){%>value="<%=saunaData.getPoint3() %>"<%}%>>
			</div>
			<div class="form-group">
				<label for="star">☆：</label> <select id="star" name="star">
					<option value="1"<%if(saunaData != null && saunaData.getStar() == 1){%> selected<%}%>>１</option>
					<option value="2"<%if(saunaData != null && saunaData.getStar() == 2){%> selected<%}%>>２</option>
					<option value="3"<%if(saunaData != null && saunaData.getStar() == 3){%> selected<%}%>>３</option>
					<option value="4"<%if(saunaData != null && saunaData.getStar() == 4){%> selected<%}%>>４</option>
					<option value="5"<%if(saunaData != null && saunaData.getStar() == 5){%> selected<%}%>>５</option>
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