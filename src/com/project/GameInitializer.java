package com.project;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInitializer {

	public static void main(String args[]) throws Exception{
		
		try{
			
			//Read and validate Battle Area dimensions..Keep iterating till the time correct battle area dimensions are not received
			
			System.out.println("Enter area boundaries : ");
			Scanner in = new Scanner(System.in);
			String battleArea;
			while(true){
				try{
					battleArea = in.next();
					Validators.validateBattleArea(battleArea);
					break;
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
			}				
            int battleAreaWidth = Utils.convertCharToInt(battleArea.charAt(0));
			int battleAreaHeight = battleArea.charAt(1)-64;
            System.out.println("Width of Battle Area is "+ battleAreaWidth);
            System.out.println("Height of Battle Area is "+ battleAreaHeight);
                      
            
            //Read total number of battleships and total number of players
            
            int numberOfBattleShips;
            int numberOfPlayers;
            String battleShipCountString;
            String numberOfPlayersString;
            while(true){
            	try{
            		System.out.println("Enter total number of battleships :");
            		battleShipCountString = in.next();
            	    Validators.validateTotalNumberOfBattleships(battleShipCountString,battleAreaWidth, battleAreaHeight);
            		numberOfBattleShips = Integer.parseInt(battleShipCountString);
            		System.out.println("Enter total number of players :");
            		numberOfPlayersString = in.next();
            		Validators.validateTotalNumberOfPlayers(numberOfPlayersString);
            		numberOfPlayers = Integer.parseInt(numberOfPlayersString);
            		break;
            	}
            	catch(Exception e){
            		System.out.println(e.getMessage());
            	}
            }
            System.out.println("Total number of battleships entered : "+ numberOfBattleShips);
            System.out.println("Total number of players : "+ numberOfPlayers);
                      
            
            //Read type, dimension and location for all battleships
            String type;
            String dimensionXString;
            String dimensionYString;
            String location;
            List<Player> players=new ArrayList<>();
            //char ch ='A';
            boolean firstPass=true;
            for(int battleShipCount =1; battleShipCount<= numberOfBattleShips; battleShipCount++){
            	while(true){
            		try {
            			System.out.println("Type for battleship "+ battleShipCount +":");
            			type=in.next();									
            			Validators.validateBattleShipType(type);
            			System.out.println("Type is "+ type);
            			System.out.println("Dimension for BattleShip "+ battleShipCount +":");            			         			      			
            			dimensionYString = in.next();
            			dimensionXString = in.next();
            			Validators.validateDimension(dimensionXString, dimensionYString, battleAreaWidth , battleAreaHeight);
            			char ch='A';
            			for(int playerCount =1; playerCount<=numberOfPlayers; playerCount++){
            				if(firstPass){
            					System.out.println("Location of battleship "+ battleShipCount+ " for player "+ (char)ch);
            					
            				}
            				else{
            					
            					System.out.println("Location of battleship "+ battleShipCount+ " for player "+ players.get(playerCount-1).getPlayerName());
            				}
            				location = in.next();            				   	
            				Validators.validateLocation(location, battleAreaWidth , battleAreaHeight);
            				        				
            				if(firstPass){ 
            					System.out.println("inside first pass");
            					BattleShip battleShip = createBattleShip(type, dimensionXString,dimensionYString,location);            					
            					BattleArea battleField = new BattleArea(battleAreaWidth, battleAreaHeight);
            					battleField.addBattleShip(battleShip);
            					Player player = new Player((char)ch, battleField);
            					ch++;
            					//players = new ArrayList<>();
            					players.add(player);            				   	         				   	
            				}
            				else{
            					System.out.println("next pass");
            					BattleShip battleShip = createBattleShip(type, dimensionXString,dimensionYString,location);
            					Player player = players.get(playerCount-1);
            					BattleArea battleAreaToBeUpdated = player.getBattleArea();            					            					
            					battleAreaToBeUpdated.addBattleShip(battleShip);
            				}
            			}
            			firstPass = false;
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Enter Battleship Details Again ");
					}
            		
            	}
            }
            
            
            //Read attack sequence for players
            String missileSequence="";
            for(Player player : players){
    			while(true){
    				try{
    					System.out.println("Missile targets for  "+ player.getPlayerName());
    					missileSequence = in.next();
    					Validators.validateMissileSequence(missileSequence, battleAreaWidth, battleAreaHeight);
    					break;
    				}
    				catch(Exception e){
    					System.out.println(e.getMessage());
    				}
    			}
    			player.setPlayerSequence(missileSequence);
            } 
            in.close();
            
		    //Start the game             
            GameExecutor game = new GameExecutor();
            String winner = game.start(players);
            if(winner.equals("draw")){
            	System.out.println("It's a draw ");
            }else{
            System.out.println("Winner is "+ winner);	
            }
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	

	private static BattleShip createBattleShip(String type, String dimensionXString, String dimensionYString,
			String location) {
		int dimensionX = Integer.parseInt(dimensionXString);
		int dimensionY = Integer.parseInt(dimensionYString);
		System.out.println("Dimension for battleship "+ dimensionX + dimensionY);
		int locationX = location.charAt(0)-64;
	   	int locationY = Utils.convertCharToInt(location.charAt(1));
	   	System.out.println("Location for battleship "+ locationX + locationY);		
		BattleShipFactory factory =new BattleShipFactory();
		System.out.println("create obj for factory class");
		BattleShip battleShip = factory.createBattleShip(type);
		System.out.println("battleship created from factory");
		battleShip.setDimension(dimensionX, dimensionY);
		battleShip.setLocation(locationX, locationY);
		System.out.println("BattleShip Details "+ battleShip.getStrength()+ battleShip.getType()+battleShip.getDimension()[0]+ battleShip.getDimension()[1]+ battleShip.getLocation()[0]+battleShip.getLocation()[1]);
		//System.out.println("BattleShip details "+ battleShip.toString());
		return battleShip;
	}		
}
