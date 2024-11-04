package model;

import dao.UsersDAO;

public class UsersLogic {

	/*
	 * ログインチェック
	 */
	public boolean logincheck(String id,String pass) {
		UsersDAO dao = new UsersDAO();
		return dao.login(id, pass);
	}
	
	/*
	 * 登録処理
	 */
	public boolean register(String id,String pass) {
		UsersDAO dao = new UsersDAO();
		return dao.register(id, pass);
	}
	
	/*
	 * 登録可能チェック
	 */
	public boolean inputCheck(String id) {
		UsersDAO dao = new UsersDAO();
		//idが登録されてないときtrueを返す(登録が可能ということ)
		return dao.nameCheck(id);
	}
}
