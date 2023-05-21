package com.structural.BridgeDesignPattern;

public class LandBreatheImplementation implements BreatheImplementor{
	@Override
	public void breathe() {
		System.out.println("Breathe from nose, inhale oxygen from air, exhale carbondioxide");
	}
}