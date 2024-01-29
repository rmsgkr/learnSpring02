package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


// 1. 필드주입, 2. 수정자(setter)주입, 3. 생성자(constructor)주입을 활용하여
// Dependency1, Dependency2를 YourBusinessClass에 주입하자

@Component
class YourBusinessClass {
	// 1. 필드주입
//	@Autowired
	Dependency1 dependency1;
//	@Autowired
	Dependency2 dependency2;
	
	// 2. 수정자(setter)주입
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1 ");
//		this.dependency1 = dependency1;
//	}
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2 ");
//		this.dependency2 = dependency2;
//	}
	
	// 3. 생성자(constructor)주입 - 추천
	// 모든 초기화(bean을 사용할 준비)가 하나의 메소드에서 발생하기 때문
//	@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
	super();
	System.out.println("Constructor Injection - YourBusinessClass ");
	this.dependency1 = dependency1;
	this.dependency2 = dependency2;
}

	public String toString() {
		return "Using : " + dependency1 + " & " + dependency2;
	}
}
@Component
class Dependency1 {
	
}
@Component
class Dependency2 {
	
}


@Configuration
@ComponentScan("com.in28minutes.learnspringframework.examples.a1") // 해당 패키지에서 컴포넌트를 찾아라ㅓ
public class DepInjectionLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = 
					new AnnotationConfigApplicationContext
						(DepInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class));
			
			
		}
	}

}
