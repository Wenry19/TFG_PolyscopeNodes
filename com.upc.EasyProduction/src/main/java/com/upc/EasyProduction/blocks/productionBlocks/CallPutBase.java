package com.upc.EasyProduction.blocks.productionBlocks;

import com.upc.EasyProduction.blocks.Block;

public class CallPutBase extends Block{
		
	public CallPutBase() {
		
		defaultCode = "\n"
				+ "      # $ 40 \"Call PUT_BASE_MATRIZ_ASSEMBLY\"\n"
				+ "      PUT_BASE_MATRIZ_ASSEMBLY()\n"
				+ "    end";
		
		name = "CallPutBase";
		
		this.setText(name);
		
	}
		
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}
}
