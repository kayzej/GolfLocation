package com.example.golflocation;

public class Item {
	String course;
	int hole;
	String type;
	double latitude;
	double longitude;
	
	public Item(){
		
	}
	
	public Item(String aCourse, int aHole, String aType, double aLatitude, double aLongitude){
		this.course = aCourse;
		this.hole = aHole;
		this.type = aType;
		this.latitude = aLatitude;
		this.longitude = aLongitude;
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getHole() {
		return hole;
	}

	public void setHole(int hole) {
		this.hole = hole;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
