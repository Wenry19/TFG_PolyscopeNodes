package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class IfCAPSandProducts extends Block{
	
	public IfCAPSandProducts(Workflow wf) {
		
		this.wf = wf;
		
		identation = "      ";
		
		defaultCode = "\n"
				+ "    # $ 63 \"If N_Bearings≥4\"\n"
				+ "    if (N_Bearings >= 4):\n";
		
		name = "If(Bearings>=4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
