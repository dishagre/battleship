package com.project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GameExecutorTest {
	Player playerA;
	BattleArea battleAreaA;	
	BattleShip battleShip1A;
	BattleShip battleShip2A;
	Player playerB;
	BattleArea battleAreaB;	
	BattleShip battleShip1B;
	BattleShip battleShip2B;
	GameExecutor gameExec;
	
	@Before
    public void setUp() throws Exception {		
		
		battleShip1A = new BattleShipP();
		battleShip2A = new BattleShipQ();
		battleShip1B = new BattleShipP();
		battleShip2B = new BattleShipQ();
		battleAreaA=new BattleArea(2,3);
		battleAreaB=new BattleArea(2,3);
		battleShip1A.setDimension(1, 1);
		battleShip1A.setLocation(1,1);
		battleShip2A.setDimension(1, 1);
		battleShip2A.setLocation(2,2);
		battleShip1B.setDimension(1, 1);
		battleShip1B.setLocation(1,1);
		battleShip2B.setDimension(1, 1);
		battleShip2B.setLocation(2,2);
		battleAreaA.addBattleShip(battleShip1A);		
		battleAreaA.addBattleShip(battleShip2A);
		battleAreaB.addBattleShip(battleShip1B);		
		battleAreaB.addBattleShip(battleShip2B);
		playerA = new Player ('A', battleAreaA);
		playerA.setPlayerSequence("A1B2");	
		playerB = new Player ('B', battleAreaB);
		playerB.setPlayerSequence("A1B2B1B2");
		gameExec = new GameExecutor();
	}
	
	@Test
	public void testStart() {
		List<Player> players = new ArrayList<>();
		players.add(playerA);
		players.add(playerB);
		
		assertEquals("Winner is ","B",gameExec.start(players));
	}

}
