package com.upc.EasyProduction.blocks;

public class SetDigitalOutput extends Operation{
	
	public SetDigitalOutput() {
		
		defaultCode = "\n"
				+ "\n";
		
		name = "SetDigitalOutput"; // can be whatever
		
		id = "SetDigitalOutput"; // has to be equal to class name
		
		this.setText(name);
		
	}
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
