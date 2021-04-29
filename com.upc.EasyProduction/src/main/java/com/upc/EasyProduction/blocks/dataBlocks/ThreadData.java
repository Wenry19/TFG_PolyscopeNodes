package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class ThreadData extends BlockData{
			
	public ThreadData(String className, Boolean isSelected) {
		
		this.className = className;
		this.isSelected = isSelected;
	}
}
