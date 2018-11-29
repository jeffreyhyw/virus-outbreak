package test.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import controller.MainController;
import object.Country;
import object.CountryClimate;
import object.Game;
import object.Virus;
import object.VirusAbility;
import object.VirusSymptom;
import object.VirusTransmission;

public class TestMainController {
	private Game t_Game1;
	
	/*
	 * Test method for main
	 */
	@Test
	public void testMain() {
		MainController main = new MainController();
		main.main(null);
		assertNotNull(main.getGame());
	}
	
	/*
	 * Test method for gameStart
	 */
	@Test
	public void testGameStart() {
		MainController main = new MainController();
		main.main(null);
		Game game = main.getGame();
		game.initGameObjects();
		main.gameStart();
		assertTrue(game.getGameRunning().get());
	}
	
	/*
	 * Test method for checkGameResumeOrPause
	 */
	@Test
	public void testCheckGameResumeOrPause() {
		MainController main = new MainController();
		main.main(null);
		Game game = main.getGame();
		game.initGameObjects();
		main.gameStart();
		main.checkGameResumeOrPause();
		assertTrue(game.getGameRunning().get());
	}
	
	/*
	 * Test method for decreaseCountryResearchRate
	 */
	@Test
	public void testDecreaseCountryResearchRate() {
		MainController main = new MainController();
		main.main(null);
		Game game = main.getGame();
		game.initGameObjects();
		main.gameStart();
		double expectedResult = 0.0;
		game.getCountryByName("Hong Kong").addDeathPopulation(6000000);
		System.out.println("XXXXX: " + main.decreaseCountryResearchRate(game.getCountryByName("Hong Kong")));
		assertTrue(main.decreaseCountryResearchRate(game.getCountryByName("Hong Kong"))==0);
		//assertEquals(expectedResult,);
	}
	
	/*
	 * Test method for checkEndGame
	 */
	@Test
	public void testCheckEndGame() {
		MainController main = new MainController();
		main.main(null);
		Game game = main.getGame();
		game.initGameObjects();
		main.gameStart();
		main.checkEndGame();
		assertFalse(game.isEndGame());
	}
}
