package com.structural.BridgeDesignPattern;

public class Tree extends LivingThings{
	public Tree(BreatheImplementor breatheImplementor) {
		super(breatheImplementor);
	}
	@Override
	public void breatheProcess() {		
		breatheImplementor.breathe();
	}
}