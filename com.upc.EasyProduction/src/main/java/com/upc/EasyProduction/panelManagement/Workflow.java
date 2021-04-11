package com.upc.EasyProduction.panelManagement;


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
import com.upc.EasyProduction.blocks.operationBlocks.GetAnalogInput;
import com.upc.EasyProduction.blocks.operationBlocks.GetDigitalOutput;
import com.upc.EasyProduction.blocks.operationBlocks.PopUp;
import com.upc.EasyProduction.blocks.operationBlocks.SetAnalogOutput;
import com.upc.EasyProduction.blocks.operationBlocks.SetDigitalOutput;
import com.upc.EasyProduction.blocks.operationBlocks.Sleep;
import com.upc.EasyProduction.blocks.productionBlocks.CallPutBase;
import com.upc.EasyProduction.blocks.productionBlocks.CallPutBearing;
import com.upc.EasyProduction.blocks.productionBlocks.CallPutProduct;
import com.upc.EasyProduction.blocks.productionBlocks.DefPutBase;
import com.upc.EasyProduction.blocks.productionBlocks.DefPutBearing;
import com.upc.EasyProduction.blocks.productionBlocks.DefPutProduct;
import com.upc.EasyProduction.blocks.productionBlocks.DespalletizeProduct;
import com.upc.EasyProduction.blocks.productionBlocks.DestackBase;
import com.upc.EasyProduction.blocks.productionBlocks.DestackBearing;
import com.upc.EasyProduction.blocks.productionBlocks.EndIfBases;
import com.upc.EasyProduction.blocks.productionBlocks.EndIfBearings;
import com.upc.EasyProduction.blocks.productionBlocks.EndIfCAPSandProducts;
import com.upc.EasyProduction.blocks.productionBlocks.EndWhileProducts;
import com.upc.EasyProduction.blocks.productionBlocks.EndWhileTrue;
import com.upc.EasyProduction.blocks.productionBlocks.ExperimentTimeThread;
import com.upc.EasyProduction.blocks.productionBlocks.GetCAPs;
import com.upc.EasyProduction.blocks.productionBlocks.InitializeVars;
import com.upc.EasyProduction.blocks.productionBlocks.TimerThread;
import com.upc.EasyProduction.blocks.productionBlocks.IfBases;
import com.upc.EasyProduction.blocks.productionBlocks.IfBearings;
import com.upc.EasyProduction.blocks.productionBlocks.IfCAPSandProducts;
import com.upc.EasyProduction.blocks.productionBlocks.WhileProducts;
import com.upc.EasyProduction.blocks.productionBlocks.WhileTrue;
import com.upc.EasyProduction.blocks.productionBlocks.WriteRegistersThread;

public class Workflow extends JPanel {
	
	LinkedList<Block> workflow = new LinkedList<Block>();
	
	private JScrollPane scroll;
	
	
	private InitializeVars initializeVars = new InitializeVars();
	private TimerThread timerThread = new TimerThread();
	private WriteRegistersThread writeRegistersThread = new WriteRegistersThread();
	private ExperimentTimeThread experimentTimeThread = new ExperimentTimeThread();
	
	private DefPutProduct defPutProduct = new DefPutProduct();
	private DefPutBearing defPutBearing = new DefPutBearing();
	private DefPutBase defPutBase = new DefPutBase();

	private WhileTrue whileTrue = new WhileTrue();
	
	private IfBases whileBases = new IfBases();
	private DestackBase destackBase = new DestackBase();
	private CallPutBase putBase = new CallPutBase();
	private EndIfBases endWhileBases = new EndIfBases();
	
	private IfBearings whileBearings = new IfBearings();
	private DestackBearing destackBearing = new DestackBearing();
	private CallPutBearing putBearing = new CallPutBearing();
	private EndIfBearings endWhileBearings = new EndIfBearings();
	
	private IfCAPSandProducts ifCAPSandProducts = new IfCAPSandProducts();
	private GetCAPs getCAPs = new GetCAPs();
	
	private WhileProducts whileProducts = new WhileProducts();
	private DespalletizeProduct despalletizeProduct = new DespalletizeProduct();
	private CallPutProduct putProduct = new CallPutProduct();
	private EndWhileProducts endWhileProducts = new EndWhileProducts();
	
	private EndIfCAPSandProducts endIfCAPSandProducts = new EndIfCAPSandProducts();
	
	
	private EndWhileTrue endWhileTrue = new EndWhileTrue();
		
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
		
		workflow.add(initializeVars);
		workflow.add(timerThread);
		workflow.add(writeRegistersThread);
		workflow.add(experimentTimeThread);
		
		workflow.add(defPutProduct);
		workflow.add(defPutBase);
		workflow.add(defPutBearing);
		
		workflow.add(whileTrue);
		
		workflow.add(whileBases);
		workflow.add(destackBase);
		workflow.add(putBase);
		workflow.add(endWhileBases);
		
		workflow.add(whileBearings);
		workflow.add(destackBearing);
		workflow.add(putBearing);
		workflow.add(endWhileBearings);
		
		workflow.add(ifCAPSandProducts);
		
		workflow.add(getCAPs);
		
		workflow.add(whileProducts);
		workflow.add(despalletizeProduct);
		workflow.add(putProduct);
		workflow.add(endWhileProducts);
		
		workflow.add(endIfCAPSandProducts);
		
		workflow.add(endWhileTrue);
		
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
		
		if (position == workflow.size() - 1) return;
		
		Block block = findBlock(id);
		
		block.setIdentation(workflow.get(position).getIdentation());
		
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
	
	public String generateCode() {
		
		String code = "";
		
		for (int i = 0; i < workflow.size(); i++) {
			code += workflow.get(i).getDefaultCode();
		}
		
		return code;
	}
	
	public void setWorkflow(LinkedList workflow) {
		
		this.workflow = workflow;
		
		updatePanel();
		
	}
}
