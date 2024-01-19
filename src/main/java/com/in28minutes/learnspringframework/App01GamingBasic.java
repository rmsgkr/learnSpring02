package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasic {

	public static void main(String[] args) {


		var game = new PacmanGame();

		var gameRunner = new GameRunner(game);
		gameRunner.run();

	}

}
