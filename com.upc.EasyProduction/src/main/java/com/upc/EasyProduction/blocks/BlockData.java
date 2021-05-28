package com.upc.EasyProduction.blocks;


public class BlockData{
	
	protected String className;
	
	protected Boolean isSelected = false;
		
	
	public String getClassName() {
		return className;
	}
	
	public Block getBlockInstance() {
		
		Block b = null;
		
		try {
			
			b = (Block) Class.forName(className).getDeclaredConstructor().newInstance();
			
			b.setIsSelected(isSelected);
			
		}
		catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		return b;
	}
}
