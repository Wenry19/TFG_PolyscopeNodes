package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class IfBearings extends FlowInstructions{
	
	
	public IfBearings() {
		
		identation = "      ";
		
		defaultCode = "\n"
				+ "    # $ 41 \"If N_Bases≥4\"\n"
				+ "    if (N_Bases >= 4):";
		
		name = "If(Bases>=4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("If of bearings placement.");
		
		panel.add(infoLabel);
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
