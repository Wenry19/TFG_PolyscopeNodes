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
		
		panel.setBackground(Color.blue); // provisional
		
		panel.setPreferredSize(new Dimension(200, 407));
		
		
		JLabel label = new JLabel("hola");
		label.setPreferredSize(new Dimension(200, 50));
		label.setBackground(Color.red);
		label.setOpaque(true);
		
		JLabel label1 = new JLabel("hola1");
		label1.setPreferredSize(new Dimension(200, 50));
		label1.setBackground(Color.red);
		label1.setOpaque(true);
		
		JLabel label2 = new JLabel("hola2");
		label2.setPreferredSize(new Dimension(200, 50));
		label2.setBackground(Color.red);
		label2.setOpaque(true);
		
		JLabel label3 = new JLabel("hola3");
		label3.setPreferredSize(new Dimension(200, 50));
		label3.setBackground(Color.red);
		label3.setOpaque(true);
		
		JLabel label4 = new JLabel("hola4");
		label4.setPreferredSize(new Dimension(200, 50));
		label4.setBackground(Color.red);
		label4.setOpaque(true);
		
		JLabel label5 = new JLabel("hola5");
		label5.setPreferredSize(new Dimension(200, 50));
		label5.setBackground(Color.red);
		label5.setOpaque(true);
		
		JLabel label6 = new JLabel("hola6");
		label6.setPreferredSize(new Dimension(200, 50));
		label6.setBackground(Color.red);
		label6.setOpaque(true);
		
		JLabel label7 = new JLabel("hola7");
		label7.setPreferredSize(new Dimension(200, 50));
		label7.setBackground(Color.red);
		label7.setOpaque(true);
		
		JLabel label8 = new JLabel("hola8");
		label8.setPreferredSize(new Dimension(200, 50));
		label8.setBackground(Color.red);
		label8.setOpaque(true);
		
		
		panel.add(label);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		
		
	}
	
	public JScrollPane getPanel() {
		return scrollPane;
	}
}
