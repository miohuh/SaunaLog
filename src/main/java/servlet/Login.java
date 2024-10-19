package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginData;
import model.LoginLogic;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		LoginData loginData = (LoginData) session.getAttribute("loginData");

		String path = "";
		
		if (loginData == null) {
			path = "WEB-INF/jsp/login.jsp";
		} else {
			path = "WEB-INF/jsp/recordSauna.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		LoginLogic logic = new LoginLogic();
		boolean login = logic.logincheck(id, pass);

		String path = "";

		if (login) {
			LoginData loginData = new LoginData(id, pass);
			HttpSession session = request.getSession();
			session.setAttribute("loginData", loginData);
			path = "WEB-INF/jsp/recordSauna.jsp";
		} else {
			path = "WEB-INF/jsp/login.jsp";
			request.setAttribute("error", "IDとPASSWARDが違います");
		}
		path = "WEB-INF/jsp/recordSauna.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

	}

}
