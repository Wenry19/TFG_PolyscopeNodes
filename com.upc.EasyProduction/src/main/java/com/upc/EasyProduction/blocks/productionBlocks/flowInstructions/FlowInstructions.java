package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.FlowInstructionsData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class FlowInstructions extends Block {
	
	public BlockData getBlockData() {	
		return new FlowInstructionsData(getClassName());
		
	}
}
