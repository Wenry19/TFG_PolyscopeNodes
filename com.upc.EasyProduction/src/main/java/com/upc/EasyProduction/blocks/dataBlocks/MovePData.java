package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.MoveP;

public class MovePData extends BlockData{
	
	private String indentation;
	
	private String pos;
	
	public MovePData(String className, Boolean isSelected, String indentation, String pos) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
				
		this.pos = pos;
		
	}
	
	@Override
	public Block getBlockInstance() {
				
		MoveP b = (MoveP) super.getBlockInstance();
		
		b.setIndentation(indentation);
				
		b.setPos(pos);
		
		b.setPanel();
						
		return (Block) b;
	}
}
