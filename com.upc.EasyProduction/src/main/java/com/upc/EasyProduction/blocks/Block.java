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
import javax.swing.JScrollPane;

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
	protected JScrollPane scroll = new JScrollPane(panel);
	
	protected MouseListener mouseListener = new MouseListener();
	
	protected final int WIDTH = 180;
	protected final int HEIGHT = 40;
	
	protected int wfPos = -1;
	
	protected Boolean isSelected = false;
	
	//protected Workflow wf = Workflow.getInstance(); // dona problemes... diu que es null wtf
	
	
	public Block() {

		scroll.setBounds(0, 0, 406, 150);		
		
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
			Workflow.getInstance().setSelectedBlock(this);
			selectBlock();
		}
		else {
			unselectBlock();
		}
	}
	
	public Boolean getIsSelected() {
		return isSelected;
	}
	
	// inner classes
	
	protected class MouseListener extends MouseAdapter {
		
		
		public void mouseClicked(MouseEvent e) {
						
			Block b = (Block) e.getSource();
			
			b.setIsSelected(true);
			
			Workflow.getInstance().updateDataModel(); // important!! acostumar-me a fer updates de datamodel als listeners
			
		}
		
		public void mouseDragged(MouseEvent e) {
			
			if (e.getSource() instanceof Operation) {
				
				Workflow wf = Workflow.getInstance();
				
				wf.deleteBlock(((Block)e.getSource()).getWorkflowPosition());
				
			}
	        			
		}
	}
}
