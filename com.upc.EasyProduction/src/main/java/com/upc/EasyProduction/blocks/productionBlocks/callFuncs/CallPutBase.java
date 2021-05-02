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
		
		infoLabel.setText("Call of the function PutBase defined previously.");
		
		panel.add(infoLabel);
		
	}
		
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return code;
	}
}
