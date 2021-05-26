package com.upc.EasyProduction.blocks;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.upc.EasyProduction.blocks.operationBlocks.Operation;
import com.upc.EasyProduction.panelManagement.MainPanel;
import com.upc.EasyProduction.panelManagement.Workflow;


public class Block extends JLabel{
	
	protected String name;
	protected String defaultCode;
	protected String code;
	protected String identation = "";
	
	protected String blockDataString; // ull!!
	protected String blockDataTypeString; // ull!!
	protected final Gson gson = new GsonBuilder().create(); // ull!!

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
	
	public String getBlockDataString() {
		return blockDataString;
	}
	
	public String getBlockDataTypeString() {
		return blockDataTypeString;
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
	
	public void setBlockDataString(String dataBlockString) {
		this.blockDataString = dataBlockString;
	}
	
	
	// select/unselect block management
	
	protected void selectBlock() {
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		isSelected = true;
	}
	
	protected void unselectBlock() {
		this.setBorder(BorderFactory.createLineBorder(Color.gray));
		isSelected = false;
		
		// cas especial!!! ULL!!
		updateBlockData(); // IMP <-----------------
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
	
	// methods
	
	protected void updateBlockData() {} // ull!!
	
	public void setPanel() {}
	
	// inner classes
	
	protected class MouseListener extends MouseAdapter {
		
		
		public void mouseClicked(MouseEvent e) { // select block
						
			Block b = (Block) e.getSource();
				
			Workflow.getInstance().setSelectedBlock(b);
			
			updateBlockData(); // sempre abans de fer updateDataModel!!
				
			Workflow.getInstance().updateDataModel();
			
		}
		
		public void mouseDragged(MouseEvent e) { // delete block
			
			if (e.getSource() instanceof Operation) {
				
				Workflow wf = Workflow.getInstance();
				
				wf.deleteBlock(((Block)e.getSource()).getWorkflowPosition());
				
			}
	        			
		}
	}
}
