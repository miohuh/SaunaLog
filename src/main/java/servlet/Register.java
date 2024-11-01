package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginLogic;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		String msg = "";
		
		if (id == null || id.length() == 0) {
			msg += "IDが入力されていません<br>";
		}
		if (pass == null || pass.length() == 0) {
			msg += "PASSWORDが入力されていません<br>";
		}
		
		if (msg == null || msg.length() == 0) {
			LoginLogic logic = new LoginLogic();
			boolean checker = logic.inputCheck(id, pass);
			
		}
		
		
	}

}
