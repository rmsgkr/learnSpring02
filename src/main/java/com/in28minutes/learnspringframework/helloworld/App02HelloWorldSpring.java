package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
	
		try(var context =
				new AnnotationConfigApplicationContext
						(HelloWorldConfiguration.class)) {
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("address2"));
			
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));
			
			System.out.println(context.getBean(Person.class)); // 다수의 beans 에러
			System.out.println(context.getBean(Address.class)); // 다수의 beans 에러
			
			System.out.println(context.getBean("person5Qualifier")); // 다수의 beans 에러
			
			// System.out.println
//			Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println)X;
		};

		
	}

}
