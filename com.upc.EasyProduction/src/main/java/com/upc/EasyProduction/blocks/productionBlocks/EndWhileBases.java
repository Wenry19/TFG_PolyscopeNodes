package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class EndWhileBases extends Block{
	
	
	public EndWhileBases() {
		defaultCode = "\n"
				+ "    end";
		
		name = "EndWhileBases";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
	}
	

	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
