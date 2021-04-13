package com.upc.EasyProduction.blocks.productionBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.panelManagement.Workflow;

public class CallPutBase extends Block{
		
	public CallPutBase(Workflow wf) {
		
		this.wf = wf;
		
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
