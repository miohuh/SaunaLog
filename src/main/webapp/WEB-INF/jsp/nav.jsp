<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<nav>
		<a href="index.jsp"><img src="images/SaunaLog_logo2.png" alt="Sauna Log" class="logo"> </a> 
		<a href="index.jsp">Home</a>
		<a href="Login">Record</a> 
		<a href="Search">View</a>
		<form action="Search" method="post" class="search-form">
			<input type="text" name="word" placeholder="サウナを探す…"class="search-input">
			<input type="submit" value="Search" class="search-button">
		</form>
	</nav>
	
	
	<!-- ----------------------------------------------------------------------------------- -->

	<div class="menu-container">
		<div class="menu-button" onclick="toggleMenu()">MENU</div>
		<div class="menu-content">
			<nav>
				<a href="index.jsp">Home</a> <a href="Login">Record</a> 
				<a href="Search">View</a>
			</nav>
			<form action="Search" method="post" style="display: inline-block; margin-top: 20px;">
				<input type="text" name="word" placeholder="サウナを探す…" class="search-input"> 
				<input type="submit" value="Search" class="search-button">
			</form>
		</div>
	</div>

