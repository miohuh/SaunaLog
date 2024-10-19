<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String error = (String)request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<body>
<jsp:include page="/WEB-INF/jsp/nav.jsp" />

	<div class="container">
	<% if (error != null) { %>
		<p><%=error %></p>
	<% } %>
	 <form action="Login" method="post" class="login-form">
        <div class="login-group">
            <label for="id">ID：</label>
            <input type="text" name="id" id="id">
        </div>
        <div class="login-group">
            <label for="pass">PASS：</label>
            <input type="password" name="pass" id="pass">
        </div>
        <div class="login-group">
            <input type="submit" value="ログイン">
        </div>
    </form>
	</div>

</body>
</html>