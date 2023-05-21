package com.structural.BridgeDesignPattern;

public class WaterBreatheImplementation implements BreatheImplementor{
	@Override
	public void breathe() {
		System.out.println("Breathe from gills, absorb oxygen from water, release carbondioxide");	
	}
}