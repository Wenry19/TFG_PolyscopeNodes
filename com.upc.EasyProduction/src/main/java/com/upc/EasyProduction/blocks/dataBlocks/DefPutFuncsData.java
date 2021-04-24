package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.BlockData;


public class DefPutFuncsData extends BlockData{
	
	private double velocity;
	private double acceleration;
	
	public DefPutFuncsData(String className, double velocity, double acceleration){
		
		this.className = className;
		this.velocity = velocity;
		this.acceleration = acceleration;
		
	}
	
	public Double getVelocity() {
		return velocity;
	}
	
	public Double getAcceleration() {
		return acceleration;
	}
	
}
