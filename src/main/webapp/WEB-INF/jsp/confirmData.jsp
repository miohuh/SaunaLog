<%@page import="model.SaunaData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
SaunaData data = (SaunaData) session.getAttribute("data");
String msg = (String) request.getAttribute("msg");
%>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/nav/header.jsp" />

<body>
<jsp:include page="/WEB-INF/jsp/nav/nav.jsp" />

	<div class="container sauna-info">
		<h1>登録確認</h1>
		<% if (msg != null) { %>
		<p><%=msg%></p>
		<% } %>
		
		<p>施設名：<%=data.getName()%></p>
		<p>施設タイプ：<%=data.getType()%></p>
		<p>住所：<%=data.getAdress()%></p>
		<p>URL：<%=data.getUrl()%></p>
		<p>感想：<%=data.getImpression()%></p>
		<p>＃：<%=data.getPoint1()%></p>
		<p>＃：<%=data.getPoint2()%></p>
		<p>＃：<%=data.getPoint3()%></p>
		<p>☆：<%=data.getStar() %></p>
		
		<form action="Save2" method="post">
			<input type="submit" value="保存">
		</form>
	</div>
	
</body>
</html>