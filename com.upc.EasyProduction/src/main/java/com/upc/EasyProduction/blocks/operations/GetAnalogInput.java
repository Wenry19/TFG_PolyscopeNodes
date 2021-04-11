package com.upc.EasyProduction.blocks.operations;

public class GetAnalogInput extends Operation{
	
	public GetAnalogInput() {
		
		defaultCode = "\n"
				+ "\n";
		
		name = "GetAnalogInput"; // can be whatever
		
		id = "GetAnalogInput"; // has to be equal to class name
		
		this.setText(name);
		
	}
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
