package com.project;


public class Player {

	char playerName;
	String playerSequence;
	BattleArea battleArea;
	String missile;	
	
	public Player(char name , BattleArea area){
		this.playerName=name;
		this.battleArea=area;
	}
	public char getPlayerName() {
		return playerName;
	}
	public void setPlayerName(char ch) {
		this.playerName = ch;
	}
	public String getPlayerSequence() {
		return playerSequence;
	}
	public void setPlayerSequence(String playerSequence) {
		this.playerSequence = playerSequence;
		this.missile = playerSequence;
	}	
	public BattleArea getBattleArea() {
		return battleArea;
	}
	public void setBattleArea(BattleArea battleArea) {
		this.battleArea = battleArea;
	}
	public String getMissile() {
		return missile;
	}
	
	public String provideShot(){
		try{
			 String shot =  this.missile.substring(0, 2);
			 this.missile = this.missile.substring(2);
			 return shot;
		}
		catch (Exception e){
				return null;
		}
	}
	
	public boolean ifMissileLeft(){
		//System.out.println("Missile is "+ this.missile);
		if(this.missile != null && !this.missile.isEmpty())
			return true;
		else
			return false;
	}
	
	public String attackResponse(int[] cordinates){		
		if(this.battleArea.getBattleMatrix()[cordinates[0]-1][cordinates[1]-1]==0){
			return "miss";
		}	
		else{
			this.battleArea.matrixPostHit(cordinates);						
			return "hit";
		}	
	}

	public boolean checkIfAllShipsDestroyed(){
		int sum =0;
		for(int row =0; row < this.battleArea.getBattleAreaHeight(); row ++){
			for(int col =0; col < this.battleArea.getBattleAreaWidth(); col++){
				sum+=this.battleArea.getBattleMatrix()[row][col];
			}		
		}	
		if(sum==0){
			System.out.println("Total sum is "+ sum);
			return true;
		}	
		else{
		return false;
		}
	}	
}
