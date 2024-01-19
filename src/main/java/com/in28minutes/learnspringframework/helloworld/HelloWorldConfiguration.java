package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// setter getter 필요 X
record Person (String name, int age, Address address) { };
record Address (String firstLine, String city) { };

@Configuration
public class HelloWorldConfiguration {
	
	// @Bean: 스프링 컨테이너가 관리하는 Bean 을 생성한다는 의미
	@Bean
	public String name() {
		return "근학";
	}
	
	@Bean
	public int age() {
		return 30;
	}
	
	@Bean
	public Person person() {
		var person = new Person("근학2", 60, new Address("1St", "Seoul"));
		
		return person; 
	}

	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(), age(), address());
		
		return person; 
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) {
		var person = new Person(name, age, address3);
		
		return person; 
	}
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) {
		var person = new Person(name, age, address);
		
		return person; 
	}
	
	@Bean
	public Person person5Qualifier(String name, int age, @Qualifier("address3Qualifier") Address address) {
		var person = new Person(name, age, address);
		
		return person; 
	}
	
	@Bean(name="address2")
	@Primary
	public Address address() {
		var address = new Address("1St", "Seoul");
		
		return address; 
	}
	
	@Bean(name="address3")
	@Qualifier("address3Qualifier")
	public Address address3() {
		var address = new Address("2St", "JEJU");
		
		return address; 
	}
	
}
