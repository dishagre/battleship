package com.project;

public class BattleShipFactory {

	public BattleShip createBattleShip(String type){
		BattleShip battleShip;
		
		switch(type){
		case "P" : 
			 battleShip = new BattleShipP();
			 System.out.println("Create obj of type P");
			break;
		case "Q" :
			 battleShip = new BattleShipQ();
			 System.out.println("Create obj of type Q");
			break;
		default:
			throw new IllegalArgumentException("Battle Ship type is incorrect ");
		}
		
		return battleShip;
	}
}
