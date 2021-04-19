package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.productionBlocks.threads.ExperimentTimeThread;
import com.upc.EasyProduction.blocks.productionBlocks.threads.TimerThread;
import com.upc.EasyProduction.blocks.productionBlocks.threads.WriteRegistersThread;
import com.upc.EasyProduction.panelManagement.Workflow;


public class ThreadData extends BlockData{
			
	public ThreadData(String id) {
		this.id = id;
	}
	
	public Block getBlockInstance(Workflow wf) {
		
		if (id .equals("ExperimentTimeThread")) {
			return new ExperimentTimeThread(wf);
		}
		else if (id .equals("TimerThread")) {
			return new TimerThread(wf);
		}
		else {//if (id == "WriteRegistersThread") {
			return new WriteRegistersThread(wf);
		}
	}
}
