package com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.GetReadyToPutData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class GetReadyToPut extends Block{
	
	public BlockData getDataToSerialize() {
		
		return new GetReadyToPutData(getClassName());
	}

}
