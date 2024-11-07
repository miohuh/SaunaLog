<%@page import="model.SaunaData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
SaunaData saunaData = (SaunaData)session.getAttribute("saunaData");
String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/nav/header.jsp" />

<body>
<jsp:include page="/WEB-INF/jsp/nav/nav.jsp" />

	<div class="container sauna-info">
	<% if (saunaData.getId() == 0) { %>
		<h1>登録確認</h1>
	<% } else { %>
		<h1>編集確認</h1>
	<% } %>	
		<% if (msg != null) { %>
		<p><%=msg%></p>
		<% } %>
		
		<p>施設名：<%=saunaData.getName()%></p>
		<p>施設タイプ：<%=saunaData.getType()%></p>
		<p>住所：<%=saunaData.getAdress()%></p>
		<p>URL：<%=saunaData.getUrl()%></p>
		<p>感想：<%=saunaData.getImpression()%></p>
		<p>＃：<%=saunaData.getPoint1()%></p>
		<p>＃：<%=saunaData.getPoint2()%></p>
		<p>＃：<%=saunaData.getPoint3()%></p>
		<p>☆：<%=saunaData.getStar() %></p>
		
		
		<% if (saunaData.getId() == 0) { %>
			<form action="Save2" method="post">
				<input type="submit" value="保存">
			</form>
		<% } else { %>
			<form action="Update" method="post">
				<input type="submit" value="更新">
			</form>
		<% } %>	
	</div>
	
</body>
</html>