package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut.GetReadyToPut;

// inner data class

public class GetReadyToPutData extends BlockData{
	
	private double velocity;
	private double acceleration;
	
	private int velocity_tag;
	private int acceleration_tag;
			
	public GetReadyToPutData(String className, Boolean isSelected, double velocity, double acceleration, int velocity_tag, int acceleration_tag) {
		
		this.className = className;
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.isSelected = isSelected;
		
		this.velocity_tag = velocity_tag;
		this.acceleration_tag = acceleration_tag;
				
	}
	
	@Override
	public Block getBlockInstance(String BlockDataString) {
				
		GetReadyToPut b = (GetReadyToPut) super.getBlockInstance(BlockDataString);
		
		b.setVelocity(velocity, velocity_tag);
		b.setAcceleration(acceleration, acceleration_tag);
		
		b.setPanel();
				
		return (Block) b;
	}
}
