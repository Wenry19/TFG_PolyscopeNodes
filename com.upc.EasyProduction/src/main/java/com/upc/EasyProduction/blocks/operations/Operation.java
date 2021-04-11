package com.upc.EasyProduction.blocks.operations;

import java.awt.Color;

import javax.swing.BorderFactory;

import com.upc.EasyProduction.blocks.Block;

public class Operation extends Block{
	
	protected String id;
	
	public Operation() {
		this.setBackground(new Color(0xeae7e7));
	}
	
	protected String getID() {
		return id;
	}

}
