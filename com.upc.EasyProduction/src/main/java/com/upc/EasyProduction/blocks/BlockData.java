package com.upc.EasyProduction.blocks;


public class BlockData{
	
	protected String className;
	
	protected Boolean isSelected = false;
	
	
	public String getClassName() {
		return className;
	}
	
	public Block getBlockInstance(String BlockDataString) {
		
		Block b = null;
		
		try {
			
			b = (Block) Class.forName(className).getDeclaredConstructor().newInstance();
			
			b.setIsSelected(isSelected);
			
			b.setBlockDataString(BlockDataString);
		}
		catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		
		return b;
	}
}
