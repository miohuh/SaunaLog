package model;

import java.util.List;

public class SaunaLogic {

	public boolean nameCheck(SaunaData data) {
		SaunaDAO dao = new SaunaDAO();
		List<String> nameList = dao.checkOne();
		boolean checker = false;
		for (String name : nameList) {
			if (name.equals(data.getName())) {
				checker = true;
			}
		}
		return checker;
	}
	
	public boolean insertData(SaunaData data) {
		SaunaDAO dao = new SaunaDAO();
		return dao.insertOne(data);
	}
	
	public List<String> search(String name) {
		SaunaDAO dao = new SaunaDAO();
		return dao.searchName(name);
	}
	
	public List<String> view() {
		SaunaDAO dao = new SaunaDAO();
		return dao.viewAll();
	}
	
	public SaunaData select(String name) {
		SaunaDAO dao = new SaunaDAO();
		return dao.selectName(name);
	}
}
