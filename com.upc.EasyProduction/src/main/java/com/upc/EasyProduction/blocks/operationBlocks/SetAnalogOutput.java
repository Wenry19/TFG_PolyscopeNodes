package com.upc.EasyProduction.blocks.operationBlocks;

import com.upc.EasyProduction.panelManagement.Workflow;

public class SetAnalogOutput extends Operation{
	
	public SetAnalogOutput(Workflow wf) {
		
		this.wf = wf;
		
		defaultCode = "\n"
				+ "\n";
		
		name = "SetAnalogInput"; // can be whatever
				
		this.setText(name);
		
	}

}
