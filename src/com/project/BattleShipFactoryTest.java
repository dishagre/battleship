package com.project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BattleShipFactoryTest {
	BattleShipFactory battleShipFactory;
	
	@Before
    public void setUp() {		
		battleShipFactory = new BattleShipFactory();	
		
    }
	
	@Test
	public void testCreateBattleShip() {		
		BattleShip battleShip = battleShipFactory.createBattleShip("Q");		
		assertTrue( battleShip instanceof BattleShipQ );
		
	}
	
	@Test
	public void testCreateBattleShip1() {		
		BattleShip battleShip = battleShipFactory.createBattleShip("P");		
		assertFalse( battleShip instanceof BattleShipQ );
		
	}
	
	@After
    public void tearDown() {
		battleShipFactory = null;
    }	

}
