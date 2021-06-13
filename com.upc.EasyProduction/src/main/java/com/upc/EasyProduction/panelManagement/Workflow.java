package com.upc.EasyProduction.panelManagement;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.upc.EasyProduction.blocks.Block;
import com.upc.EasyProduction.blocks.BlockData;
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
import com.upc.EasyProduction.blocks.productionBlocks.getReadyToPut.GoToReadyWayPoint;
import com.upc.EasyProduction.blocks.productionBlocks.humanWork.GetCAPs;
import com.upc.EasyProduction.blocks.productionBlocks.ini.InitializeVars;
import com.upc.EasyProduction.blocks.productionBlocks.threads.ExperimentTimeThread;
import com.upc.EasyProduction.blocks.productionBlocks.threads.TimerThread;
import com.upc.EasyProduction.blocks.productionBlocks.threads.WriteRegistersThread;
import com.upc.EasyProduction.impl.EasyProductionProgramNodeContribution;

import com.ur.urcap.api.contribution.ContributionProvider;
import com.ur.urcap.api.domain.SystemAPI;
import com.ur.urcap.api.domain.userinteraction.UserInteraction;

public class Workflow extends JPanel {
	
	LinkedList<Block> workflow = new LinkedList<Block>();
	
	private ContributionProvider<EasyProductionProgramNodeContribution> provider;
	private SystemAPI sysAPI;
	private UserInteraction userInteraction;
	
	private JScrollPane scroll;
	
	private String[] default_workflowData;
	private String[] default_typesData;
	
	private Block currentSelectedBlock = null;
		
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
	
	// setters
	
	public void setProvider(ContributionProvider<EasyProductionProgramNodeContribution> provider) {
		this.provider = provider;
	}
	
	public void setSystemAPI(SystemAPI sysAPI) {
		this.sysAPI = sysAPI;
	}
	
	public void setUserInteraction(UserInteraction userInteraction){
		this.userInteraction = userInteraction;
	}
	
	// generate default data for data model!!
	
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
	
	// simulation or real robot management
	
	public boolean getSim() {
		return !sysAPI.getRobotSimulation().isRealRobot();
	}
	
	public String getSimOrNot() {
						
		if (!sysAPI.getRobotSimulation().isRealRobot()) {
			return "#";
		}
		else {
			return "";
		}
	}
	
	
	// some getters
	
	public UserInteraction getUserInteraction() {
		return userInteraction;
	}
	
	public int getLen() {
		return workflow.size();
	}
	
	public int getCurrentSelectedBlockPos() {
		if (currentSelectedBlock != null) {
			return currentSelectedBlock.getWorkflowPosition();
		}
		return -1; // no selected position
	}
	
	// set selected block
	
	public void setSelectedBlock(Block b) {
		if (currentSelectedBlock != null) {
			currentSelectedBlock.setIsSelected(false);
		}
		currentSelectedBlock = b;
		currentSelectedBlock.setIsSelected(true);
	}
	
	
	// ADD BLOCK
	public void addBlock(String id, int position) {
		
		if (position == workflow.size() - 1) return;
		
		Block block = findBlock(id);
		
		block.setIndentation(workflow.get(position).getIndentation());
		
		workflow.add(position+1, block);
		
		Rectangle rect = this.scroll.getViewport().getViewRect();
		
		
		updatePanel();
		
		scroll.getViewport().scrollRectToVisible(rect);
		
		updateDataModel(new int[] {position+1});
		
	}
	
	// DELETE BLOCK
	public void deleteBlock(int i) {
		
		if (workflow.get(i) == currentSelectedBlock) {
			MainPanel.getInstance().clearParamPanel();
			currentSelectedBlock = null;
		}
		
		workflow.remove(i);
		
		Rectangle rect = this.scroll.getViewport().getViewRect();
		
		updatePanel();
				
		scroll.getViewport().scrollRectToVisible(rect);
		
		updateDataModel(new int[] {i});
		
	}
	
	// ________________________________________________________________
	
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
		workflow.add(new GoToReadyWayPoint());
		
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
				
		updatePanel();		
	}
	
	private void updatePanel() {
		
		this.removeAll();
				
		this.setLayout(new GridLayout(0, 1, 0, 5));
		
		this.setLocation(0, 0);
		
		this.setVisible(true);
		
		
		for(int i = 0; i < workflow.size(); i++) {
			
			Block aux = workflow.get(i);
			
			aux.setWorkflowPosition(i);
			
			this.add(aux);
			
			
			/*if (i != workflow.size()-1) {
								
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
			}*/
		}
		
		this.revalidate();
		this.repaint();
		
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
	
	
	public void updateDataModel(int[] wfPositions) {

		try {
			provider.get().onChangeInWF(wfPositions);
		}
		catch (Exception e) {
			
		}
	}
	
	public BlockData[] getWorkflowData(){
		
		BlockData[] wfData = new BlockData[workflow.size()];
		
		for (int i = 0; i < workflow.size(); i++) {
			
			wfData[i] = workflow.get(i).getBlockData();
			
		}
		
		return wfData;
		
	}
	
	public BlockData getWorkflowDataBlock(int wfPos) {
		return workflow.get(wfPos).getBlockData();
	}
	
	public void setWorkflowData(BlockData[] DataArray) {
		
		// also does update panel in the same loop
		
		Rectangle rect = this.scroll.getViewport().getViewRect();
		
		this.removeAll();
		
		this.setLayout(new GridLayout(0, 1, 0, 5));
		
		this.setLocation(0, 0);
		
		this.setVisible(true);
		
		
		workflow.clear(); // clear current workflow
		
		currentSelectedBlock = null;
				
		for (int i = 0; i < DataArray.length; i++) {
			
			
			Block aux = DataArray[i].getBlockInstance();
			
			if (aux.getIsSelected()) {
				setSelectedBlock(aux);
			}
			
			workflow.add(aux);
			
			aux.setWorkflowPosition(i);
			
			this.add(aux);
			
		}
		
		if (currentSelectedBlock == null) {
			MainPanel.getInstance().clearParamPanel();
		}
		
		//updatePanel();
		
		this.revalidate();
		this.repaint();
		
		scroll.getViewport().scrollRectToVisible(rect);
		
		// es crida des de data model, per tant no s'ha de fer update de la data model!!
		
	}
	
	
	private Block findBlock(String id) {
		
		if (id.equals("SetAnalogOutput")) {
			return new SetAnalogOutput();
		}
		
		else if (id.equals("SetDigitalOutput")) {
			return new SetDigitalOutput();
		}
		
		else if (id.equals("Sleep")) {
			return new Sleep();
		}
		
		else { // if (id.equals("PopUp"))
			return new PopUp();
		}
	}
}
