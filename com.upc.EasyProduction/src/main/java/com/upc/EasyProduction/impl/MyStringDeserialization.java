package com.upc.EasyProduction.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.BasicBlockData;
import com.upc.EasyProduction.blocks.dataBlocks.DefPutFuncsData;
import com.upc.EasyProduction.blocks.dataBlocks.GetReadyToPutData;
import com.upc.EasyProduction.blocks.dataBlocks.EmptyOperationData;
import com.upc.EasyProduction.blocks.dataBlocks.PopUpData;
import com.upc.EasyProduction.blocks.dataBlocks.SetAnalogOutputData;
import com.upc.EasyProduction.blocks.dataBlocks.SetDigitalOutputData;
import com.upc.EasyProduction.blocks.dataBlocks.SleepData;
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
		else if(type.contains("SleepData")) {
			return getSleepData(data);
		}
		else if(type.contains("PopUpData")) {
			return getPopUpData(data);
		}
		else if(type.contains("SetDigitalOutputData")) {
			return getSetDigitalOutputData(data);
		}
		else if(type.contains("SetAnalogOutputData")) {
			return getSetAnalogOutputData(data);
		}
		else {
			return null;
		}
	}
	
	public String getVal(String attributeName, String data) {
		
		Pattern pattern = Pattern.compile("\"" + attributeName + "\":\"?([^,}{\"]*)");
		
		Matcher matcher = pattern.matcher(data);
		
		if (matcher.find()) {
			
			//System.out.println("DATA " + data);
			//System.out.println(attributeName + " " + matcher.group(1));
			
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
		return new EmptyOperationData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data));
	}
	
	private BlockData getThreadData(String data) {
		return new ThreadData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), Boolean.parseBoolean(getVal("activateExperimentTimer", data)));
	}
	
	private BlockData getSleepData(String data) {
		return new SleepData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data), Integer.parseInt(getVal("duration", data)));
	}
	
	private BlockData getPopUpData(String data) {
		return new PopUpData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)),
				getVal("indentation", data), getVal("title", data), getVal("message", data), Boolean.parseBoolean(getVal("isMessage", data)),
				Boolean.parseBoolean(getVal("isWarning", data)), Boolean.parseBoolean(getVal("isError", data)),
				Boolean.parseBoolean(getVal("isBlocking", data)));
	}
	
	private BlockData getSetDigitalOutputData(String data) {
		return new SetDigitalOutputData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data), getVal("out", data), getVal("value", data));
	}
	
	private BlockData getSetAnalogOutputData(String data) {
		return new SetAnalogOutputData(getVal("className", data), Boolean.parseBoolean(getVal("isSelected", data)), getVal("indentation", data), getVal("out", data), getVal("value", data));
	}
}
