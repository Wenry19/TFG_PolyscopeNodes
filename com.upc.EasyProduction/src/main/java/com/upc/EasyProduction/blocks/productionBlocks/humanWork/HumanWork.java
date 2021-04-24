package com.upc.EasyProduction.blocks.productionBlocks.humanWork;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.HumanWorkData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class HumanWork extends Block{
	
	public BlockData getBlockData() {
			
		return new HumanWorkData(getClassName());
		
	}

}
