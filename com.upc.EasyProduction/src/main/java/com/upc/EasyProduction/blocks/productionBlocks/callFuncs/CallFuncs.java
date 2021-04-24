package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import com.upc.EasyProduction.blocks.Block;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.CallFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class CallFuncs extends Block{
	
	public BlockData getBlockData() {
		return new CallFuncsData(getClassName());
	}
	
}
