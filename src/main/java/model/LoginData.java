package model;

import java.io.Serializable;
/*
 * ログイン情報を保持するJavaBeans
 */
public class LoginData implements Serializable {

	private String id;
	private String pass;
	
	public LoginData() {}

	public LoginData(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}
	
	
	
	
}
