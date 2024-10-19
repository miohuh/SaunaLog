package model;

import java.io.Serializable;

public class SaunaData implements Serializable{

	private int id;
	private String name;
	private String type;
	private String adress;
	private String url;
	private String point1;
	private String point2;
	private String point3;
	private String impression;
	private int star;
	
	public SaunaData() {}
	
	public SaunaData(String name, String type, String adress, String url, String point1, String point2,String point3, String impression, int star) {
		this.name = name;
		this.type = type;
		this.adress = adress;
		this.url = url;
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.impression = impression;
		this.star = star;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getPoint1() {
		return point1;
	}
	
	public String getPoint2() {
		return point2;
	}
	
	public String getPoint3() {
		return point3;
	}

	public String getImpression() {
		return impression;
	}
	
	public int getStar() {
		return star;
	}
	
	
}
