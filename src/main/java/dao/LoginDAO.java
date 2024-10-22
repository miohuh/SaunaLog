package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

	private final String URL = "jdbc:postgresql://localhost:5432/sauna";
	private final String USER = "postgres";
	private final String PASSWORD = "test";

	public LoginDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ログイン検索
	 */
	public boolean login(String id,String pass) {
		String sql = "SELECT * FROM users WHERE id = ? AND pass = ?;";

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1,id);
			st.setString(2,pass);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
			
		}catch(Exception e) {
			System.out.println("データベース接続時にエラー発生しました");
			e.printStackTrace();
			return false;
		}

	}
	
	
	/*
	 * 同じIDが登録されているか検索
	 */
	public boolean nameCheck(String id) {
		String sql = "SELECT name FROM users WHERE id = ?;";

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1,id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
			
		}catch(Exception e) {
			System.out.println("データベース接続時にエラー発生しました");
			e.printStackTrace();
			return false;
		}
	}
}
