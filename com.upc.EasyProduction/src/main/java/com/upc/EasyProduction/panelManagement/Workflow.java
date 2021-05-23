package com.upc.EasyProduction.panelManagement;



import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import com.ur.urcap.api.contribution.ContributionProvider;

public class Workflow extends JPanel {
	
	LinkedList<Block> workflow = new LinkedList<Block>();
	
	private ContributionProvider<EasyProductionProgramNodeContribution> provider;
	
	private JScrollPane scroll;
	
	private String[] default_workflowData;
	private String[] default_typesData;
	
	private Block currentSelectedBlock = null;
	
	private boolean sim = true; // sim or real exec
	
	// singleton
	
	private static Workflow singleton = new Workflow();
	
	private Workflow() {
				
		// default workflow
		
		this.iniDefaultWorkflow();
		this.generateDEFAULTdata();
		
		scroll = new JScrollPane(this);
		scroll.setPreferredSize(new Dimension(200, 404));
		scroll.setSize(new Dimension(200, 404));
		
	}
	
	public static Workflow getInstance() {
		return singleton;
	}
	
	// end singleton
	
	public void setProvider(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		this.provider = provider;
	}

	public void iniDefaultWorkflow() {
		
		workflow.clear();
		
		workflow.add(new InitializeVars());
		workflow.add(new TimerThread());
		workflow.add(new WriteRegistersThread());
		workflow.add(new ExperimentTimeThread());
		
		workflow.add(new DefPutBase());
		workflow.add(new DefPutBearing());
		workflow.add(new DefPutProduct());
		
		workflow.add(new WhileTrue());
		
		workflow.add(new IfBases());
		workflow.add(new DestackBase());
		workflow.add(new CallPutBase());
		workflow.add(new EndIfBases());
		
		workflow.add(new IfBearings());
		workflow.add(new DestackBearing());
		workflow.add(new CallPutBearing());
		workflow.add(new EndIfBearings());
		
		workflow.add(new IfCAPSandProducts());
		
		workflow.add(new GetCAPs());
		
		workflow.add(new WhileProducts());
		workflow.add(new DespalletizeProduct());
		workflow.add(new CallPutProduct());
		workflow.add(new EndWhileProducts());
		
		workflow.add(new EndIfCAPSandProducts());
		
		workflow.add(new EndWhileTrue());
		
		updateBlocksPositions();
		
		updatePanel();
		
		//updateDataModel(-1); // ull!!
	}
	
	private void generateDEFAULTdata() {
		
		Gson gson = new GsonBuilder().create();
		
		BlockData[] blockDataArray = this.getWorkflowData();
		
		default_workflowData = new String[blockDataArray.length];
		default_typesData= new String[blockDataArray.length];
		
		for (int i = 0; i < blockDataArray.length; i++) {
			
			default_workflowData[i] = gson.toJson(blockDataArray[i]);
			default_typesData[i] = blockDataArray[i].getClass().getName();
			
		}
	}
	
	public String[] getDEFAULT_WORKFLOWdata() {
		return default_workflowData;
	}
	
	public String[] getDEFAULT_TYPESdata() {
		return default_typesData;
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
				
				// ULL!!!
				
				try {
					JLabel arrow = new JLabel();
					
					BufferedImage image = ImageIO.read(this.getClass().getResource("/arrow_down32.png"));
					ImageIcon icon = new ImageIcon(image);
					
					arrow.setPreferredSize(new Dimension(24, 12));
					arrow.setSize(new Dimension(24, 12));
					arrow.setIcon(icon);
					
					this.add(arrow, c);
				}
				catch(Exception e) {
					System.out.println(e.toString());
				}
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
		
		updateDataModel(position+1);
		
	}
	
	private Block findBlock(String id) {
				
		if (id == "GetAnalogInput") {
			return new GetAnalogInput();
		}
		
		else if (id == "SetAnalogOutput") {
			return new SetAnalogOutput();
		}
		
		else if (id == "GetDigitalInput") {
			return new GetDigitalInput();
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
		
		updateDataModel(i);
		
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
	
	public void setWorkflowList(LinkedList<Block> workflow) {
		
		this.workflow.clear();
		this.workflow = workflow;
		
		updatePanel();
		updateBlocksPositions();
		updateDataModel(-1);
		
	}
	
	public LinkedList<Block> getWorkflowList() {
		return workflow;
	}
	
	public void updateDataModel(int wfPos) {

		try {
			provider.get().onChangeInWF(wfPos);
		}
		catch (Exception e) {
			
		}
		finally {}
	}
	
	public BlockData[] getWorkflowData(){
		
		BlockData[] wfData = new BlockData[workflow.size()];
		
		for (int i = 0; i < workflow.size(); i++) {
			
			wfData[i] = workflow.get(i).getBlockData();
			
		}
		
		return wfData;
		
	}
	
	public void setWorkflowData(BlockData[] DataArray) {
		
		Rectangle rect = this.scroll.getViewport().getViewRect();
		
		workflow.clear(); // clear current workflow
		
		currentSelectedBlock = null;
				
		for (int i = 0; i < DataArray.length; i++) {
			
			
			Block aux = DataArray[i].getBlockInstance();
			
			
			if (aux.getIsSelected()) {
				setSelectedBlock(aux);
			}
			
			workflow.add(aux);
			
		}
		
		if (currentSelectedBlock == null) {
			MainPanel.getInstance().clearParamPanel();
		}
		
		updatePanel();
		updateBlocksPositions();
		
		scroll.getViewport().scrollRectToVisible(rect);
		
	}
	
	public void setSelectedBlock(Block b) {
		if (currentSelectedBlock != null) {
			currentSelectedBlock.setIsSelected(false);
		}
		currentSelectedBlock = b;
		currentSelectedBlock.setIsSelected(true);
	}
	
	public void setSim(boolean sim) {
		this.sim = sim;
	}
	
	public boolean getSim() {
		return sim;
	}
	
	public String getSimOrNot() {
		if (sim) {
			return "#";
		}
		else {
			return "";
		}
	}
	
	public BlockData getWorkflowData(int wfPos) {
		return workflow.get(wfPos).getBlockData();
	}
	
	public int getLen() {
		return workflow.size();
	}
}
