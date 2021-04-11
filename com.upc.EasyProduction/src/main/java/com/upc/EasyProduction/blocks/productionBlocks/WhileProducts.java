package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class WhileProducts extends Block {
	
	public WhileProducts() {
		defaultCode = "\n"
				+ "      # $ 71 \"Loop 4 times\"\n"
				+ "      Loop_1 = 0\n"
				+ "      while (Loop_1 < 4):";
		
		name = "WhileProducts<4";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
	}
	

	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
