package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class EndWhileTrue extends Block {
	
	public EndWhileTrue() {
		
		identation = "  ";
		
		defaultCode = "\n"
				+ "  end\n";
		
		name = "EndWhile";
		
		this.setText(name);
		
		this.setBackground(new Color(0xaeaebf));
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
