<%@page import="model.SaunaData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
SaunaData data = (SaunaData)request.getAttribute("data");
%>

<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/nav/header.jsp" />
<body>
<jsp:include page="/WEB-INF/jsp/nav/nav.jsp" />

	<div class="container sauna-info">
    <p class="id">ID：<%=data.getId() %></p> <!-- IDを段落の外に移動 -->
    <h1><%=data.getName() %></h1>
    <div class="rating-type">
        <p class="rating">☆：<%=data.getStar() %>　　　　タイプ：<%=data.getType() %></p>
    </div>
    <p><a href="https://www.google.co.jp/maps/place/<%=data.getAdress() %>"><%=data.getAdress() %></a></p>
    <p><a href="<%=data.getUrl() %>"><%=data.getUrl() %></a></p>
    <p class="point">＃<%=data.getPoint1() %> ＃<%=data.getPoint2() %> ＃<%=data.getPoint3() %></p>
    <p class="impression"><%=data.getImpression() %></p>
</div>


	
</body>
</html>