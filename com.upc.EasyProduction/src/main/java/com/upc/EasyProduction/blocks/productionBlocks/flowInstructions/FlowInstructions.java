package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class FlowInstructions extends Block {
	
	public BlockData getDataToSerialize() {
		
		return new FlowInstructionsData(this.getClass().getName());
		
	}
	
	// inner data class
	
	public class FlowInstructionsData extends BlockData{
				
		public FlowInstructionsData(String id) {
			
			this.id = id;
			
		}
		
		public Block getBlockInstance(Workflow wf) {
			
			if (id == "WhileTrue") {
				return new WhileTrue(wf);
			}
			else if (id == "IfBases") {
				return new IfBases(wf);
			}
			else if (id == "EndIfBases") {
				return new EndIfBases(wf);
			}
			else if (id == "IfBearings") {
				return new IfBearings(wf);
			}
			else if (id == "EndIfBearings") {
				return new EndIfBearings(wf);
			}
			else if (id == "IfCAPSandProducts") {
				return new IfCAPSandProducts(wf);
			}
			else if (id == "WhileProducts") {
				return new WhileProducts(wf);
			}
			else if (id == "EndWhileProducts") {
				return new EndWhileProducts(wf);
			}
			else if (id == "EndIfCAPSandProducts") {
				return new EndIfCAPSandProducts(wf);
			}
			else { //if (id == "EndWhileTrue") {
				return new EndWhileTrue(wf);
			}
		}
		
	}

}
