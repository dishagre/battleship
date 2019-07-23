package com.project;



public abstract class BattleShip {
	
	//char type;
	private int dimenSionX;
	private int dimensionY;
	private int[] dimension;
	private int locationX;
	private int locationY;
	private int[] location;
	private String type;
	private int strength;
	
	public void setDimension(int width, int height){
		dimenSionX = width;
		dimensionY = height;
		dimension = new int[2];
		dimension[0] = width;
		dimension[1] = height;
	}
	
	public int[] getDimension(){
		return dimension;
	}
	
	public void setLocation(int posX, int posY){
		locationX= posX;
		locationY = posY;
		location = new int[2];
		location[0] = posX;
		location[1] = posY;
	}
	
	public int[] getLocation(){
		return location;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

}


