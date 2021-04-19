package com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class GetReadyToPut extends Block{
	
	public BlockData getDataToSerialize() {
		
		return new GetReadyToPutData(this.getClass().getName());
		
	}
	
	// inner data class
	
	public class GetReadyToPutData extends BlockData{
				
		public GetReadyToPutData(String id) {
			
			this.id = id;
			
		}
		
		public Block getBlockInstance(Workflow wf) {
			
			if (id == "DestackBase") {
				return new DestackBase(wf);
			}
			else if (id == "DestackBearing") {
				return new DestackBearing(wf);
			}
			else {//if (id == "DespalletizeProduct") {
				return new DespalletizeProduct(wf);
			}
		}
		
	}

}
