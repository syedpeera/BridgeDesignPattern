package com.structural.BridgeDesignPattern;

public class Fish extends LivingThings{
	public Fish(BreatheImplementor breatheImplementor) {
		super(breatheImplementor);
	}
	@Override
	public void breatheProcess() {		
		breatheImplementor.breathe();
	}
}