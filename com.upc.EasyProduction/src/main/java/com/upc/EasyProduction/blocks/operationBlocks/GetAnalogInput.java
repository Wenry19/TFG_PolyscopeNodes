package com.upc.EasyProduction.blocks.operationBlocks;

import com.upc.EasyProduction.panelManagement.Workflow;

public class GetAnalogInput extends Operation{
	
	public GetAnalogInput(Workflow wf) {
		
		this.wf = wf;
		
		defaultCode = "\n"
				+ "\n";
		
		name = "GetAnalogInput"; // can be whatever
		
		id = "GetAnalogInput"; // has to be equal to class name
		
		this.setText(name);
		
	}

}
