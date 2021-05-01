package com.upc.EasyProduction.blocks;


public class BlockData{
	
	protected String className;
	
	protected Boolean isSelected = false;
	
	//protected int wfPos; // it will be used to identify the blockdata in the datamodel (key)
		
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
