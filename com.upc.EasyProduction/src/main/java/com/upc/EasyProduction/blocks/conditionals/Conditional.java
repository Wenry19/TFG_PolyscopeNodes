package com.upc.EasyProduction.blocks.conditionals;


import java.awt.Color;

import com.upc.EasyProduction.blocks.Block;

public class Conditional extends Block{ // at the moment don't have associated code
	
	public Conditional(String condName) {
		
		name = condName;
		
		this.setText(name);
		
		this.frame.addMouseListener(null);
		this.frame.addMouseMotionListener(null);
		
		this.setBackground(new Color(0xb2c2b1));
	}
	
	public Conditional(String condName, Color color) {
		
		name = condName;
		
		this.setText(name);
		
		this.frame.addMouseListener(null);
		this.frame.addMouseMotionListener(null);
		
		this.setBackground(color);
	}

}
