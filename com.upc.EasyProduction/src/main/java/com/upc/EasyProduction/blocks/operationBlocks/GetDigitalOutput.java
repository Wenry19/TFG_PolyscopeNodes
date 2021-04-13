package com.upc.EasyProduction.blocks.operationBlocks;

import com.upc.EasyProduction.panelManagement.Workflow;

public class GetDigitalOutput extends Operation{
	
	public GetDigitalOutput(Workflow wf) {
		
		this.wf = wf;
		
		defaultCode = "\n"
				+ "\n";
		
		name = "GetDigitalOutput"; // can be whatever
		
		id = "GetDigitalOutput"; // has to be equal to class name
		
		this.setText(name);
		
	}
}
