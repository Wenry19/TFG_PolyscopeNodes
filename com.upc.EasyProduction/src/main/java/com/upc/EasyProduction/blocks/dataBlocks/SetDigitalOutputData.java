package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.SetDigitalOutput;

public class SetDigitalOutputData extends BlockData{
	
	private String indentation;
	
	private String out;
	private String value;
	
	public SetDigitalOutputData(String className, Boolean isSelected, String indentation, String out, String value) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.out = out;
		this.value = value;
	}
	
	@Override
	public Block getBlockInstance() {
				
		SetDigitalOutput b = (SetDigitalOutput) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setOut(out);
		b.setValue(value);
		
		b.setPanel();
				
		return (Block) b;
	}
	
}
