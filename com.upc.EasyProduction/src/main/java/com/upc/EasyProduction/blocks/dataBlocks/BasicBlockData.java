package com.upc.EasyProduction.blocks.dataBlocks;

import com.upc.EasyProduction.blocks.BlockData;

/**
 * This class represents a basic block data which is a block data that contains the common data
 * that have to be saved of all the blocks.
 * 
 * @author Enric Lamarca Ferrés
 *
 */
public class BasicBlockData extends BlockData{
	
	/**
	 * Constructor.
	 * @param className class name of the corresponding block instance.
	 * @param isSelected boolean that indicates if the corresponding block is selected.
	 */
	public BasicBlockData(String className, Boolean isSelected) {
		
		this.className = className;
		this.isSelected = isSelected;
	}

}
