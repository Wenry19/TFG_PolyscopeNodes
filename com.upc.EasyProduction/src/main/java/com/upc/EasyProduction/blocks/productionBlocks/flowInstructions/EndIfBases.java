package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class EndIfBases extends FlowInstructions{
	
	
	public EndIfBases() {
		
		indentation = "    ";
		
		defaultCode = "\n"
				+ "    end";
		
		name = "EndIf";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
		
		infoLabel.setText("End If of bases placement.");
		
		panel.add(infoLabel);
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
