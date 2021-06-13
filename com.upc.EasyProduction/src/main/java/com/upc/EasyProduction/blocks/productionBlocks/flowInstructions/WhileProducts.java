package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;
import java.awt.GridBagConstraints;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class WhileProducts extends FlowInstructions {
	
	public WhileProducts() {
				
	    indentation = "        ";
		
		defaultCode = "\n"
				+ "      $ 67 \"Bucle 4 veces\"\n"
				+ "      Loop_1 = 0\n"
				+ "      while (Loop_1 < 4):";
		
		name = "While(Products<4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("While of products placement.");
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 3;
		c.gridheight = 3;
		
		c.gridx = 1;
		c.gridy = 1;
		
		panel.add(infoLabel, c);
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
