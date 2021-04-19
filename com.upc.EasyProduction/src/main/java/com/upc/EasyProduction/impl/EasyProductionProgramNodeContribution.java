package com.upc.EasyProduction.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;

import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;

import org.apache.commons.lang.SerializationUtils;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.panelManagement.Workflow;

public class EasyProductionProgramNodeContribution implements ProgramNodeContribution{
	
	final private ProgramAPIProvider apiProvider;
	final private EasyProductionProgramNodeView view;
	final private DataModel model;
	// we want to store values of duration and output in our data model
	// data model is what we use to keep track of the settings of this particular node
	// however when working with program nodes is also important to keep track of UndoRedo
	private final UndoRedoManager undoRedoManager;
	
	private static final String WORKFLOW_KEY = "workflow"; // keys that register the changes
	
	private static final int[] DEFAULT_WORKFLOW = new int[0]; // default values for each key
	

	private Workflow wf;
	
	
	public EasyProductionProgramNodeContribution(ProgramAPIProvider apiProvider, EasyProductionProgramNodeView view, DataModel model) {
		this.apiProvider = apiProvider;
		this.view = view;
		this.model = model;
		this.undoRedoManager = this.apiProvider.getProgramAPI().getUndoRedoManager();
		
		this.wf = view.getWorkflowInstance(); // only one wf instance for all contribution nodes
	}
	
	public void onChangeInWF() {
		undoRedoManager.recordChanges(new UndoableChanges() {
			
			@Override
			public void executeChanges() { // record changes in data model
				try {
					byte[] wfData = SerializationUtils.serialize(wf.getWorkflowDataToSerialize());
					// java.io.NotSerializableException: java.awt.Component$AccessibleAWTComponent$AccessibleAWTComponentHandler
					int[] wfDataInt = new int[wfData.length];
					
					for (int i = 0; i < wfData.length; i++) {
						wfDataInt[i] = (int) wfData[i];
					}
					
					//System.out.println(wfData.length);
					
					model.set(WORKFLOW_KEY, wfDataInt);
				}
				catch (Exception e) {
					System.out.println("ENRIC: onChangeInWF " + e.getMessage());
					System.out.println("ENRIC: onChangeInWF " + e.getCause());
				}
			}
		});
	}

	@Override
	public void openView() {
		
		try {
			int[] wfDataInt = model.get(WORKFLOW_KEY, DEFAULT_WORKFLOW);
			byte[] wfDataByte = new byte[wfDataInt.length];
			
			for (int i = 0; i < wfDataInt.length; i++) {
				wfDataByte[i] = (byte) wfDataInt[i];
			}
			
			BlockData[] wfData = (BlockData[]) SerializationUtils.deserialize(wfDataByte);
			
			wf.setWorkflowData(wfData);
		}
		catch (Exception e) {
			System.out.println("ENRIC: openView " + e.getMessage());
			System.out.println("ENRIC: openView " + e.getCause());
		}
		
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
