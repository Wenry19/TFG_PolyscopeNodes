package com.upc.EasyProduction.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;

import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.upc.EasyProduction.blocks.BlockData;
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
	
	private static final String[] DEFAULT_WORKFLOW = Workflow.getInstance().getDEFAULT_WORKFLOWdata(); // default values for each key
	
	
	private static final String TYPES_KEY = "types";
	
	private static final String[] DEFAULT_TYPES = Workflow.getInstance().getDEFAULT_TYPESdata();
	
//	private final RuntimeTypeAdapterFactory<BlockData> BlockDataAdapterFactory = RuntimeTypeAdapterFactory.of(BlockData.class, "type")
//		    .registerSubtype(CallFuncsData.class, "CallFuncsData")
//		    .registerSubtype(DefPutFuncsData.class, "DefPutFuncsData")
//		    .registerSubtype(FlowInstructionsData.class, "FlowInstructionsData")
//		    .registerSubtype(GetReadyToPutData.class, "GetReadyToPutData")
//		    .registerSubtype(HumanWorkData.class, "HumanWorkData")
//		    .registerSubtype(InitializeData.class, "InitializeData")
//		    .registerSubtype(OperationData.class, "OperationData")
//		    .registerSubtype(ThreadData.class, "ThreadData");
	
//	private final Gson gson = new GsonBuilder().registerTypeAdapterFactory(BlockDataAdapterFactory).setPrettyPrinting().create();
	
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	
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
				
				BlockData[] blockDataArray = wf.getWorkflowData();
				
				String[] blockDataStringArray = new String[blockDataArray.length];
				String[] typesDataStringArray = new String[blockDataArray.length];
				
				for (int i = 0; i < blockDataArray.length; i++) {
					
					blockDataStringArray[i] = gson.toJson(blockDataArray[i]);
					typesDataStringArray[i] = blockDataArray[i].getClass().getName();
					
				}
				
				model.set(WORKFLOW_KEY, blockDataStringArray);
				model.set(TYPES_KEY, typesDataStringArray);
				
				System.out.println("ON CHANGE ________________________________");
				
				String[] aux = model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW);
				
				for (int i = 0; i < aux.length; i++) {
					System.out.println(aux[i]);
				}
				
				System.out.println("END ON CHANGE ________________________________");
				
			}
		});
	}

	@Override
	public void openView() {
		
		String[] blockDataStringArray = model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW);
		String[] typesDataStringArray = model.get(TYPES_KEY, DEFAULT_TYPES);
		
		BlockData[] blockDataArray = new BlockData[blockDataStringArray.length];
				
		for (int i = 0; i < blockDataStringArray.length; i++) {
			
			try {
				
				blockDataArray[i] = (BlockData) gson.fromJson(blockDataStringArray[i], Class.forName(typesDataStringArray[i]));
				
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
		}
		
		wf.setWorkflowData(blockDataArray);
		
		System.out.println("OPEN VIEW ________________________________");
		
		String[] aux = model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW);
		
		for (int i = 0; i < aux.length; i++) {
			System.out.println(aux[i]);
		}
		
		System.out.println("END OPEN VIEW ________________________________");
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
