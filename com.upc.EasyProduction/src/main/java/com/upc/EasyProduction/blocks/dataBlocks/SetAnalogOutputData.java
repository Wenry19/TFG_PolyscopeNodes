package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.SetAnalogOutput;

public class SetAnalogOutputData extends BlockData {
	
	private String indentation;
	
	private String out;
	private String value;
	
	public SetAnalogOutputData(String className, Boolean isSelected, String indentation, String out, String value) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.out = out;
		this.value = value;
	}
	
	@Override
	public Block getBlockInstance() {
				
		SetAnalogOutput b = (SetAnalogOutput) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setOut(out);
		b.setValue(value);
		
		b.setPanel();
				
		return (Block) b;
	}
	
}
