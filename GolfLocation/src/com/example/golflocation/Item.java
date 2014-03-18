package com.example.golflocation;

import android.R.string;

public class Item {
	double frontLat;
	double backLat;
	double centerLat;
	double leftLat;
	double rightLat;
	
	double frontLong;
	double backLong;
	double centerLong;
	double leftLong;
	double rightLong;
	
	string type;
	
	public Item(){
		this.frontLat = 0.0;
		this.frontLong = 0.0;
		this.backLat = 0.0;
		this.backLong = 0.0;
		this.leftLat = 0.0;
		this.leftLong = 0.0;
		this.rightLat = 0.0;
		this.rightLong = 0.0;
		this.centerLat = 0.0;
		this.centerLong = 0.0;
	}
	
	public void setFront(double alat, double along){
		this.frontLat = alat;
		this.frontLong = along;
	}
	
	public void setBack(double alat, double along){
		this.backLat = alat;
		this.backLong = along;
	}
	
	public void setRight(double alat, double along){
		this.rightLat = alat;
		this.rightLong = along;
	}
	
	public void setLeft(double alat, double along){
		this.leftLat = alat;
		this.leftLong = along;
	}
	
	public void setCenter(double alat, double along){
		this.centerLat = alat;
		this.centerLong = along;
	}
	
	public void setType(string a){
		this.type = a;
	}
}
