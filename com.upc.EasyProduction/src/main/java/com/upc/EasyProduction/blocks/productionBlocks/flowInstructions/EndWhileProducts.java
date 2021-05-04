package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class EndWhileProducts extends FlowInstructions{
	
	public EndWhileProducts() {
				
		identation = "      ";
		
		defaultCode = "\n"
				+ "        Loop_1 = Loop_1 + 1\n"
				+ "      end";
		
		name = "EndWhile";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("End While of products placement.");
		
		panel.add(infoLabel);
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
