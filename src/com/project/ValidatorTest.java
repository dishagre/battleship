package com.project;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class ValidatorTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testValidateBattleArea() throws Exception{		
        Validators.validateBattleArea("2C"); 
    }
	
	@Test
	public void testValidateBattleArea1() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Width should be between 1-9");
        Validators.validateBattleArea("0C"); 
    }
	
	@Test
	public void testValidateBattleArea2() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Height should be between A-Z ");
        Validators.validateBattleArea("3a");      
    }
	
	@Test
	public void testValidateBattleArea3() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Integer expected instead of character ");
        Validators.validateBattleArea("@A");   
    }  
    @Test
	public void testValidateBattleArea4() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Only two character are allowed ");
        Validators.validateBattleArea("3CA");      
    }
    
    @Test
	public void testValidateTotalNumberOfBattleShips() throws Exception{		
        Validators.validateTotalNumberOfBattleships("4", 3, 2);
    }
    
    @Test
	public void testValidateTotalNumberOfBattleShips1() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Total number of battleships should be between 1 and 6");
        Validators.validateTotalNumberOfBattleships("100", 3, 2);
    }
    
    @Test
	public void testValidateTotalNumberOfBattleShips2() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Integer expected instead of character");
        Validators.validateTotalNumberOfBattleships("mn", 3, 2);
    }
    
    @Test
	public void testValidateBattleShipType() throws Exception{
        Validators.validateBattleShipType("P");
    }
	
    @Test
	public void testValidateBattleShipType1() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Only one character is allowed ");
        Validators.validateBattleShipType("mn");
    }
    
    @Test
	public void testValidateBattleShipType2() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Enter correct value for Battleship Type");
        Validators.validateBattleShipType("1");
    }
    
    @Test
	public void testValidateDimension() throws Exception{
        Validators.validateDimension("1", "1", 2, 3);      
    }
	
	@Test
	public void testValidateDimension1() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Height of the battle ship is incorrect");
        Validators.validateDimension("4", "1", 2, 3);      
    }
	
	@Test
	public void testValidateDimension2() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Width of the battle ship is incorrect");
        Validators.validateDimension("4", "3", 2, 5);      
    }
	
	@Test
	public void testValidateDimension3() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Integer expected instead of character");
        Validators.validateDimension("q", "1", 2, 3);      
    }
	
	@Test
	public void testValidateLocation() throws Exception{
        Validators.validateLocation("A1", 2, 3);      
    }
	
	@Test
	public void testValidateLocation1() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Incorrect width coordinates");
        Validators.validateLocation("A3", 2, 3);      
    }
	
	@Test
	public void testValidateLocation2() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Incorrect height coordinates");
        Validators.validateLocation("D1", 2, 3);      
    }
	
	@Test
	public void testValidateLocation3() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Integer expected instead of character");
        Validators.validateLocation("4A", 2, 3);      
    }
	
	@Test
	public void testValidateLocation4() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Enter exactly two characters");
        Validators.validateLocation("4", 2, 3);
        
    }
	
	@Test
	public void testValidateTotalNumberOfPlayers() throws Exception{
        Validators.validateTotalNumberOfPlayers("3");
        
    }
	
	@Test
	public void testValidateTotalNumberOfPlayers1() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Integer expected instead of character");
        Validators.validateTotalNumberOfPlayers("RQW");
        
    }
	
	@Test
	public void testValidateTotalNumberOfPlayers2() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Players less than 2 and more than 5 not allowed");
        Validators.validateTotalNumberOfPlayers("100");
        
    }
	
	@Test
	public void testValidateMissileSequence() throws Exception{
        Validators.validateMissileSequence("A1B2", 2,3);
        
    }
	
	@Test
	public void testValidateMissileSequence1() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("This character is outside range of battle area3");
        Validators.validateMissileSequence("A1B2X", 2,3);
        
    }
	
	@Test
	public void testValidateMissileSequence2() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("Integer expected instead of character");
        Validators.validateMissileSequence("AABb",2,3);
        
    }
	
	@Test
	public void testValidateMissileSequence3() throws Exception{
		//test type
        thrown.expect(InputValidateException.class);
		//test message
        thrown.expectMessage("This integer is outside range of battle area");
        Validators.validateMissileSequence("A1D3",2,3);
        
    }
	
	

}

