package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class EndIfCAPSandProducts extends FlowInstructions{
	
	public EndIfCAPSandProducts() {
				
		identation = "    ";
		
		defaultCode = "\n"
				+ "    end\n";
		
		name = "EndIf";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
