package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class OperationData extends BlockData{
	
	
	public OperationData(String className, Boolean isSelected) {
		
		this.className = className;
		this.isSelected = isSelected;
	}
}
