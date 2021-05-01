package com.upc.EasyProduction.auxMain;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.CallFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.DefPutFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.FlowInstructionsData;
import com.upc.EasyProduction.blocks.dataBlocks.GetReadyToPutData;
import com.upc.EasyProduction.blocks.dataBlocks.HumanWorkData;
import com.upc.EasyProduction.blocks.dataBlocks.InitializeData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;

public class Main {
	
	
	public static void main(String[] args) {
		
//		RuntimeTypeAdapterFactory<BlockData> BlockDataAdapterFactory = RuntimeTypeAdapterFactory.of(BlockData.class, "type")
//			    .registerSubtype(CallFuncsData.class, "CallFuncsData")
//			    .registerSubtype(DefPutFuncsData.class, "DefPutFuncsData")
//			    .registerSubtype(FlowInstructionsData.class, "FlowInstructionsData")
//			    .registerSubtype(GetReadyToPutData.class, "GetReadyToPutData")
//			    .registerSubtype(HumanWorkData.class, "HumanWorkData")
//			    .registerSubtype(InitializeData.class, "InitializeData")
//			    .registerSubtype(OperationData.class, "OperationData")
//			    .registerSubtype(ThreadData.class, "ThreadData");
//		
//		Gson gson = new GsonBuilder().registerTypeAdapterFactory(BlockDataAdapterFactory).setPrettyPrinting().create();
//		
//		BlockData[] array = new BlockData[3];
//		
//		CallFuncsData callfuncdata = new CallFuncsData("hola", false);
//		DefPutFuncsData deffuncdata = new DefPutFuncsData("quetal", false, 3, 3);
//		FlowInstructionsData flowinstr = new FlowInstructionsData("adeu", true);
//		
//		array[0] = callfuncdata;
//		array[1] = deffuncdata;
//		array[2] = flowinstr;
//		
//		System.out.println(gson.toJson(array));
		
	}
	
//	public static void main(String[] args) {
//		
//		Workflow wf = Workflow.getInstance();
//		
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		
//		String jsonStr = gson.toJson(wf.getWorkflowData()); // BlockData[]
//		
//		System.out.print(jsonStr); // :)
//		
//		BlockData[] wf_data = gson.fromJson(jsonStr, BlockData[].class);
//		
//		System.out.println(wf_data[2].getBlockInstance());
//		
//	}

//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		
//		//MainPanel mainPanel = new MainPanel();
//		
//		frame.setLayout(null);
//		frame.setPreferredSize(new Dimension(606, 407));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//frame.add(mainPanel);
//		frame.pack();
//		frame.setVisible(true);
//
//	}
	
//	public static void main(String[] args) {
//		
//		Workflow wf = new Workflow();
//		DefPutBase ini = new DefPutBase(wf);
//		DefPutBase ini2 = new DefPutBase(wf);
//		
//		//InitializeData iniData = new InitializeData("hola");
//		
//		BlockData[] hola = new BlockData[2];
//		
//		hola[0] = ini.getDataToSerialize();
//		hola[1] = ini2.getDataToSerialize();
//		
//		try {
//			byte[] wfData = SerializationUtils.serialize(hola);
//			int[] wfDataInt = new int[wfData.length];
//			
//			for (int i = 0; i < wfData.length; i++) {
//				
//				wfDataInt[i] = (int)wfData[i];
//				
//			}
//			
//			// ---- tornem a castejar a byte
//			
//			byte[] wfDataByte = new byte[wfDataInt.length];
//			
//			for (int i = 0; i < wfDataInt.length; i++) {
//				
//				wfDataByte[i] = (byte)wfDataInt[i];
//				
//			}
//			
//			BlockData[] iniData = (BlockData[]) SerializationUtils.deserialize(wfDataByte);
//			System.out.println(iniData[0].getBlockInstance(wf).getName());
//			System.out.println(((DefPutBase)iniData[1].getBlockInstance(wf)).getVelocity());
//		}
//		catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}

}
