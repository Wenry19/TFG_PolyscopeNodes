package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.Color;



import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Operation extends Block{
		
	public Operation() {
		
		this.setBackground(new Color(0xeae7e7));
	}
	
	
	@Override
	public String getDefaultCode() {
		return "\n" + identation + defaultCode; //ULL!!!!
	}
	
	@Override
	public String generateCode() {
		code = defaultCode;
		
		return "\n" + identation + code;
	}
	
	public BlockData getDataToSerialize() {
		return new OperationData(this.getClass().getName());
	}
	
	// inner data class
	
	public class OperationData extends BlockData{
		
		
		public OperationData(String id) {
			this.id = id;
		}
		
		public Block getBlockInstance(Workflow wf) {
			
			if (id == "GetAnalogInput") {
				return new GetAnalogInput(wf);
			}
			else if (id == "GetDigitalInput") {
				return new GetDigitalInput(wf);
			}
			else if (id == "SetAnalogOutput") {
				return new SetAnalogOutput(wf);
			}
			else if (id == "SetDigitalOutput") {
				return new SetDigitalOutput(wf);
			}
			else if (id == "PopUp") {
				return new PopUp(wf);
			}
			else {// if (id == "Sleep") {
				return new Sleep(wf);
			}
		}
		
	}

}
