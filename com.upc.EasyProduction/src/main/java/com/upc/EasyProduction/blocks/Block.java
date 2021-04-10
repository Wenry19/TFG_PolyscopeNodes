package com.upc.EasyProduction.blocks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Block extends JLabel{ // no s'hauria de poder instanciar diria (extend JLabel??)
	
	protected String name;
	
	protected String defaultCode; //final?
	
	protected String code;
	
	protected JFrame frame;
	
	protected MouseListener mouseListener;
	
	protected final int WIDTH = 180;
	protected final int HEIGHT = 40;
	
	protected int wfPos;
	
	
	public Block() {
		
		mouseListener = new MouseListener();
		//blockLabel = new JLabel();
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(false);
		
		
		this.addMouseListener(mouseListener);
		
		this.setOpaque(true);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.setBackground(Color.LIGHT_GRAY);
		
		wfPos = -1; // not in workflow

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
	
	
	public String getName() {
		return name;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setWorkflowPosition(int pos) {
		
		wfPos = pos;
		
	}
	
	public int getWorkflowPosition() {
		
		return wfPos;
		
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
