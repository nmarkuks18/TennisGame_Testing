import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Ignore
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
		
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}	
	
	@Test  //1-0
	public void testTennisGame_Score1_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "15 - love", score);		
	}
	
	@Test  //2-0
	public void testTennisGame_Score2_0() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "30 - love", score);		
	}
	
	@Test  //0-3
	public void testTennisGame_Score0_3() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "love - 40", score);		
	}
	
	@Test  //2-2
	public void testTennisGame_Score2_2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "30 - 30", score);		
	}
	
	@Test //4-2
	public void testTennisGame_Score4_2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player1 wins", score);		
	}
	
	
	@Test 
	public void testTennisGame_Score0_4() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player2 wins", score);		
	}
	

	@Test //3-4
	public void testTennisGame_Score3_4() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player2 has advantage", score);		
	}
	
	@Test //5-4
	public void testTennisGame_Score5_4() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player2Scored();
		game.player1Scored();
		
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player1 has advantage", score);		
	}
}
