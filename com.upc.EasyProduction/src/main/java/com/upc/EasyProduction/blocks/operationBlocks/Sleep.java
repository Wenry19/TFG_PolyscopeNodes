package com.upc.EasyProduction.blocks.operationBlocks;

public class Sleep extends Operation {
	
	
	public Sleep() {
		
		defaultCode = "sleep(3.0)\n";
		
		name = "Sleep"; // can be whatever
		
		id = "Sleep"; // has to be equal to class name
		
		this.setText(name);
		
	}
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
