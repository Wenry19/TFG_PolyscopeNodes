package com.upc.EasyProduction.blocks.operationBlocks;

import com.upc.EasyProduction.panelManagement.Workflow;

public class Sleep extends Operation {
	
	
	public Sleep(Workflow wf) {
		
		this.wf = wf;
		
		defaultCode = "sleep(3.0)\n";
		
		name = "Sleep"; // can be whatever
		
		id = "Sleep"; // has to be equal to class name
		
		this.setText(name);
		
	}

}
