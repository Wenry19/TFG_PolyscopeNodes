package com.upc.EasyProduction.blocks;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;

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
		
		this.setLayout(new GridLayout(0, 1));
		
		this.setLocation(0, 0);
		
		this.setVisible(true);
		
		
		for(int i = 0; i < workflow.size(); i++) {
			this.add(workflow.get(i));
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
	
	
	public JScrollPane getScrollPanel() {
		
		return scroll;
	}
}
