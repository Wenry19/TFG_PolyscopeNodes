package com.upc.EasyProduction.blocks.operations;

public class SetAnalogOutput extends Operation{
	
	public SetAnalogOutput() {
		
		defaultCode = "\n"
				+ "\n";
		
		name = "SetAnalogInput"; // can be whatever
		
		id = "SetAnalogInput"; // has to be equal to class name
		
		this.setText(name);
		
	}
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
