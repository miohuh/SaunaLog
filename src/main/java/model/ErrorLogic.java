package model;

public class ErrorLogic {

	
	public String checkesID(String id) {
		String msg = "";
		if (id.length() < 3 || id.length() > 20) {
			msg += "IDに不正な文字数です<br>";
		}
		if (!id.matches("^[a-zA-Z0-9]+$")) {
			msg += "IDに不正な文字が入力されています<br>";
		}
		
		return msg;
	}
	
	
	public String checkedPassword(String password) {
		String msg = "";
		
		if (password.length() < 8 || password.length() > 20) {
			msg += "PASSWORDに不正な文字数です<br>";
		}
		if (!password.matches(".*[A-Z].*")) {
			msg += "PASSWORDに英大文字は必須です<br>";
		}
		if (!password.matches(".*[a-z].*")) {
			msg += "PASSWORDに英小文字は必須です<br>";
		}
		if (!password.matches(".*[0-9].*")) {
			msg += "PASSWORDに数字は必須です<br>";
		}
		
		return msg;
	}
	
	
}
