package com.upc.EasyProduction.blocks;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Workflow extends JPanel {
	
	LinkedList<Block> workflow = new LinkedList<Block>();
	
	private JScrollPane scroll;
	
	
	private Initialize initialize = Initialize.getInstance();
	private TimerThread timerThread = TimerThread.getInstance();
	private WriteRegistersThread writeRegistersThread = WriteRegistersThread.getInstance();
	private ExperimentTimeThread experimentTimeThread = ExperimentTimeThread.getInstance();
	
	private PutProduct putProduct = PutProduct.getInstance();
	private PutBearing putBearing = PutBearing.getInstance();
	private PutBase putBase = PutBase.getInstance();

	private While whileBlock = While.getInstance();
	private DestackBase destackBase = DestackBase.getInstance();
	private DestackBearing destackBearing = DestackBearing.getInstance();
	private GetCAPs getCAPs = GetCAPs.getInstance();
	private DespalletizeProduct despalletizeProduct = DespalletizeProduct.getInstance();
		
	// Singleton (only one instance)
	
	private static Workflow singleton = new Workflow();
	
	
	private Workflow() {
		
		// default workflow
		
		this.iniDefaultWorkflow();
		this.updatePanel();
		
		scroll = new JScrollPane(this);
		scroll.setPreferredSize(new Dimension(200, 407));
		scroll.setSize(new Dimension(200, 407));
		
	}
	
	public static Workflow getInstance() {
		return singleton;
	}
	
	// End Singleton

	private void iniDefaultWorkflow() {
		
		workflow.add(initialize);
		workflow.add(timerThread);
		workflow.add(writeRegistersThread);
		workflow.add(experimentTimeThread);
		
		workflow.add(putProduct);
		workflow.add(putBase);
		workflow.add(putBearing);
		
		workflow.add(whileBlock);
		workflow.add(destackBase);
		workflow.add(destackBearing);
		workflow.add(getCAPs);
		workflow.add(despalletizeProduct);
		
		updateBlocksPositions();
		
	}
	
	private void updatePanel() {
		
		this.removeAll();
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridheight = 1;
		c.gridwidth = 0;
		
		this.setLocation(0, 0);
		
		this.setVisible(true);
		
		
		for(int i = 0; i < workflow.size(); i++) {
			
			this.add(workflow.get(i), c);
			
			if (i != workflow.size()-1) {
				JLabel arrow = new JLabel();
				// ULL!!!!
				ImageIcon icon = new ImageIcon("/home/enric/eclipse-workspace/TFG_PolyscopeNodes/com.upc.EasyProduction/arrow_down32.png");
				
				arrow.setPreferredSize(new Dimension(24, 12));
				arrow.setSize(new Dimension(24, 12));
				arrow.setIcon(icon);
				
				this.add(arrow, c);
			}
		}
		
		this.revalidate();
		this.repaint();
		
	}
	
	private void updateBlocksPositions() {
		for(int i = 0; i < workflow.size(); i++) {
			workflow.get(i).setWorkflowPosition(i);
		}
	}
	
	public void addBlock(String id, int position) {
		
		Block block = findBlock(id);
		
		workflow.add(position+1, block);
		
		updateBlocksPositions();
		
		updatePanel();
		
		
	}
	
	private Block findBlock(String id) {
				
		if (id == "GetAnalogInput") {
			return new GetAnalogInput();
		}
		
		else if (id == "SetAnalogOutput") {
			return new SetAnalogOutput();
		}
		
		else if (id == "GetDigitalInput") {
			return new GetDigitalOutput();
		}
		
		else if (id == "SetDigitalOutput") {
			return new SetDigitalOutput();
		}
		
		else if (id == "Sleep") {
			return new Sleep();
		}
		
		else { // if (id == "PopUp"){}
			return new PopUp();
		}
		
	}
	
	public void deleteBlock(int i) {
		
		workflow.remove(i);
		
		updatePanel();
		updateBlocksPositions();
		
	}
	
	
	public JScrollPane getScrollPanel() {
		
		return scroll;
	}
}
