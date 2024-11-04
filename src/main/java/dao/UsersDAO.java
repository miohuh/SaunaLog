package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersDAO {

	private final String URL = "jdbc:postgresql://localhost:5432/sauna";
	private final String USER = "postgres";
	private final String PASSWORD = "test";

	public UsersDAO() {
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
		String sql = "SELECT * FROM users WHERE name_id = ? AND pass = ?;";

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
		String sql = "SELECT name_id FROM users WHERE name_id = ?;";

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1,id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return false;
			} else {
				return true;
			}
			
		}catch(Exception e) {
			System.out.println("データベース接続時にエラー発生しました");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean register(String id,String pass) {
		String sql = "Insert into users (name_id,pass) values (?,?);";

		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1,id);
			st.setString(2,pass);
			int reg = st.executeUpdate();
			
			if (reg != 1) {
				return false;
			}else {
				return true;
			}
			
		} catch (Exception e) {	
			System.out.println("データベース接続時にエラー発生しました");
			e.printStackTrace();
			return false;
		}
	}
}
