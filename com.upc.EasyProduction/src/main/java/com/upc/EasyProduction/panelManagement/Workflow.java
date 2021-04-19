package com.upc.EasyProduction.panelManagement;



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
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.operationBlocks.GetAnalogInput;
import com.upc.EasyProduction.blocks.operationBlocks.GetDigitalInput;
import com.upc.EasyProduction.blocks.operationBlocks.PopUp;
import com.upc.EasyProduction.blocks.operationBlocks.SetAnalogOutput;
import com.upc.EasyProduction.blocks.operationBlocks.SetDigitalOutput;
import com.upc.EasyProduction.blocks.operationBlocks.Sleep;
import com.upc.EasyProduction.blocks.productionBlocks.callFuncs.CallPutBase;
import com.upc.EasyProduction.blocks.productionBlocks.callFuncs.CallPutBearing;
import com.upc.EasyProduction.blocks.productionBlocks.callFuncs.CallPutProduct;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutBase;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutBearing;
import com.upc.EasyProduction.blocks.productionBlocks.defFuncs.DefPutProduct;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndIfBases;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndIfBearings;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndIfCAPSandProducts;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndWhileProducts;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.EndWhileTrue;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.IfBases;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.IfBearings;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.IfCAPSandProducts;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.WhileProducts;
import com.upc.EasyProduction.blocks.productionBlocks.flowInstructions.WhileTrue;
import com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut.DespalletizeProduct;
import com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut.DestackBase;
import com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut.DestackBearing;
import com.upc.EasyProduction.blocks.productionBlocks.humanWork.GetCAPs;
import com.upc.EasyProduction.blocks.productionBlocks.ini.InitializeVars;
import com.upc.EasyProduction.blocks.productionBlocks.threads.ExperimentTimeThread;
import com.upc.EasyProduction.blocks.productionBlocks.threads.TimerThread;
import com.upc.EasyProduction.blocks.productionBlocks.threads.WriteRegistersThread;
import com.upc.EasyProduction.impl.EasyProductionProgramNodeContribution;
import com.upc.EasyProduction.impl.EasyProductionProgramNodeView;
import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.contribution.ViewAPIProvider;

public class Workflow extends JPanel {
	
	LinkedList<Block> workflow = new LinkedList<Block>();
	
	private ContributionProvider<EasyProductionProgramNodeContribution> provider;
	
	private JScrollPane scroll;
	
	
	private InitializeVars initializeVars = new InitializeVars(this);
	private TimerThread timerThread = new TimerThread(this);
	private WriteRegistersThread writeRegistersThread = new WriteRegistersThread(this);
	private ExperimentTimeThread experimentTimeThread = new ExperimentTimeThread(this);
	
	private DefPutProduct defPutProduct = new DefPutProduct(this);
	private DefPutBearing defPutBearing = new DefPutBearing(this);
	private DefPutBase defPutBase = new DefPutBase(this);

	private WhileTrue whileTrue = new WhileTrue(this);
	
	private IfBases whileBases = new IfBases(this);
	private DestackBase destackBase = new DestackBase(this);
	private CallPutBase putBase = new CallPutBase(this);
	private EndIfBases endWhileBases = new EndIfBases(this);
	
	private IfBearings whileBearings = new IfBearings(this);
	private DestackBearing destackBearing = new DestackBearing(this);
	private CallPutBearing putBearing = new CallPutBearing(this);
	private EndIfBearings endWhileBearings = new EndIfBearings(this);
	
	private IfCAPSandProducts ifCAPSandProducts = new IfCAPSandProducts(this);
	private GetCAPs getCAPs = new GetCAPs(this);
	
	private WhileProducts whileProducts = new WhileProducts(this);
	private DespalletizeProduct despalletizeProduct = new DespalletizeProduct(this);
	private CallPutProduct putProduct = new CallPutProduct(this);
	private EndWhileProducts endWhileProducts = new EndWhileProducts(this);
	
	private EndIfCAPSandProducts endIfCAPSandProducts = new EndIfCAPSandProducts(this);
	
	
	private EndWhileTrue endWhileTrue = new EndWhileTrue(this);
	
	
	public Workflow(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		
		this.provider = provider;
		
		// default workflow
		
		this.iniDefaultWorkflow();
		this.updatePanel();
		
		scroll = new JScrollPane(this);
		scroll.setPreferredSize(new Dimension(200, 404));
		scroll.setSize(new Dimension(200, 404));
		
	}
	
	public Workflow() { // PROVISIONAL!!
				
		// default workflow
		
		this.iniDefaultWorkflow();
		this.updatePanel();
		
		scroll = new JScrollPane(this);
		scroll.setPreferredSize(new Dimension(200, 404));
		scroll.setSize(new Dimension(200, 404));
		
	}
	
//	public void setProvider(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
//		
//		this.provider = provider;
//		
//	}

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
		
		updateDataModel();
		
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
		
		updateDataModel();
		
	}
	
	private Block findBlock(String id) {
				
		if (id == "GetAnalogInput") {
			return new GetAnalogInput(this);
		}
		
		else if (id == "SetAnalogOutput") {
			return new SetAnalogOutput(this);
		}
		
		else if (id == "GetDigitalInput") {
			return new GetDigitalInput(this);
		}
		
		else if (id == "SetDigitalOutput") {
			return new SetDigitalOutput(this);
		}
		
		else if (id == "Sleep") {
			return new Sleep(this);
		}
		
		else { // if (id == "PopUp"){}
			return new PopUp(this);
		}
		
	}
	
	public void deleteBlock(int i) {
		
		workflow.remove(i);
		
		Rectangle rect = this.scroll.getViewport().getViewRect();
		updatePanel();
		updateBlocksPositions();
		scroll.getViewport().scrollRectToVisible(rect);
		
		updateDataModel();
		
	}
	
	
	public JScrollPane getScrollPanel() {
		
		return scroll;
	}
	
	public String generateCode() {
		
		String code = "";
		
		for (int i = 0; i < workflow.size(); i++) {
			code += workflow.get(i).generateCode();
		}
		
		return code;
	}
	
	public void setWorkflowList(LinkedList workflow) {
		
		this.workflow = workflow;
		
		updatePanel();
		updateDataModel();
		
	}
	
	public LinkedList<Block> getWorkflowList() {
		return workflow;
	}
	
	private void updateDataModel() {
		try {
			provider.get().onChangeInWF();
		}
		catch (Exception e) {
			
		}
		finally {}
	}
	
	public BlockData[] getWorkflowDataToSerialize(){
		
		BlockData[] wfData = new BlockData[workflow.size()];
		
		for (int i = 0; i < workflow.size(); i++) {
			
			wfData[i] = workflow.get(i).getDataToSerialize();
			
		}
		
		return wfData;
		
	}
	
	public void setWorkflowData(BlockData[] DataArray) {
		
		workflow.clear(); // clear current workflow
		
		for (int i = 0; i < DataArray.length; i++) {
			
			workflow.add(DataArray[i].getBlockInstance(this));
			
		}
		
		updatePanel();
		updateBlocksPositions();
		
	}
}
