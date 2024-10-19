package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SaunaData;

@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/recordSauna.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String adress = request.getParameter("adress");
		String url = request.getParameter("url");
		String point1 = request.getParameter("point1");
		String point2 = request.getParameter("point2");
		String point3 = request.getParameter("point3");
		String impression = request.getParameter("impression");
		String stStar = request.getParameter("star");

		String msg = "";
		String path = "";

		if (name == null || name.length() == 0) {
			msg += "施設名は必須項目です<br>";
		}
		if (type == null || type.length() == 0) {
			msg += "施設タイプは必須項目です<br>";
		}
		if (adress == null || adress.length() == 0) {
			msg += "住所は必須項目です<br>";
		}
		if (url == null || url.length() == 0) {
			msg += "URLは必須項目です<br>";
		}
		if (impression == null || impression.length() == 0) {
			msg += "感想は必須項目です<br>";
		}
		if (stStar == null || stStar.length() == 0) {
			msg += "☆は必須項目です<br>";
		}
		
		if (msg.isEmpty()) {

			if (point1.length() == 0) {
				point1 = "";
			}
			if (point2.length() == 0) {
				point2 = "";
			}
			if (point3.length() == 0) {
				point3 = "";
			}

			int star = Integer.parseInt(stStar);

			SaunaData data = new SaunaData(name, type, adress, url, point1, point2, point3, impression, star);

			HttpSession session = request.getSession();
			session.setAttribute("data", data);

			path = "WEB-INF/jsp/confirmData.jsp";

		} else {
			path = "WEB-INF/jsp/recordSauna.jsp";
			request.setAttribute("msg", msg);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
