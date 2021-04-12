package com.upc.EasyProduction.blocks.operationBlocks;

public class SetDigitalOutput extends Operation{
	
	public SetDigitalOutput() {
		
		defaultCode = "\n"
				+ "\n";
		
		name = "SetDigitalOutput"; // can be whatever
		
		id = "SetDigitalOutput"; // has to be equal to class name
		
		this.setText(name);
		
	}
}
