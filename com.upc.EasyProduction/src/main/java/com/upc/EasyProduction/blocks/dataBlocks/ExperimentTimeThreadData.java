package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.threads.ExperimentTimeThread;

public class ExperimentTimeThreadData extends BlockData {
	
	private Boolean activateExperimentTimer = false;
	
	public ExperimentTimeThreadData(String className, Boolean isSelected, Boolean activateExperimentTimer) {
		
		this.className = className; // només per aconseguir instància del bloc
		this.isSelected = isSelected; // s'encarrega el workflow
		this.activateExperimentTimer = activateExperimentTimer; // s'ha de fer set d'això a la nova instància
	}
	
	@Override
	public Block getBlockInstance() {
				
		ExperimentTimeThread b = (ExperimentTimeThread) super.getBlockInstance();
		
		b.setActivateExperimentTimer(activateExperimentTimer); // order is important!!
		
		b.setPanel(); // order is important!!
						
		return (Block) b;
	}

}
