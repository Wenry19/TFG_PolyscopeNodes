package com.upc.EasyProduction.blocks;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.upc.EasyProduction.blocks.operationBlocks.Operation;
import com.upc.EasyProduction.panelManagement.MainPanel;
import com.upc.EasyProduction.panelManagement.Workflow;


public class Block extends JLabel{
	
	protected String name;
	protected String defaultCode;
	protected String code;
	protected String identation = "";

	protected JPanel panel = new JPanel();
	protected JScrollPane scroll = new JScrollPane(panel);
	
	protected MouseListener mouseListener = new MouseListener();
	
	protected final int WIDTH = 180;
	protected final int HEIGHT = 40;
	
	protected int wfPos = -1;
	
	protected Boolean isSelected = false;
		
	
	public Block() {

		scroll.setBounds(0, 0, 406, 150);		
		
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
		
		setOpaque(true);
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setSize(new Dimension(WIDTH, HEIGHT));
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		setBackground(Color.LIGHT_GRAY);
				
	}
	
	
	// getters
	
	public String getName() {
		return name;
	}
	
	public String getDefaultCode() {
		return defaultCode;
	}
	
	public String generateCode() {
		code = "";
		
		return code;
	}
	
	public String getCode() {
		return generateCode();
	}
	
	public String getIdentation() {
		return identation;
	}
	
	public int getWorkflowPosition() {
		return wfPos;
	}
	
	public BlockData getBlockData() { // EYE!!!!
		return null;
	}
	
	public String getClassName() {
		return this.getClass().getName();
	}
	
	public Boolean getIsSelected() {
		return isSelected;
	}
	
	
	// setters
	
	public void setWorkflowPosition(int pos) {
		wfPos = pos;
	}
	

	public void setIdentation(String identation) {
		this.identation = identation;
	}
	
	
	public void setPanel() {}
	
	
	// select/unselect block management
	
	protected void selectBlock() {
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		isSelected = true;
	}
	
	protected void unselectBlock() {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		isSelected = false;
	}
	
	public void setIsSelected(Boolean isSelected) {
		
		this.isSelected = isSelected;
		
		if (isSelected) {
			
			MainPanel.getInstance().updateParamPanel(scroll);
			selectBlock();
		}
		else {
			unselectBlock();
		}
	}
	
	// inner classes
	
	protected class MouseListener extends MouseAdapter {
		
		
		public void mouseClicked(MouseEvent e) { // select block
						
			Block b = (Block) e.getSource();
			
			// save position of the selected block before the change
			int beforeSelectedBlockPos = Workflow.getInstance().getCurrentSelectedBlockPos();
				
			Workflow.getInstance().setSelectedBlock(b);
			
			Workflow.getInstance().updateDataModel(new int[]{wfPos, beforeSelectedBlockPos});
			
		}
		
		public void mouseDragged(MouseEvent e) { // delete block
			
			if (e.getSource() instanceof Operation) {
				
				Workflow wf = Workflow.getInstance();
				
				wf.deleteBlock(((Block)e.getSource()).getWorkflowPosition());
				
			}
	        			
		}
	}
}
