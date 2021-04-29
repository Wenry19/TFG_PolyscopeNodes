package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;


public class CallFuncsData extends BlockData{
	
	public CallFuncsData(String className, Boolean isSelected) {
		
		this.className = className;
		this.isSelected = isSelected;
	}
}