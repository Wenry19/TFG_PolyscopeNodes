package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutFuncs;


public class DefPutFuncsData extends BlockData{
	
	private double velocity;
	private double acceleration;
	
	public DefPutFuncsData(String className, Boolean isSelected, double velocity, double acceleration){
		
		this.className = className;
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.isSelected = isSelected;
		
	}
	
	public Double getVelocity() {
		return velocity;
	}
	
	public Double getAcceleration() {
		return acceleration;
	}
	
	@Override
	public Block getBlockInstance() {
		
		// NO ES CRIDA TOT I SOBREESCRIURE AL METODE DE LA SUPERCLASSE
		
		DefPutFuncs b = (DefPutFuncs) super.getBlockInstance();
		
		b.setVelocity(velocity);
		b.setAcceleration(acceleration);
		
		b.setPanel();
		
		System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		
		return (Block) b;
	}
	
}
