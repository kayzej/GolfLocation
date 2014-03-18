package com.example.golflocation;

public class Course {
	Hole[] holes;
	
	public Course(){
		holes = new Hole[18];
	}
	
	public void addHole(int num, Hole hole){
		holes[num] = hole;
	}
}
