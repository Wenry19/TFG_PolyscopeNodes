package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut.DespalletizeProduct;
import com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut.DestackBase;
import com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut.DestackBearing;
import com.upc.EasyProduction.panelManagement.Workflow;

// inner data class

public class GetReadyToPutData extends BlockData{
			
	public GetReadyToPutData(String id) {
		
		this.id = id;
		
	}
	
	public Block getBlockInstance(Workflow wf) {
		
		if (id.equals("DestackBase")) {
			return new DestackBase(wf);
		}
		else if (id.equals("DestackBearing")) {
			return new DestackBearing(wf);
		}
		else {//if (id == "DespalletizeProduct") {
			return new DespalletizeProduct(wf);
		}
	}
	
}
