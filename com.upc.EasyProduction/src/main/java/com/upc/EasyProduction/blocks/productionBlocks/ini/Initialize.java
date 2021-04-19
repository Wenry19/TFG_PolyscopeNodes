package com.upc.EasyProduction.blocks.productionBlocks.ini;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Initialize extends Block{
	
	public BlockData getDataToSerialize() {
		
		return new InitializeData(this.getClass().getName());
		
	}
	
	// inner data class
	
	public class InitializeData extends BlockData{
				
		public InitializeData(String id) {
			
			this.id = id;
			
		}
		
		public Block getBlockInstance(Workflow wf) {
			
			return new InitializeVars(wf);
		}
		
	}

}
