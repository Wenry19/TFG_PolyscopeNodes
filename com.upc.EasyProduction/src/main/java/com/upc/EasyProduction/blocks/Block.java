package com.upc.EasyProduction.blocks;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Dictionary;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.blocks.operationBlocks.Operation;
import com.upc.EasyProduction.panelManagement.Workflow;


public class Block extends JLabel{
	
	protected String name;
	protected String defaultCode;
	protected String code;
	protected String identation = "";
	
	protected JFrame frame;
	protected JPanel panel;
	
	protected MouseListener mouseListener;
	
	protected final int WIDTH = 180;
	protected final int HEIGHT = 40;
	
	protected int wfPos;
	
	protected Workflow wf;
	
	//protected String className = "";

		
	
	public Block() {
		
		wf = Workflow.getInstance();
				
		mouseListener = new MouseListener();
		//blockLabel = new JLabel();
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 400);
		frame.setVisible(false);
		
		
		this.addMouseListener(mouseListener);
		this.addMouseMotionListener(mouseListener);
		
		this.setOpaque(true);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setSize(new Dimension(WIDTH, HEIGHT));
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.setBackground(Color.LIGHT_GRAY);
		
		//this.setFont(new Font("Khmer OS", Font.BOLD, 12));
		
		
		wfPos = -1; // not in workflow

	}
	
	
	public String getCode() {
		return generateCode();
	}
	
	public String getDefaultCode() {
		return defaultCode;
	}
	
	public String generateCode() {
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
	
	public String getIdentation() {
		return identation;
	}
	
	public void setIdentation(String identation) {
		this.identation = identation;
	}
	
	public BlockData getBlockData() { // EYE!!!!
		
		return null;
		
	}
	
	public String getClassName() {
		return this.getClass().getName();
	}
	
	// inner classes
	
	protected class MouseListener extends MouseAdapter {
		
		
		public void mouseClicked(MouseEvent e) {
			
			//if (!(e.getSource() instanceof )) {
			
			Block b = (Block) e.getSource();
				
			b.getFrame().setVisible(true);
			//}

		}
		
		public void mouseDragged(MouseEvent e) {
			
			if (e.getSource() instanceof Operation) {
				
				wf.deleteBlock(((Block)e.getSource()).getWorkflowPosition());
			}
	        			
		}
	}
}
