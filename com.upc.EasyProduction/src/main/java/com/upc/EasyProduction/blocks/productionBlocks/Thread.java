package com.upc.EasyProduction.blocks.productionBlocks;

import java.awt.Color;

import javax.swing.BorderFactory;

import com.upc.EasyProduction.blocks.Block;

public class Thread extends Block{
	
	public Thread() {
		this.setBackground(new Color(0xd3caca));
		this.setBorder(BorderFactory.createDashedBorder(null, 5, 5));
	}
}
