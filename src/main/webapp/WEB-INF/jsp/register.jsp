<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/jsp/nav/header.jsp" />
<body>
<jsp:include page="/WEB-INF/jsp/nav/nav.jsp" />

	<div class="container">
	<% if (msg != null) { %>
		<p style="color: crimson;"><%=msg %></p>
	<% } else { %>
		<p style="color: #808080;">"ID"は3～20文字、アルファベットと数字が使用可能です<br>"PASSWORD"は8～20文字、英大文字・英小文字・数字を必ず使用してください<br></p>
	<% } %>
	 <form action="Register" method="post" class="login-form">
        <div class="login-group">
            <label for="id">ID：</label>
            <input type="text" name="id" id="id">
        </div>
        <div class="login-group">
            <label for="pass">PASS：</label>
            <input type="password" name="pass" id="pass">
        </div>
        <div class="login-group">
            <input type="submit" value="登録">
        </div>
    </form>
	</div>

</body>
</html>