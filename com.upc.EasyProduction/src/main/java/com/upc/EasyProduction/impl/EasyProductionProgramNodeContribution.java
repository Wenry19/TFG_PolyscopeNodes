package com.upc.EasyProduction.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;
import com.upc.EasyProduction.blocks.*;
import com.upc.EasyProduction.blocks.productionBlocks.DefPutBase;
import com.upc.EasyProduction.blocks.productionBlocks.DefPutBearing;
import com.upc.EasyProduction.blocks.productionBlocks.DefPutProduct;
import com.upc.EasyProduction.blocks.productionBlocks.DespalletizeProduct;
import com.upc.EasyProduction.blocks.productionBlocks.DestackBase;
import com.upc.EasyProduction.blocks.productionBlocks.DestackBearing;
import com.upc.EasyProduction.blocks.productionBlocks.ExperimentTimeThread;
import com.upc.EasyProduction.blocks.productionBlocks.GetCAPs;
import com.upc.EasyProduction.blocks.productionBlocks.InitializeVars;
import com.upc.EasyProduction.blocks.productionBlocks.TimerThread;
import com.upc.EasyProduction.blocks.productionBlocks.WhileTrue;
import com.upc.EasyProduction.blocks.productionBlocks.WriteRegistersThread;
import com.upc.EasyProduction.panelManagement.Workflow;

public class EasyProductionProgramNodeContribution implements ProgramNodeContribution{
	
	final private ProgramAPIProvider apiProvider;
	final private EasyProductionProgramNodeView view;
	final private DataModel model;
	// we want to store values of duration and output in our data model
	// data model is what we use to keep track of the settings of this particular node
	// however when working with program nodes is also important to keep track of UndoRedo
	private final UndoRedoManager undoRedoManager;
	

	private Workflow wf = Workflow.getInstance();
	
	
	public EasyProductionProgramNodeContribution(ProgramAPIProvider apiProvider, EasyProductionProgramNodeView view, DataModel model) {
		this.apiProvider = apiProvider;
		this.view = view;
		this.model = model;
		this.undoRedoManager = this.apiProvider.getProgramAPI().getUndoRedoManager();
	}

	@Override
	public void openView() {
		
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
