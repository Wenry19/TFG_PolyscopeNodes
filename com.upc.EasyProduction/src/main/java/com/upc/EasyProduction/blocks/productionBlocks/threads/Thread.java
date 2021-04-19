package com.upc.EasyProduction.blocks.productionBlocks.threads;

import java.awt.Color;


import javax.swing.BorderFactory;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Thread extends Block{
	
	public Thread() {
		this.setBackground(new Color(0xd3caca));
		this.setBorder(BorderFactory.createDashedBorder(null, 5, 5));
	}
	
	public BlockData getDataToSerialize() {
		
		return new ThreadData(this.getClass().getName());
		
	}
	
	
	// inner data class
	
	public class ThreadData extends BlockData{
				
		public ThreadData(String id) {
			this.id = id;
		}
		
		public Block getBlockInstance(Workflow wf) {
			
			if (id == "ExperimentTimeThread") {
				return new ExperimentTimeThread(wf);
			}
			else if (id == "TimerThread") {
				return new TimerThread(wf);
			}
			else {//if (id == "WriteRegistersThread") {
				return new WriteRegistersThread(wf);
			}
		}
	}
}
