package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;
import java.awt.GridBagConstraints;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class EndWhileTrue extends FlowInstructions {
	
	public EndWhileTrue() {
				
		indentation = "  ";
		
		defaultCode = "\n"
				+ "  end\n";
		
		name = "EndWhile";
		
		this.setText(name);
		
		this.setBackground(new Color(0xaeaebf));
		
		infoLabel.setText("End While True.");
		
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
