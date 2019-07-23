package com.project;

public class BattleShipQ extends BattleShip {
	private String type = "Q";
	private int strength = 2;
	
	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public int getStrength() {
		return strength;
	}
		
}