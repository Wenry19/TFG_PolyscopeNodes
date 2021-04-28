package com.upc.EasyProduction.blocks;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import com.upc.EasyProduction.panelManagement.MainPanel;
import com.upc.EasyProduction.panelManagement.Workflow;


public class Block extends JLabel{
	
	protected String name;
	protected String defaultCode;
	protected String code;
	protected String identation = "";

	protected JPanel panel = new JPanel();
	
	protected MouseListener mouseListener = new MouseListener();
	
	protected final int WIDTH = 180;
	protected final int HEIGHT = 40;
	
	protected int wfPos = -1;
	
	protected Workflow wf = Workflow.getInstance();
	
	
	public Block() {
				
		//panel.setLayout(new GridLayout(0, 1));
		panel.setBounds(0, 0, 405, 149);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		
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
	
	public void setPanel() {
		return;
	}
	
	private void selectBlock() {
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}
	
	public void unselectBlock() {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
	}
	
	// inner classes
	
	protected class MouseListener extends MouseAdapter {
		
		
		public void mouseClicked(MouseEvent e) {
						
			Block b = (Block) e.getSource();
							
			MainPanel.getInstance().updateParamPanel(panel);
			
			Workflow wf = Workflow.getInstance();
			wf.setSelectedBlock(b);
			selectBlock();
			
		}
		
		public void mouseDragged(MouseEvent e) {
			
			if (e.getSource() instanceof Operation) {
				
				Workflow wf = Workflow.getInstance();
				wf.deleteBlock(((Block)e.getSource()).getWorkflowPosition());
			}
	        			
		}
	}
}
