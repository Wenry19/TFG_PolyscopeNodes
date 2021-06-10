package com.upc.EasyProduction.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;
import com.upc.EasyProduction.blocks.dataBlocks.DefPutFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.GetReadyToPutData;
import com.upc.EasyProduction.blocks.dataBlocks.OperationData;
import com.upc.EasyProduction.blocks.dataBlocks.ThreadData;

public class MyStringDeserialization {

	
	public BlockData deserializeBlockData(String data, String type) {
		
		if(type.contains("BasicBlockData")) {
			return getBasicBlockData(data);
		}
		else if(type.contains("DefPutFuncsData")) {
			return getDefPutFuncsData(data);
		}
		else if(type.contains("GetReadyToPutData")) {
			return getGetReadyToPutDataData(data);
		}
		else if(type.contains("OperationData")) {
			return getOperationData(data);
		}
		else if(type.contains("ThreadData")) {
			return getThreadData(data);
		}
		else {
			return null;
		}
		
	}
	
	private String getVal(String attributeName, String data) {
		
		Pattern pattern = Pattern.compile("\"" + attributeName + "\":\"?([^,}{\"]*)");
		
		Matcher matcher = pattern.matcher(data);
		
		if (matcher.find()) {
			
			System.out.println("DATA " + data);
			System.out.println(attributeName + " " + matcher.group(1));
			
		    return matcher.group(1);
		    
		}
				
		return null;
	}
	
	private BlockData getBasicBlockData(String data) {
		return new BasicBlockData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)));
	}
	
	private BlockData getDefPutFuncsData(String data) {
		return new DefPutFuncsData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), Double.parseDouble(getVal("velocity", data)),
				Double.parseDouble(getVal("acceleration", data)), Integer.parseInt(getVal("velocity_tag", data)), Integer.parseInt(getVal("acceleration_tag", data)));
	}
	
	private BlockData getGetReadyToPutDataData(String data) {
		return new GetReadyToPutData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), Double.parseDouble(getVal("velocity", data)),
				Double.parseDouble(getVal("acceleration", data)), Integer.parseInt(getVal("velocity_tag", data)), Integer.parseInt(getVal("acceleration_tag", data)));
	}
	
	private BlockData getOperationData(String data) {
		return new OperationData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data));
	}
	
	private BlockData getThreadData(String data) {
		return new ThreadData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), Boolean.parseBoolean(getVal("activateExperimentTimer", data)));
	}
	
}
