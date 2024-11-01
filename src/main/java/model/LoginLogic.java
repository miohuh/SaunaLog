package model;

import dao.LoginDAO;

public class LoginLogic {

	/*
	 * ログインチェック
	 */
	public boolean logincheck(String id,String pass) {
		LoginDAO dao = new LoginDAO();
		return dao.login(id, pass);
	}
	
	public void register() {
		
	}
	
	public boolean inputCheck(String id, String pass) {
		
		
		return true;
	}
}
