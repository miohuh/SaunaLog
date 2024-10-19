package model;

public class LoginLogic {

	public boolean logincheck(String id,String pass) {
		if (id.equals("mio") && pass.equals("1013")) {
			return true;
		}
		return false;
	}
}
