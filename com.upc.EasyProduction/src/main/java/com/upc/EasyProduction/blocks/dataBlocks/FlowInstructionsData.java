package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndIfBases;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndIfBearings;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndIfCAPSandProducts;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndWhileProducts;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndWhileTrue;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.IfBases;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.IfBearings;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.IfCAPSandProducts;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.WhileProducts;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.WhileTrue;
import com.upc.EasyProduction.panelManagement.Workflow;

// inner data class

public class FlowInstructionsData extends BlockData{
			
	public FlowInstructionsData(String id) {
		
		this.id = id;
		
	}
	
	public Block getBlockInstance(Workflow wf) {
		
		if (id.equals("WhileTrue")) {
			return new WhileTrue(wf);
		}
		else if (id.equals("IfBases")) {
			return new IfBases(wf);
		}
		else if (id.equals("EndIfBases")) {
			return new EndIfBases(wf);
		}
		else if (id.equals("IfBearings")) {
			return new IfBearings(wf);
		}
		else if (id.equals("EndIfBearings")) {
			return new EndIfBearings(wf);
		}
		else if (id.equals("IfCAPSandProducts")) {
			return new IfCAPSandProducts(wf);
		}
		else if (id.equals("WhileProducts")) {
			return new WhileProducts(wf);
		}
		else if (id.equals("EndWhileProducts")) {
			return new EndWhileProducts(wf);
		}
		else if (id.equals("EndIfCAPSandProducts")) {
			return new EndIfCAPSandProducts(wf);
		}
		else { //if (id == "EndWhileTrue") {
			return new EndWhileTrue(wf);
		}
	}
	
}
