package com.upc.EasyProduction.blocks.productionBlocks.humanWork;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class HumanWork extends Block{
	
	public BlockData getDataToSerialize() {
		
		return new HumanWorkData(this.getClass().getName());
		
	}
	
	// inner data class
	
	public class HumanWorkData extends BlockData{
			
		public HumanWorkData(String id) {
			
			this.id = id;
			
		}
		
		public Block getBlockInstance(Workflow wf) {
			
			return new GetCAPs(wf);
		}
	}

}
