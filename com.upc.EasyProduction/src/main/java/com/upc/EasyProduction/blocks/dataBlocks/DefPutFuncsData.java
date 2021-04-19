package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutBase;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutBearing;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutProduct;
import com.upc.EasyProduction.panelManagement.Workflow;


public class DefPutFuncsData extends BlockData{
	
	private double velocity;
	private double acceleration;
	
	public DefPutFuncsData(String id, double velocity, double acceleration){
		
		this.id = id;
		this.velocity = velocity;
		this.acceleration = acceleration;
		
	}
	
	public Block getBlockInstance(Workflow wf) {
		
		if (id.equals("DefPutBase")) {
			return new DefPutBase(wf);
		}
		else if (id.equals("DefPutBearing")) {
			return new DefPutBearing(wf);
		}
		else {//if (id == "DefPutProduct") {
			return new DefPutProduct(wf);
		}
	}
	
	public Double getVelocity() {
		return velocity;
	}
	
	public Double getAcceleration() {
		return acceleration;
	}
	
}
