package com.upc.EasyProduction.blocks.operationBlocks;

public class PopUp extends Operation{
	
	public PopUp() {
				
		defaultCode = "popup(\"Demo message\")";
		
		name = "PopUp"; // can be whatever
				
		this.setText(name);
		
	}
}
