package com.upc.EasyProduction.blocks;

import com.upc.EasyProduction.panelManagement.Workflow;

public class BlockData{
	
	protected String className;
	
	protected Boolean isSelected = false;
		
	public String getClassName() {
		return className;
	}
	
	public Block getBlockInstance() {
		
		Block b = null;
		
		try {
			Class c = Class.forName(className);
			b = (Block) c.getDeclaredConstructor().newInstance();
		}
		catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		finally {}
		
		return b;
	}
}
