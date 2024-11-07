package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.SaunaData;

/*
 * データベース接続クラス
 */
public class SaunaDAO {

	private final String URL = "jdbc:postgresql://localhost:5432/sauna";
	private final String USER = "postgres";
	private final String PASSWORD = "test";

	public SaunaDAO() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 施設名検索
	 */
	public List<String> checkOne() {
		String sql = "SELECT name FROM sauna;";
		List<String> nameList = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				nameList.add(rs.getString("name"));
			}
			
		}catch(Exception e) {
			System.out.println("データベース接続時にエラー発生しました");
			e.printStackTrace();
		}
		return nameList;
	}
	
	/*
	 * サウナ登録
	 */
	public boolean insertOne(SaunaData data) {
		String sql = "";
		sql += "INSERT INTO sauna(name,type,adress,url,point1,point2,point3,impression,star) ";
		sql += "VALUES (?,?,?,?,?,?,?,?,?); ";
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1, data.getName());
			st.setString(2, data.getType());
			st.setString(3, data.getAdress());
			st.setString(4, data.getUrl());
			st.setString(5, data.getPoint1());
			st.setString(6, data.getPoint2());
			st.setString(7, data.getPoint3());
			st.setString(8, data.getImpression());
			st.setInt(9, data.getStar());
			
			int count = st.executeUpdate();
			
			if (count == 1) {
				return true;
			}
				return false;
			
		} catch (Exception e) {
			System.out.println("データベース連携時にエラーが発生");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<String> searchName(String name) {
		String sql = "SELECT name FROM sauna WHERE name LIKE ? ;";
		List<String> resultNameList = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1,"%" + name + "%");
			ResultSet rs = st.executeQuery();
			
			
			while(rs.next()) {
				resultNameList.add(rs.getString("name"));
			}
			
		}catch(Exception e) {
			System.out.println("データベース連携時にエラーが発生");
			e.printStackTrace();
		}
		return resultNameList;
	}
	
	public SaunaData selectName(String selectName) {
		String sql = "SELECT * FROM sauna WHERE name = ?;";
		SaunaData data = null;
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1,selectName);
			ResultSet rs = st.executeQuery();
			
			int count = 0;
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				String adress = rs.getString("adress");
				String url = rs.getString("url");
				String point1 = rs.getString("point1");
				String point2 = rs.getString("point2");
				String point3 = rs.getString("point3");
				String impression = rs.getString("impression");
				int star = rs.getInt("star");
				
				data = new SaunaData(name,type,adress,url,point1,point2,point3,impression,star);
				data.setId(id);
				count++;
			}
			
			if (count == 1) { 
				return data;
			}
			
			return data;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("データベース連携時にエラーが発生しました。");
			
		}
		return data;
	}
	
	
	public List<String> viewAll() {
		String sql = "SELECT name FROM sauna;";
		List<String> allList = new ArrayList<>();
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement st = con.createStatement();) {
			
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				allList.add(rs.getString("name"));
			}
			
		}catch(Exception e) {
			System.out.println("データベース連携時にエラーが発生");
			e.printStackTrace();
		}
		return allList;
	}
	
	
	public boolean updateSauna(SaunaData data) {
		String sql = "UPDATE sauna SET name = ?, type = ?, adress = ?, ";
		sql += "url = ?, point1 = ?, point2 = ?, point3 = ?, impression = ?, star = ? ";
		sql += "WHERE id = ? ;";
		
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement st = con.prepareStatement(sql);) {
			
			st.setString(1, data.getName());
			st.setString(2, data.getType());
			st.setString(3, data.getAdress());
			st.setString(4, data.getUrl());
			st.setString(5, data.getPoint1());
			st.setString(6, data.getPoint2());
			st.setString(7, data.getPoint3());
			st.setString(8, data.getImpression());
			st.setInt(9, data.getStar());
			st.setInt(10, data.getId());
			
			int count = st.executeUpdate();
			
			if (count == 1) {
				return true;
			}
				return false;
			
		} catch (Exception e) {
			System.out.println("データベース連携時にエラーが発生");
			e.printStackTrace();
			return false;
		}
		
	}
}
