package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class CallPutBase extends CallFuncs{
		
	public CallPutBase() {
		
		identation = "      ";
		
		defaultCode = "\n"
				+ "      # $ 40 \"Call PUT_BASE_MATRIZ_ASSEMBLY\"\n"
				+ "      PUT_BASE_MATRIZ_ASSEMBLY()\n";
		
		name = "CallPutBase";
		
		this.setText(name);
		
	}
		
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}
}
