package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.examples.c1") // 해당 패키지에서 컴포넌트를 찾아라ㅓ
public class RealWorldSpringContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = 
					new AnnotationConfigApplicationContext
						(RealWorldSpringContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
			
		}
	}

}
