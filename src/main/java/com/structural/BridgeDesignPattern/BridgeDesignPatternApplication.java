package com.structural.BridgeDesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BridgeDesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeDesignPatternApplication.class, args);
		LivingThings dog = new Dog(new LandBreatheImplementation());
		dog.breatheProcess();
		
		LivingThings fish = new Fish(new WaterBreatheImplementation());
		fish.breatheProcess();
		
		LivingThings tree = new Tree(new LandBreatheImplementation());
		tree.breatheProcess();
	}
}