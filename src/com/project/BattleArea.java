package com.project;

import java.util.ArrayList;
import java.util.List;

public class BattleArea  {

	
	private int battleAreaHeight;
	private int battleAreaWidth;
	private int[][] battleMatrix ;
	private List<BattleShip> battleShips;
	
	
	public BattleArea(int width, int height){
		this.battleAreaWidth = width;
		this.battleAreaHeight = height;
		this.battleShips = new ArrayList<>();
		this.battleMatrix = new int[height][width];
		System.out.println("BattleArea "+ width + " " + height);
		for(int row =0; row<height; row++){
			for(int col = 0 ; col <width ; col++){
				this.battleMatrix[row][col]=0;
			}
		}
	}
	
	public int getBattleAreaHeight() {
		return battleAreaHeight;
	}
	public void setBattleAreaHeight(int battleAreaHeight) {
		this.battleAreaHeight = battleAreaHeight;
	}
	public int getBattleAreaWidth() {
		return battleAreaWidth;
	}
	public void setBattleAreaWidth(int battleAreaWidth) {
		this.battleAreaWidth = battleAreaWidth;
	}
	public int[][] getBattleMatrix() {
		return battleMatrix;
	}
	public void setBattleMatrix(int[][] battleMatrix) {
		this.battleMatrix = battleMatrix;
	}
	public List<BattleShip> getBattleShips() {
		return battleShips;
	}

	public void addBattleShip(BattleShip battleShip) throws Exception {
		updateFieldMatrix(battleShip);		
		this.battleShips.add(battleShip);		
	}
	
	public void updateFieldMatrix(BattleShip battleShip) throws Exception{
		System.out.println("Battle Area "+ this.battleAreaHeight + " "+ this.battleAreaWidth);
		System.out.println("Dimensions "+ battleShip.getDimension()[0]+ " "+ battleShip.getDimension()[1]);
		System.out.println("Location "+ battleShip.getLocation()[0] + " "+ battleShip.getLocation()[1]);
		if((battleShip.getDimension()[0] + battleShip.getLocation()[0] -1)<= this.battleAreaHeight && (battleShip.getDimension()[1] + battleShip.getLocation()[1] -1) <= this.battleAreaWidth){
			for(int row = battleShip.getLocation()[0] -1; row < battleShip.getDimension()[0] + battleShip.getLocation()[0] -1; row++ ){
				for(int col=battleShip.getLocation()[1] -1 ; col < battleShip.getDimension()[1] + battleShip.getLocation()[1] -1 ;col++){
					if(this.battleMatrix[row][col] ==0){
						System.out.println("strength " + battleShip.getStrength());
						this.battleMatrix[row][col]=battleShip.getStrength();
					}
					else{
						throw new Exception("Already a missile at this location.Enter missile location again");
					}
				}		
			}
			
		}
		else{
			throw new Exception("Matrix cannot be updated..incorrect inputs..Dimension + Location should b less than BattleArea");
		}
		
		System.out.println("updated matrix");
		for(int row = 0; row <this.battleAreaHeight ; row++ ){
			for(int col=0 ; col < this.battleAreaWidth ;col++){
				System.out.print(this.battleMatrix[row][col]);
			}
			System.out.print("\n");
		}

	}
	
	public void matrixPostHit(int[] cordinates){	
		
		if(this.battleMatrix[cordinates[0]-1][cordinates[1]-1]!=0){
			this.battleMatrix[cordinates[0]-1][cordinates[1]-1]= this.battleMatrix[cordinates[0]-1][cordinates[1]-1]-1;						
		}
			System.out.println("display matrix");
			for(int row = 0; row <this.battleAreaHeight ; row++ ){
				for(int col=0 ; col < this.battleAreaWidth ;col++){
					System.out.print(this.battleMatrix[row][col]);
				}
				System.out.print("\n");
			}
	}
	

}
