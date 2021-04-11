package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class IfBases extends Block{
	
	public IfBases() {
		
		identation = "    ";
		
		defaultCode = "\n"
				+ "    # $ 21 \"'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'\"\n"
				+ "    # 'StartPos_Bases= Punto de contacto con el stack=StackPos_Base'\n"
				+ "    # $ 22 \"If N_Bases<4\"\n"
				+ "    if (N_Bases<4):";
		
		name = "IfBases<4";
		
		this.setText(name);
		
		this.setBackground(new Color(0xb2c2b1));
	}
	

	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
