<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<String> resultNameList = (List<String>) request.getAttribute("resultNameList");
String word = (String)request.getAttribute("word");
%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<body>
<jsp:include page="/WEB-INF/jsp/nav.jsp" />

	<div class="container search-results">
    <h1>検索結果</h1>
    <% if (resultNameList == null || resultNameList.isEmpty()) { %>
        <p><%=word %>を含むサウナは登録されていません</p>
    <% } else { %>
        <ul>
            <% for (String name : resultNameList) { %>
                <li><a href="Select?name=<%= name %>"><%= name %></a></li>
            <% } %>
        </ul>
    <% } %>
</div>

</body>
</html>