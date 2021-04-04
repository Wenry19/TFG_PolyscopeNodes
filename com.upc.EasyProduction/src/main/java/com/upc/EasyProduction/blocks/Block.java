package com.upc.EasyProduction.blocks;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;


public class Block { // no s'hauria de poder instanciar diria
	
	protected String defaultCode; //final?
	
	protected String code;
	
	protected JLabel blockLabel;
	
	protected String name;
	
	protected final int WIDTH = 200;
	protected final int HEIGHT = 50;
	
	
	public Block() {

	}
	
	
	public String getCode() {
		return generateCode();
	}
	
	public String getDefaultCode() {
		return defaultCode;
	}
	
	protected String generateCode() {
		code = "";
		
		return code;
	}
	
	public JLabel getBlockLabel() {
		return blockLabel;
	}
	
	public String getName() {
		return name;
	}
	
	// inner classes
	
	protected class MouseListener extends MouseAdapter {
		
		
		public void mouseClicked(MouseEvent e) {

		}
		
		public void mousePressed(MouseEvent e) {
				
		}
		
		public void mouseDragged(MouseEvent e) {
	        			
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}
	}
	
	
}
