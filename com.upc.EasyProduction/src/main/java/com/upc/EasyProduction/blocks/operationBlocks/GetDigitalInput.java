package com.upc.EasyProduction.blocks.operationBlocks;

import com.upc.EasyProduction.panelManagement.Workflow;

public class GetDigitalInput extends Operation{
	
	public GetDigitalInput(Workflow wf) {
		
		this.wf = wf;
		
		defaultCode = "\n"
				+ "\n";
		
		name = "GetDigitalInput"; // can be whatever
				
		this.setText(name);
		
	}
}
