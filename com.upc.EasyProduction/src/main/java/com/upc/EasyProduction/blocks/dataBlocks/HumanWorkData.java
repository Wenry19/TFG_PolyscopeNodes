package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.humanWork.GetCAPs;
import com.upc.EasyProduction.panelManagement.Workflow;


public class HumanWorkData extends BlockData{
		
	public HumanWorkData(String id) {
		
		this.id = id;
		
	}
	
	public Block getBlockInstance(Workflow wf) {
		
		return new GetCAPs(wf);
	}
}
