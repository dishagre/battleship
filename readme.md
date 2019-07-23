This project contains working solution of Battleship program as per the instructions provided.

Project description



Battleship consists of the following classes :

1.Player : Player is a concrete class and number of players will be equal to the objects created of this class.
			states : Name <>, BattleArea <object> , ShotSequence<String[]> and Missile <String>
			behaviour : 
			a.provides with current Shot to be hit to the target
			b.tells if any more shots are left with the player
			c.check the response of attack on its battle area
			d. check if all its ships are destroyed
	
2. BattleArea : BattleArea is a concrete class. Each player will have its own battle area.
				states: List of Battleships<Object>, width<integer> , height<integer>, battleMatrix <2D array>
				behaviour : 
				a. constructor will place the strength of the battleShips on the respective location of battleMatrix
				b.add a new Battleship
				c. Update matrix 
				d. on a successful hit,	decrease the strength from the respective location on battleMatrix

3. BattleShip : It is an abstract class..which cannot create a battleship without the actual implementation
				state : dimension and location of battleship				

4. BattleShipP : Concrete class of Battleship with strength as 1

5. BattleShipQ : Concrete class of Battleship with strength as 1

6. BattleShipFactory : Generate object of battleship based on type P or Q

7. GameInitializer : Read all the user inputs  and create the battleMatrix with correct placement of battleShips

8. GameExecutor : This class serves as a mediator and executes the game..identify source and target players ..take shots from source and check if target is hit 

9. Validators : Validators to validate all the user inputs and imply the constraints

10. InputValidateException : Custom exception when any user input is incorrect

11. Utils : provides utility methods

12. TestClasses : PlayerTest, ValidatorTest, BattleAreaTest etc test classes have been created using Junit. 
				Basic test cases have been written but need to write more to provide good coverage.

Run Battleship
Import the project. GameInitializer contains the main method. Run it as a java application.	
	
Constraints
1. 2<=numberOfPlayer<=5
2. A<=BattleAreaHeight(H)<=Z
3. 1<=BattleAreaWidth(W)<=9
4. 1<=NumberOfBattleShips<=H*W
5. P<=BattleShipType<=Q
6. 1<=BattleShipDimensionHeight<=H(converted in integer)
7. 1<=BattleShipDimensionWidth<=W
8. 1<=BattleShipLocationHeight<=H
9. 1<=BattleShipLocationWidth<=W



Future Enhancements
1.This game can be played with n players in a round robbin technique with sourcePlayer as n and targetPlayer as n+1. 
To keep it simple for now, number of players are restricted between 2 and 5

2.There are 2 kind of battleships supported right now with P strength as 1 and Q strength as 2
To increase the number of BattleShips a new class with new strength and type can be created which will extend abstract class Battleship