package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.Sleep;

public class SleepData extends BlockData{
	
	private String indentation;
	
	private int duration;
	
	public SleepData(String className, Boolean isSelected, String indentation, int duration) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.duration = duration;
	}
	
	@Override
	public Block getBlockInstance() {
				
		Sleep b = (Sleep) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setDuration(duration);
		
		b.setPanel();
				
		return (Block) b;
	}
}
