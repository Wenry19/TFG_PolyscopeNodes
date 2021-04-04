package com.upc.EasyProduction.blocks;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class Workflow extends JPanel {
	
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
	
	//private JPanel panel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane(this);
	
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
		
		this.setLayout(new GridLayout(0, 1));
		
		this.setLocation(0, 0);
		
		this.setVisible(true);
		
		
		for(int i = 0; i < workflow.size(); i++) {
			this.add(workflow.get(i).getBlockLabel());
		}
		
	}
	
	public JPanel getPanel() {
		return this;
	}
}
