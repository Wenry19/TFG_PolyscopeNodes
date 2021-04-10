package com.upc.EasyProduction.blocks;

public class PopUp extends Operation{
	
	public PopUp() {
		
		defaultCode = "\n"
				+ "\n";
		
		name = "PopUp"; // can be whatever
		
		id = "PopUp"; // has to be equal to class name
		
		this.setText(name);
		
	}
	
	@Override
	protected String generateCode() {
		code = "";
		
		return code;
	}

}
