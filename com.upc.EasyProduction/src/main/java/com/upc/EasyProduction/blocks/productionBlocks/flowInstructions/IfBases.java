package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class IfBases extends FlowInstructions{
	
	public IfBases() {
				
		indentation = "      ";
		
		defaultCode = "\n"
				+ "    $ 22 \"If N_Bases<4\"\n"
				+ "    if (N_Bases<4):";
		
		name = "If(Bases<4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("If of bases placement.");
		
		panel.add(infoLabel);
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
