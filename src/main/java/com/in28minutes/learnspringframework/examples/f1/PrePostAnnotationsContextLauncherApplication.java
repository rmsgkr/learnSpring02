package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	
	private SomeDependency someDependency;
	
	public SomeClass(SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!"); // 1. 의존성이 준비됨
	}
	
	// 의존성이 준비되고나면 @PostConstruct을 찾아 호출함
	// 초기화를 위해 의존성 주입이 완료된 후 실행해야 하는 메서드에 사용
	// ex) db 데이터 가저오기
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	// 어플리케이션 종료 전, 컨텍스트에서 Bean(인스턴스)이 삭제되기 전에 호출함
	// ex) 활성화된 연결 끊기
	@PreDestroy
	public void cleanup() {
		System.out.println("Cleanup");
	}
	
}

@Component 
class SomeDependency {

	public void getReady() {
		System.out.println("Some logic using SomeDependency"); // 2. 초기화
		
	}
	
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
	
	public static void main(String[] args) {

		try (var context = 
				new AnnotationConfigApplicationContext
					(PrePostAnnotationsContextLauncherApplication.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);

		}
	}
}
