package com.project;

public class Validators {

	public static void validateBattleArea(String battleAreaDimension) throws Exception {
		
		try {
			if(battleAreaDimension.length()>2){
				throw new InputValidateException("Only two character are allowed ");
			}
			if (Utils.convertCharToInt(battleAreaDimension.charAt(0)) < 1
					|| Utils.convertCharToInt(battleAreaDimension.charAt(0)) > 9) {
				throw new InputValidateException("Width should be between 1-9 ");
			}
			if (battleAreaDimension.charAt(1) < 'A' || battleAreaDimension.charAt(1) > 'Z') {
				throw new InputValidateException("Height should be between A-Z ");
			}
		}catch(NumberFormatException e){
			throw new InputValidateException("Integer expected instead of character ");
		}catch(IndexOutOfBoundsException e){
			throw new InputValidateException("Spaces not allowed ");
		}

	}

	public static void validateTotalNumberOfBattleships(String numberOfBattleShipsString, int battleAreaWidth,
			int battleAreaHeight) throws Exception {
		try {
			int numberOfBattleShips = Integer.parseInt(numberOfBattleShipsString);
			if (numberOfBattleShips < 1 || numberOfBattleShips > (battleAreaWidth * battleAreaHeight)) {
				throw new InputValidateException(
						"Total number of battleships should be between 1 and " + battleAreaWidth * battleAreaHeight);
			}
		}catch(NumberFormatException e){
			throw new InputValidateException("Integer expected instead of character");
		}
	}

	public static void validateBattleShipType(String type) throws Exception {		
		if(type.length()>1){
			throw new InputValidateException("Only one character is allowed ");
		}
		if (!type.equals("P") && !type.equals("Q")) {
			throw new InputValidateException("Enter correct value for Battleship Type");
		}
	}

	public static void validateDimension(String dimensionXString, String dimensionYString, int battleAreaWidth,
			int battleAreaHeight) throws Exception {
		System.out.println("Battle Area " +battleAreaWidth + " "+ battleAreaHeight);
		
		try {
			int dimensionX = Integer.parseInt(dimensionXString);
			int dimensionY = Integer.parseInt(dimensionYString);
			System.out.println("Dimension of Battleship "+ dimensionY + " "+ dimensionX);
			if (dimensionY < 1 || dimensionY > battleAreaWidth) {
				throw new InputValidateException("Width of the battle ship is incorrect");
			}
			if (dimensionX < 1 || dimensionX > battleAreaHeight) {
				throw new InputValidateException("Height of the battle ship is incorrect");
			}
		}catch(NumberFormatException e){
			throw new InputValidateException("Integer expected instead of character");
		}
	}

	public static void validateLocation(String location, int battleAreaWidth, int battleAreaHeight) throws Exception {
		System.out.println("Battle Area " +battleAreaWidth + " "+ battleAreaHeight);
		try {
			if(location.length()!=2){
				throw new InputValidateException("Enter exactly two characters");
			}
			int locationX = location.charAt(0)-64;
			int locationY = Utils.convertCharToInt(location.charAt(1));
			System.out.println("Location of Battleship "+ locationX + " "+ locationY);
			if (locationX < 1 || locationX > battleAreaHeight) {
				throw new InputValidateException("Incorrect height coordinates");
			}
			if (locationY < 1 || locationY > battleAreaWidth) {
				throw new InputValidateException("Incorrect width coordinates");
			}
		}catch(NumberFormatException e){
			throw new InputValidateException("Integer expected instead of character");
		}catch(IndexOutOfBoundsException e){
			throw new InputValidateException("Enter two characters");
		}

	}

	public static void validateTotalNumberOfPlayers(String numberOfPlayersString) throws Exception { 
		try {
			int numberOfPlayers = Integer.parseInt(numberOfPlayersString);
			if (numberOfPlayers < 2 || numberOfPlayers > 5) {
				throw new InputValidateException("Players less than 2 and more than 5 not allowed");
			}
		}catch(NumberFormatException e){
			throw new InputValidateException("Integer expected instead of character");
		}
	}
	
	public static void validateMissileSequence(String missileSequence, int battleAreaWidth, int battleAreaHeight)throws Exception{
		boolean alternateFlag = true;		
		try{
			for(int index =0 ; index<missileSequence.length(); index++){				
				if(alternateFlag){
					alternateFlag = false;
					if(missileSequence.charAt(index)-64 < 1 || missileSequence.charAt(index)-64 > battleAreaHeight){						
						throw new InputValidateException("This character is outside range of battle area"+missileSequence.charAt(index) );
					}
				}
			else{
				alternateFlag = true;
					if(Utils.convertCharToInt(missileSequence.charAt(index)) < 1 || Utils.convertCharToInt(missileSequence.charAt(index))>battleAreaWidth){						
						throw new InputValidateException("This integer is outside range of battle area"+missileSequence.charAt(index));
					}
				}
			}
		}catch(NumberFormatException e){
			throw new InputValidateException("Integer expected instead of character");
		}catch(IndexOutOfBoundsException e){
			throw new InputValidateException("Enter only one character");
		}
			
		
	}

}
