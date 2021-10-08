package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.Script;

public class ScriptData extends BlockData{
	
	/**
	 * Indentation of the PopUP block.
	 */
	private String indentation;
	
	private String code;
	
	public ScriptData(String className, Boolean isSelected, String indentation, String code) {
		
		this.className = className;
		this.isSelected = isSelected;
		
		this.indentation = indentation;
		
		this.code = code;
	}
	
	@Override
	public Block getBlockInstance() {
				
		Script b = (Script) super.getBlockInstance();
		
		b.setIndentation(indentation);
		
		b.setCode(code);
		
		b.setPanel();
						
		return (Block) b;
	}

}
