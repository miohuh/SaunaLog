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
import model.SaunaLogic;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("action");
		
		if (name != null && name.length() != 0) {
			SaunaLogic logic = new SaunaLogic();
			SaunaData saunaData = logic.select(name);
			
			HttpSession session = request.getSession();
			session.setAttribute("saunaData", saunaData);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/recordSauna.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SaunaData saunaData = (SaunaData)session.getAttribute("saunaData");
		
		SaunaLogic logic = new SaunaLogic();
		boolean updateCheck = logic.update(saunaData);
		
		if (updateCheck) {
			request.setAttribute("msg", "更新されました。");
			session.removeAttribute("saunaData");
		}else { 
			request.setAttribute("msg", "更新できませんでした。");
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/recordSauna.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
