package com.upc.EasyProduction.blocks.operationBlocks;

import com.upc.EasyProduction.panelManagement.Workflow;

public class Sleep extends Operation {
	
	
	public Sleep() {
		
		defaultCode = "sleep(3.0)\n";
		
		name = "Sleep"; // can be whatever
				
		this.setText(name);
		
	}

}
