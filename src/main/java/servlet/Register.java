package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ErrorLogic;
import model.UsersLogic;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		String msg = "";
		ErrorLogic eLogic = new ErrorLogic();
		UsersLogic uLogic = new UsersLogic();
		
		//IDチェック
		if (id == null || id.length() == 0) {
			msg += "IDが入力されていません<br>";
		} else {
			msg += eLogic.checkesID(id);
			boolean checker = uLogic.inputCheck(id);
			if (!checker) {
				msg += "IDは既に登録されています<br>";
		}
		}
		
		//PASSWORDチェック
		if (pass == null || pass.length() == 0) {
			msg += "PASSWORDが入力されていません<br>";
		} else {
			msg += eLogic.checkedPassword(pass);
		}
		
		//msgが空＝登録可能
		if (msg == null || msg.length() == 0) {
			boolean finalCheck = uLogic.register(id, pass);
			if (!finalCheck) {
				msg += "登録ができませんでした<br>";
			}else {
				msg += "登録完了<br><a href=\"Login\">ログイン画面へ</a>";
			}
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
		
	}

}
