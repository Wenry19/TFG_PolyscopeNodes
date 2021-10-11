package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.MoveJ;
import com.ur.urcap.api.domain.value.jointposition.JointPositions;

public class MoveJData extends BlockData{
	
	private String indentation;
	
	private String pos;
	
	public MoveJData(String className, Boolean isSelected, Boolean readyToExecute, String indentation, String pos) {
		
		this.className = className;
		this.isSelected = isSelected;
		this.readyToExecute = readyToExecute;
		
		this.indentation = indentation;
				
		this.pos = pos;
		
	}
	
	@Override
	public Block getBlockInstance() {
				
		MoveJ b = (MoveJ) super.getBlockInstance();
		
		b.setIndentation(indentation);
				
		b.setPos(pos);
		
		b.setPanel();
						
		return (Block) b;
	}

}
