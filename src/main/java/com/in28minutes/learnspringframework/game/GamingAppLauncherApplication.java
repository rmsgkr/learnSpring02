package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game") // 해당 패키지에서 컴포넌트를 찾아라ㅓ
public class GamingAppLauncherApplication {
	
//	@Beanㅓ
//	public GamingConsole game() {
//		var game = new PacmanGame();
//		return game;
//	}
	
//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
//		System.out.println("PARM: "+game);
//		var gameRunner = new GameRunner(game);
//		return gameRunner;
//	}

	public static void main(String[] args) {
		
		try(var context = 
					new AnnotationConfigApplicationContext
						(GamingAppLauncherApplication.class)){
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
			
		}
	}

}
