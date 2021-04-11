package com.upc.EasyProduction.workflow;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.DefPutBase;
import com.upc.EasyProduction.blocks.DefPutBearing;
import com.upc.EasyProduction.blocks.DefPutProduct;
import com.upc.EasyProduction.blocks.DespalletizeProduct;
import com.upc.EasyProduction.blocks.DestackBase;
import com.upc.EasyProduction.blocks.DestackBearing;
import com.upc.EasyProduction.blocks.GetCAPs;
import com.upc.EasyProduction.blocks.InitializeVars;
import com.upc.EasyProduction.blocks.PutBase;
import com.upc.EasyProduction.blocks.PutBearing;
import com.upc.EasyProduction.blocks.PutProduct;
import com.upc.EasyProduction.blocks.WhileTrue;
import com.upc.EasyProduction.blocks.conditionals.Conditional;
import com.upc.EasyProduction.blocks.operations.GetAnalogInput;
import com.upc.EasyProduction.blocks.operations.GetDigitalOutput;
import com.upc.EasyProduction.blocks.operations.PopUp;
import com.upc.EasyProduction.blocks.operations.SetAnalogOutput;
import com.upc.EasyProduction.blocks.operations.SetDigitalOutput;
import com.upc.EasyProduction.blocks.operations.Sleep;
import com.upc.EasyProduction.blocks.threads.ExperimentTimeThread;
import com.upc.EasyProduction.blocks.threads.TimerThread;
import com.upc.EasyProduction.blocks.threads.WriteRegistersThread;

public class Workflow extends JPanel {
	
	LinkedList<Block> workflow = new LinkedList<Block>();
	
	private JScrollPane scroll;
	
	
	private InitializeVars initialize = InitializeVars.getInstance();
	private TimerThread timerThread = TimerThread.getInstance();
	private WriteRegistersThread writeRegistersThread = WriteRegistersThread.getInstance();
	private ExperimentTimeThread experimentTimeThread = ExperimentTimeThread.getInstance();
	
	private DefPutProduct defPutProduct = DefPutProduct.getInstance();
	private DefPutBearing defPutBearing = DefPutBearing.getInstance();
	private DefPutBase defPutBase = DefPutBase.getInstance();

	private WhileTrue whileTrue = WhileTrue.getInstance();
	private DestackBase destackBase = DestackBase.getInstance();
	private PutBase putBase = PutBase.getInstance();
	private DestackBearing destackBearing = DestackBearing.getInstance();
	private PutBearing putBearing = PutBearing.getInstance();
	private GetCAPs getCAPs = GetCAPs.getInstance();
	private DespalletizeProduct despalletizeProduct = DespalletizeProduct.getInstance();
	private PutProduct putProduct = PutProduct.getInstance();
		
	// Singleton (only one instance)
	
	private static Workflow singleton = new Workflow();
	
	
	private Workflow() {
		
		// default workflow
		
		this.iniDefaultWorkflow();
		this.updatePanel();
		
		scroll = new JScrollPane(this);
		scroll.setPreferredSize(new Dimension(200, 404));
		scroll.setSize(new Dimension(200, 404));
		
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
		
		workflow.add(defPutProduct);
		workflow.add(defPutBase);
		workflow.add(defPutBearing);
		
		workflow.add(whileTrue);
		workflow.add(new Conditional("WhileBases<4"));
		workflow.add(destackBase);
		workflow.add(putBase);
		workflow.add(new Conditional("EndWhile"));
		workflow.add(new Conditional("WhileBearings<4"));
		workflow.add(destackBearing);
		workflow.add(putBearing);
		workflow.add(new Conditional("EndWhile"));
		workflow.add(getCAPs);
		workflow.add(new Conditional("WhileProducts<4"));
		workflow.add(despalletizeProduct);
		workflow.add(putProduct);
		workflow.add(new Conditional("EndWhile"));
		workflow.add(new Conditional("EndWhileTrue", new Color(0xaeaebf)));
		
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
		
		Rectangle rect = this.scroll.getViewport().getViewRect();
		
		updateBlocksPositions();
		
		updatePanel();
		
		scroll.getViewport().scrollRectToVisible(rect);
		
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
		
		Rectangle rect = this.scroll.getViewport().getViewRect();
		updatePanel();
		updateBlocksPositions();
		scroll.getViewport().scrollRectToVisible(rect);
		
	}
	
	
	public JScrollPane getScrollPanel() {
		
		return scroll;
	}
}
