package com.upc.EasyProduction.blocks.productionBlocks.flowInstructions;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class IfBases extends FlowInstructions{
	
	public IfBases() {
				
		identation = "      ";
		
		defaultCode = "\n"
				+ "    # $ 21 \"'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'\"\n"
				+ "    # 'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'\n"
				+ "    # $ 22 \"If N_Bases<4\"\n"
				+ "    if (N_Bases<4):";
		
		name = "If(Bases<4)";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
	}
	

	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}

}
