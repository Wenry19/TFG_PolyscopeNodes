package com.upc.EasyProduction.blocks.productionBlocks.callFuncs;



public class CallPutBase extends CallFuncs{
		
	public CallPutBase() {
		
		indentation = "      ";
		
		defaultCode = "\n"
				+ "      $ 38 \"Invocar PUT_BASE_MATRIZ_ASSEMBLY\"\n"
				+ "      PUT_BASE_MATRIZ_ASSEMBLY()";
		
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
