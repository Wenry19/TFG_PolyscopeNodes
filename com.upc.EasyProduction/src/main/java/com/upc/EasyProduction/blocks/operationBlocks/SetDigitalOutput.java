package com.upc.EasyProduction.blocks.operationBlocks;

import com.upc.EasyProduction.panelManagement.Workflow;

public class SetDigitalOutput extends Operation{
	
	public SetDigitalOutput(Workflow wf) {
		
		this.wf = wf;
		
		defaultCode = "\n"
				+ "\n";
		
		name = "SetDigitalOutput"; // can be whatever
		
		id = "SetDigitalOutput"; // has to be equal to class name
		
		this.setText(name);
		
	}
}
