package com.upc.EasyProduction.blocks;

import java.io.Serializable;

import com.upc.EasyProduction.panelManagement.Workflow;

public class BlockData implements Serializable{
	
	protected String id;
	
	public String getID() {
		return id;
	}
	
	public Block getBlockInstance(Workflow wf) {
		return null;
	}

}
