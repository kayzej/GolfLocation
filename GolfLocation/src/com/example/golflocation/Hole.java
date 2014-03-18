package com.example.golflocation;

import java.util.ArrayList;

public class Hole {
	ArrayList<Item> Items;
	
	double teeBoxLat;
	double teeBoxLong;
	Item green;
	
	public Hole(){
		teeBoxLat = 0;
		teeBoxLong = 0;
		green = new Item();
	}
	
	public void addItem(Item a){
		Items.add(a);
	}
}
