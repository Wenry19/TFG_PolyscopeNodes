package com.upc.EasyProduction.blocks.productionBlocks.ini;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.InitializeData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Initialize extends Block{
	
	public BlockData getBlockData() {
		
		return new InitializeData(getClassName(), isSelected);
		
	}

}
