package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class EndWhileTrue extends FlowInstructions {
	
	public EndWhileTrue() {
				
		identation = "  ";
		
		defaultCode = "\n"
				+ "  end\n";
		
		name = "EndWhile";
		
		this.setText(name);
		
		this.setBackground(new Color(0xaeaebf));
		
		infoLabel.setText("End While True.");
		
		panel.add(infoLabel);
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
