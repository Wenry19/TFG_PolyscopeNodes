package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutFuncs;
import com.upc.EasyProduction.panelManagement.Workflow;


public class DefPutFuncsData extends BlockData{
	
	private double velocity;
	private double acceleration;
	
	public DefPutFuncsData(String className, Boolean isSelected, double velocity, double acceleration){
		
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
	
	@Override
	public Block getBlockInstance() {
		DefPutFuncs b = (DefPutFuncs) super.getBlockInstance();
		
		b.setVelocity(velocity);
		b.setAcceleration(acceleration);
		b.setIsSelected(isSelected); // pendent arreglar !!!!!
		
		b.setPanel();
		
		return (Block) b;
	}
	
}
