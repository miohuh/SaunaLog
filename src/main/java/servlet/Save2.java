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

@WebServlet("/Save2")
public class Save2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		SaunaData saunaData = (SaunaData)session.getAttribute("saunaData");
		
		SaunaLogic logic = new SaunaLogic();
		boolean nameCheck = logic.nameCheck(saunaData);
		
		if (nameCheck) {
			request.setAttribute("msg", "このサウナ名は既に登録されています");
		}else { 
			boolean finalCheck= logic.insertData(saunaData);
			
			if (finalCheck) {
				request.setAttribute("msg", "保存されました。");
				session.removeAttribute("saunaData");
			}else {
				request.setAttribute("msg", "保存できませんでした。");
			}
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/confirmData.jsp");
		dispatcher.forward(request, response);
	}

}
