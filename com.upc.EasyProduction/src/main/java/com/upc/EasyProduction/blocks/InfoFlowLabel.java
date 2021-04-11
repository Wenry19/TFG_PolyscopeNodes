package com.upc.EasyProduction.blocks;


import java.awt.Color;

public class InfoFlowLabel extends Block{ // similar to block but without associated code
	
	protected Color defaultColor = new Color(0xb2c2b1);
	
	public InfoFlowLabel(String name) {
		
		initialize(name, defaultColor);
	}
	
	public InfoFlowLabel(String name, Color color) {
		
		initialize(name, color);
	}
	
	private void initialize(String name, Color color) {
		
		this.code = "";
		this.defaultCode = "";
		
		this.name = name;
		
		this.setText(name);
		
		this.setBackground(color);
		
	}

}
