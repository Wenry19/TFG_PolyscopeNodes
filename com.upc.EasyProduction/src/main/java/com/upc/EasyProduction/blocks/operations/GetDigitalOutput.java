package com.upc.EasyProduction.blocks.operations;

public class GetDigitalOutput extends Operation{
	
	public GetDigitalOutput() {
		
		defaultCode = "\n"
				+ "\n";
		
		name = "GetDigitalOutput"; // can be whatever
		
		id = "GetDigitalOutput"; // has to be equal to class name
		
		this.setText(name);
		
	}
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
