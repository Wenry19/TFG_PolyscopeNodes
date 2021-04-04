package com.upc.EasyProduction.blocks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class Workflow {
	
	LinkedList<Block> workflow = new LinkedList();
	
	
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
	
	private JPanel panel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane(panel);
	
	// Singleton (only one instance)
	
	private static Workflow singleton = new Workflow();
	
	
	private Workflow() {
		
		// default workflow
		
		this.iniDefaultWorkflow();
		this.iniPanel();
		
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
		
	}
	
	private void iniPanel() {
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		
		//panel.setBackground(Color.blue); // provisional
		
		panel.setPreferredSize(new Dimension(200, 407));
		panel.setSize(new Dimension(200, 407));
		panel.setLocation(0, 0);
		
		panel.setVisible(true);
		
		
		for(int i = 0; i < workflow.size(); i++) {
			panel.add(workflow.get(i).getBlockLabel());
		}
		
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
