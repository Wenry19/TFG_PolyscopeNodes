package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import com.upc.EasyProduction.blocks.Block;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class CallFuncs extends Block{
	
	public BlockData getDataToSerialize() {
		return new CallFuncsData(this.getClass().getName());
	}
	
	// inner data class
	
	public class CallFuncsData extends BlockData{
		
		public CallFuncsData(String id) {
			this.id = id;
		}
		
		public Block getBlockInstance(Workflow wf) {
			
			if (id == "CallPutBase") {
				return new CallPutBase(wf);
			}
			else if (id == "CallPutBearing") {
				return new CallPutBearing(wf);
			}
			else {//if (id == "CallPutProduct") {
				return new CallPutProduct(wf);
			}
		}
		
	}
}
