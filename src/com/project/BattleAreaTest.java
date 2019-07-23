package com.project;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BattleAreaTest {
	BattleArea battleArea;
	BattleShip battleShip;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
    public void setUp() {
		battleArea = new BattleArea(2,3);
		battleShip = new BattleShipP();	
		
    }
	
	@Test
	public void testBattleArea() {
		assertEquals("Height of matrix is set ", 3, battleArea.getBattleAreaHeight());
		assertEquals("Width of matrix is set ", 2, battleArea.getBattleAreaWidth());
		assertEquals("Initialized to 0", 0,battleArea.getBattleMatrix()[0][0]);
		assertEquals("Initialized to 0", 0,battleArea.getBattleMatrix()[0][1]);
		assertEquals("Initialized to 0", 0,battleArea.getBattleMatrix()[1][0]);
		assertEquals("Initialized to 0", 0,battleArea.getBattleMatrix()[1][1]);
		assertEquals("Initialized to 0", 0,battleArea.getBattleMatrix()[2][0]);
		assertEquals("Initialized to 0", 0,battleArea.getBattleMatrix()[2][1]);
		
	}
	
	@Test
	public void testUpdateFieldMatrix() throws Exception{
		battleShip.setDimension(1, 2);
		battleShip.setLocation(1,1);		
		battleArea.updateFieldMatrix(battleShip);		
	}
	
	@Test
	public void testUpdateFieldMatrix1() throws Exception{
		battleShip.setDimension(2, 2);
		battleShip.setLocation(3,1);		
		thrown.expect(Exception.class);
		//test message
        thrown.expectMessage("Matrix cannot be updated..incorrect inputs..Dimension + Location should b less than BattleArea");
		battleArea.updateFieldMatrix(battleShip);		
	}
	
	@Test
	public void testUpdateFieldMatrix2() throws Exception{
		battleShip.setDimension(1, 2);
		battleShip.setLocation(3,1);
		battleArea.getBattleMatrix()[2][0] = 1;
		thrown.expect(Exception.class);
		//test message
        thrown.expectMessage("Already a missile at this location.Enter missile location again");
		battleArea.updateFieldMatrix(battleShip);		
	}
	
	@Test
	public void testMatrixPostHit(){
		int[][] matrix = battleArea.getBattleMatrix();
		matrix[1][1]=1;
		battleArea.setBattleMatrix(matrix);
		battleArea.matrixPostHit(new int[] {2,2});
		assertEquals("Initialized to 0", 0,battleArea.getBattleMatrix()[1][1]);
	}
	
	@After
    public void tearDown() {
		battleArea = null;
    }
}
