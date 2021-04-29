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
			Class c = Class.forName(className);
			b = (Block) c.getDeclaredConstructor().newInstance();
			
			b.setIsSelected(isSelected);
		}
		catch (Exception e) {
			
			System.out.println(e.toString());
			
		}
		finally {}
		
		System.out.println("ADEUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		
		return b;
	}
}
