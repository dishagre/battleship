package com.project;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlayerTest {
	Player player;
	BattleArea battleArea;	
	BattleShip battleShip1;
	BattleShip battleShip2;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
    public void setUp() {		
		
		battleShip1 = new BattleShipP();
		battleShip2 = new BattleShipQ();
		battleArea=new BattleArea(2,3);		
	}
	
	@Test
	public void testProvideShot() throws Exception {
		battleShip1.setDimension(1, 2);
		battleShip1.setLocation(1,1);
		battleShip2.setDimension(2, 1);
		battleShip2.setLocation(2,1);
		battleArea.addBattleShip(battleShip1);
		battleArea.addBattleShip(battleShip2);
		player = new Player ('A', battleArea);
		player.setPlayerSequence("A1B2");		 
		assertEquals("GetFirstShot","A1",player.provideShot());
		assertTrue(player.ifMissileLeft());
	}
	
	@Test
	public void testProvideShot1() throws Exception {
		battleShip1.setDimension(1, 2);
		battleShip1.setLocation(1,1);
		battleShip2.setDimension(2, 1);
		battleShip2.setLocation(2,1);
		battleArea.addBattleShip(battleShip1);
		battleArea.addBattleShip(battleShip2);
		
		player = new Player ('A', battleArea);
		player.setPlayerSequence("");
		assertEquals("GetFirstShot",null,player.provideShot());
		assertFalse(player.ifMissileLeft());
	}
	
	@Test
	public void testMissileLeft() throws Exception {
		battleShip1.setDimension(1, 2);
		battleShip1.setLocation(1,1);
		battleShip2.setDimension(2, 1);
		battleShip2.setLocation(2,1);
		battleArea.addBattleShip(battleShip1);
		battleArea.addBattleShip(battleShip2);
		player = new Player ('A', battleArea);
		player.setPlayerSequence("A1");		 
		assertEquals("GetFirstShot","A1",player.provideShot());
		assertFalse(player.ifMissileLeft());
	}
	
	@Test
	public void testAttackResponse() throws Exception {
		battleShip1.setDimension(1, 2);
		battleShip1.setLocation(1,1);
		battleShip2.setDimension(2, 1);
		battleShip2.setLocation(2,1);
		battleArea.addBattleShip(battleShip1);
		battleArea.addBattleShip(battleShip2);
		player = new Player ('A', battleArea);
			 
		assertEquals("GetFirstShot","hit",player.attackResponse(new int[]{1,1}));
		assertFalse(player.checkIfAllShipsDestroyed());
	}
	
	@Test
	public void testAttackResponse1() throws Exception {
		battleShip1.setDimension(1, 1);
		battleShip1.setLocation(1,1);
		battleShip2.setDimension(1, 1);
		battleShip2.setLocation(2,1);
		battleArea.addBattleShip(battleShip1);
		battleArea.addBattleShip(battleShip2);
		player = new Player ('A', battleArea);
			 
		assertEquals("GetFirstShot","hit",player.attackResponse(new int[]{1,1}));
		assertEquals("GetFirstShot","miss",player.attackResponse(new int[]{1,2}));
		assertFalse(player.checkIfAllShipsDestroyed());
		assertEquals("GetFirstShot","hit",player.attackResponse(new int[]{2,1}));
		assertEquals("GetFirstShot","hit",player.attackResponse(new int[]{2,1}));		
		assertTrue(player.checkIfAllShipsDestroyed());
	}
	
	
	@After
    public void tearDown() {
		player = null;
    }	

}

