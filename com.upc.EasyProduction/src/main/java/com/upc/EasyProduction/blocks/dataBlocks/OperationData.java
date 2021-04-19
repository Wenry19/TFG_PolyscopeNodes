package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.GetAnalogInput;
import com.upc.EasyProduction.blocks.operationBlocks.GetDigitalInput;
import com.upc.EasyProduction.blocks.operationBlocks.PopUp;
import com.upc.EasyProduction.blocks.operationBlocks.SetAnalogOutput;
import com.upc.EasyProduction.blocks.operationBlocks.SetDigitalOutput;
import com.upc.EasyProduction.blocks.operationBlocks.Sleep;
import com.upc.EasyProduction.panelManagement.Workflow;

public class OperationData extends BlockData{
	
	
	public OperationData(String id) {
		this.id = id;
	}
	
	public Block getBlockInstance(Workflow wf) {
		
		if (id.equals("GetAnalogInput")) {
			return new GetAnalogInput(wf);
		}
		else if (id.equals("GetDigitalInput")) {
			return new GetDigitalInput(wf);
		}
		else if (id.equals("SetAnalogOutput")) {
			return new SetAnalogOutput(wf);
		}
		else if (id.equals("SetDigitalOutput")) {
			return new SetDigitalOutput(wf);
		}
		else if (id.equals("PopUp")) {
			return new PopUp(wf);
		}
		else {// if (id == "Sleep") {
			return new Sleep(wf);
		}
	}
	
}
