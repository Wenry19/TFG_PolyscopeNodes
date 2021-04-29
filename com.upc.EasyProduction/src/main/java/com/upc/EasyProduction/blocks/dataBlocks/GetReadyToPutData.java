package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

// inner data class

public class GetReadyToPutData extends BlockData{
			
	public GetReadyToPutData(String className, Boolean isSelected) {
		
		this.className = className;
		this.isSelected = isSelected;
				
	}
}
