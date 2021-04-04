package com.upc.EasyProduction.blocks;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Block extends JLabel{ // no s'hauria de poder instanciar diria (extend JLabel??)
	
	protected String defaultCode; //final?
	
	protected String code;
	
	//protected JLabel blockLabel;
	protected JFrame frame;
	
	protected MouseListener mouseListener;
	
	protected String name;
	
	protected final int WIDTH = 180;
	protected final int HEIGHT = 40;
	
	
	public Block() {
		
		mouseListener = new MouseListener();
		//blockLabel = new JLabel();
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(false);
		
		
		this.addMouseListener(mouseListener);

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
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	// inner classes
	
	protected class MouseListener extends MouseAdapter {
		
		
		public void mouseClicked(MouseEvent e) {
			
			Block b = (Block) e.getSource();
			
			b.getFrame().setVisible(true);

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
