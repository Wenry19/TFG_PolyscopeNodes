package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.callFuncs.CallPutBase;
import com.upc.EasyProduction.blocks.productionBlocks.callFuncs.CallPutBearing;
import com.upc.EasyProduction.blocks.productionBlocks.callFuncs.CallPutProduct;
import com.upc.EasyProduction.panelManagement.Workflow;


public class CallFuncsData extends BlockData{
	
	public CallFuncsData(String id) {
		this.id = id;
	}
	
	public Block getBlockInstance(Workflow wf) {
				
		if (id.equals("CallPutBase")) {
			return new CallPutBase(wf);
		}
		else if (id.equals("CallPutBearing")) {
			return new CallPutBearing(wf);
		}
		else {//if (id == "CallPutProduct") {
			return new CallPutProduct(wf);
		}
	}
	
}