package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class EndWhileTrue extends Block {
	
	public EndWhileTrue() {
		defaultCode = "\n"
				+ "  end\n";
		
		name = "EndWhileTrue";
		
		this.setText(name);
		
		this.setBackground(new Color(0xaeaebf));
	}
	

	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
