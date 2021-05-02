package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class WhileProducts extends FlowInstructions {
	
	public WhileProducts() {
				
	    identation = "        ";
		
		defaultCode = "\n"
				+ "      # $ 71 \"Loop 4 times\"\n"
				+ "      Loop_1 = 0\n"
				+ "      while (Loop_1 < 4):";
		
		name = "While(Products<4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("While of products placement.");
		
		panel.add(infoLabel);
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
