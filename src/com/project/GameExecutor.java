package com.project;

import java.util.ArrayList;
import java.util.List;

public class GameExecutor {

	public String start(List<Player> players) {
		
		//Initiate attack
		String winner = "draw";
		Player source ;
		Player target;
		String attackResponse="" ;
		String currentShot;
		int cordinates[];
		boolean foundWinner = false;
		//List<String> missiles = new ArrayList<>();
		System.out.println("Game Started ");
		boolean missilesLeft = anyMissilesLeft(players);
		while(!foundWinner && missilesLeft){
			System.out.println("no winner and missiles are left");
			for(int playerCount = 0; playerCount<players.size(); playerCount++){
				source=players.get(playerCount);
				System.out.println("Source is "+ source.getPlayerName());
				if(playerCount == players.size()-1){
					target = players.get(0);
					System.out.println("target is "+ target.getPlayerName());
				}
				else{
					target = players.get(playerCount+1);
					System.out.println("target is "+ target.getPlayerName());
				}
				//attackResponse = "hit";
				System.out.println("attack response is "+ attackResponse);
				System.out.println("any missile left with source "+ source.ifMissileLeft());
				while(attackResponse!="miss"&& source.ifMissileLeft()){					
					currentShot = source.provideShot();
					System.out.println("current Shot "+ currentShot);
					cordinates = findHitCordinates(currentShot);
					System.out.println("coordinates "+ cordinates[0]+ cordinates[1]);
					attackResponse = target.attackResponse(cordinates);
					System.out.println("AttackResponse "+ attackResponse);
					if(attackResponse =="hit"){
						System.out.println("Check if all ships destroyed"+ target.checkIfAllShipsDestroyed());
						if(target.checkIfAllShipsDestroyed()){							
							winner = Character.toString(source.getPlayerName());
							System.out.println("Found winner "+ winner);
							playerCount=players.size();
							foundWinner =true;
							System.out.println("playerCount "+playerCount + "found Winner "+foundWinner );
							break;
						}
					}
				}
				attackResponse="";
			}
			missilesLeft = anyMissilesLeft(players);
		}
		return winner;
	}
	

	private int[] findHitCordinates(String shot){
		int[] cordinates = new int[2];
		cordinates[0]=shot.charAt(0)-64;
		cordinates[1]=Utils.convertCharToInt(shot.charAt(1));
		return cordinates;
	}

	private boolean anyMissilesLeft(List<Player> players) {
		for(Player player : players){
			if (player.ifMissileLeft())
				return true;
				
		}
		return false;
	}
	
	
	

}
