package com.upc.EasyProduction.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;

import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.CallFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.DefPutFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.FlowInstructionsData;
import com.upc.EasyProduction.blocks.dataBlocks.GetReadyToPutData;
import com.upc.EasyProduction.blocks.dataBlocks.HumanWorkData;
import com.upc.EasyProduction.blocks.dataBlocks.InitializeData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class EasyProductionProgramNodeContribution implements ProgramNodeContribution{
	
	private Workflow wf;
	
	final private ProgramAPIProvider apiProvider;
	final private EasyProductionProgramNodeView view;
	final private DataModel model;
	// we want to store values of duration and output in our data model
	// data model is what we use to keep track of the settings of this particular node
	// however when working with program nodes is also important to keep track of UndoRedo
	private final UndoRedoManager undoRedoManager;
	
	private static final String WORKFLOW_KEY = "workflow"; // keys that register the changes
	
	private static final String DEFAULT_WORKFLOW = Workflow.getInstance().getDEFAULT_WORKFLOWdata(); // default values for each key
	
	
	
	private final RuntimeTypeAdapterFactory<BlockData> BlockDataAdapterFactory = RuntimeTypeAdapterFactory.of(BlockData.class, "type")
		    .registerSubtype(CallFuncsData.class, "CallFuncsData")
		    .registerSubtype(DefPutFuncsData.class, "DefPutFuncsData")
		    .registerSubtype(FlowInstructionsData.class, "FlowInstructionsData")
		    .registerSubtype(GetReadyToPutData.class, "GetReadyToPutData")
		    .registerSubtype(HumanWorkData.class, "HumanWorkData")
		    .registerSubtype(InitializeData.class, "InitializeData")
		    .registerSubtype(OperationData.class, "OperationData")
		    .registerSubtype(ThreadData.class, "ThreadData");
	
	private final Gson gson = new GsonBuilder().registerTypeAdapterFactory(BlockDataAdapterFactory).setPrettyPrinting().create();
	
	
	public EasyProductionProgramNodeContribution(ProgramAPIProvider apiProvider, EasyProductionProgramNodeView view, DataModel model) {
		this.apiProvider = apiProvider;
		this.view = view;
		this.model = model;
		this.undoRedoManager = this.apiProvider.getProgramAPI().getUndoRedoManager();
		
		this.wf = Workflow.getInstance();
	}
	
	public void onChangeInWF() {
		undoRedoManager.recordChanges(new UndoableChanges() {
			
			@Override
			public void executeChanges() { // record changes in data model
								
				String jsonStr = gson.toJson(wf.getWorkflowData());
				
				model.set(WORKFLOW_KEY, jsonStr);
				
				System.out.println("ON CHANGE ________________________________");
				
				System.out.println(model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW));
				
				System.out.println("END ON CHANGE ________________________________");
				
			}
		});
	}

	@Override
	public void openView() {
						
		BlockData[] wfData = gson.fromJson(model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW), BlockData[].class);
		
		wf.setWorkflowData(wfData);
		
		System.out.println("OPEN VIEW ________________________________");
		
		System.out.println(model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW));
		
		System.out.println("END OPEN VIEW ________________________________");
		
		//actualitzar els panels de cada bloc!! <------------ IMPORTANT!!
	}

	@Override
	public void closeView() {
		// in this case nothing (no threads or similar dynamic processes created)
		
	}

	@Override
	public String getTitle() {
		return "EasyProduction"; // name in the program tree
	}

	@Override
	public boolean isDefined() { // eye!!
		// since we have the DEFAULT VALUES!!
		// node able to execute
		return true;
	}

	@Override
	public void generateScript(ScriptWriter writer) {
		
		writer.appendRaw(wf.generateCode());
		
	}

}
