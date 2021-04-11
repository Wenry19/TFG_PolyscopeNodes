package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class IfCAPSandProducts extends Block{
	
	public IfCAPSandProducts() {
		
		identation = "      ";
		
		defaultCode = "\n"
				+ "    # $ 63 \"If N_Bearings≥4\"\n"
				+ "    if (N_Bearings >= 4):\n";
		
		name = "If(Bearings>=4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
	}
	

	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
