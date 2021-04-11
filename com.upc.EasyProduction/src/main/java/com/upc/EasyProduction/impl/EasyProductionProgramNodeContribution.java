package com.upc.EasyProduction.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.program.ProgramAPIProvider;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.domain.undoredo.UndoRedoManager;
import com.ur.urcap.api.domain.undoredo.UndoableChanges;
import com.upc.EasyProduction.blocks.*;
import com.upc.EasyProduction.blocks.threads.ExperimentTimeThread;
import com.upc.EasyProduction.blocks.threads.TimerThread;
import com.upc.EasyProduction.blocks.threads.WriteRegistersThread;

public class EasyProductionProgramNodeContribution implements ProgramNodeContribution{
	
	final private ProgramAPIProvider apiProvider;
	final private EasyProductionProgramNodeView view;
	final private DataModel model;
	// we want to store values of duration and output in our data model
	// data model is what we use to keep track of the settings of this particular node
	// however when working with program nodes is also important to keep track of UndoRedo
	private final UndoRedoManager undoRedoManager;
	
	private static final String N_BASES_KEY = "nbases"; // keys that register the changes
	
	private static final Float DEFAULT_N_BASES = 4.0f; // default values for each key
	

	private InitializeVars initialize = InitializeVars.getInstance();
	private TimerThread timerThread = TimerThread.getInstance();
	private DefPutProduct putProduct = DefPutProduct.getInstance();
	private DefPutBearing putBearing = DefPutBearing.getInstance();
	private DefPutBase putBase = DefPutBase.getInstance();
	private WriteRegistersThread writeRegistersThread = WriteRegistersThread.getInstance();
	private ExperimentTimeThread experimentTimeThread = ExperimentTimeThread.getInstance();
	private WhileTrue whileBlock = WhileTrue.getInstance();
	private DestackBase destackBase = DestackBase.getInstance();
	private DestackBearing destackBearing = DestackBearing.getInstance();
	private GetCAPs getCAPs = GetCAPs.getInstance();
	private DespalletizeProduct despalletizeProduct = DespalletizeProduct.getInstance();
	
	
	public EasyProductionProgramNodeContribution(ProgramAPIProvider apiProvider, EasyProductionProgramNodeView view, DataModel model) {
		this.apiProvider = apiProvider;
		this.view = view;
		this.model = model;
		this.undoRedoManager = this.apiProvider.getProgramAPI().getUndoRedoManager();
	}
	
	public void onNbasesSelection(final Float nbases) {
		undoRedoManager.recordChanges(new UndoableChanges() {
			
			@Override
			public void executeChanges() { // record changes in data model
				model.set(N_BASES_KEY, nbases); // ?? be able to do undoredo ??
				
				//initialize.setNumberIniBases(nbases);
				
				putBase.setVbases(nbases);
				
				
			}
		});
	}
	
	private Float getNbases() {
		// if output value not configured returns default output, but if we set a new output value, then returns this last one
		// eye!!
		return model.get(N_BASES_KEY, DEFAULT_N_BASES);
	}
	
	private Float[] getNbasesItems() { // items in comboBox
		Float [] items = {0.1f, 1.5f, 4.0f};
		
		return items;
	}

	@Override
	public void openView() {
		view.setIOComboBoxItems(getNbasesItems());
		// openView with the correct values of ini Nbases
		view.setIOComboBoxSelection(getNbases());
		
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
		
		
		writer.appendRaw(initialize.getDefaultCode());
		
		writer.appendRaw(timerThread.getDefaultCode());
		
		writer.appendRaw(writeRegistersThread.getDefaultCode());
		
		writer.appendRaw(experimentTimeThread.getDefaultCode());
		
		writer.appendRaw(putProduct.getDefaultCode());
		
		writer.appendRaw(putBearing.getDefaultCode());
		
		writer.appendRaw(putBase.getCode());
		
		writer.appendRaw(whileBlock.getDefaultCode());
		
		writer.appendRaw(destackBase.getDefaultCode());
		
		writer.appendRaw(destackBearing.getDefaultCode());
		
		writer.appendRaw(getCAPs.getDefaultCode());
		
		writer.appendRaw(despalletizeProduct.getDefaultCode());
		
	}

}
