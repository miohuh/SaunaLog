<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<String> resultNameList = (List<String>) request.getAttribute("resultNameList");
String word = (String)request.getAttribute("word");
%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/nav/header.jsp" />
<body>
<jsp:include page="/WEB-INF/jsp/nav/nav.jsp" />

	<div class="container search-results">
    <h1>検索結果</h1>
    <% if (resultNameList == null || resultNameList.isEmpty()) { %>
        <p><%=word %>を含むサウナは登録されていません</p>
    <% } else { %>
    <form action="Update" method="get">
        <ul>
            <% for (String name : resultNameList) { %>
                <li><input type="radio" name="action" value="<%=name %>"><a href="Select?name=<%= name %>"><%= name %></a></li>
            <% } %>
        </ul>
	</form>
    <% } %>
</div>

</body>
</html>