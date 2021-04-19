package com.upc.EasyProduction.auxMain;

import java.awt.Dimension;

import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import org.apache.commons.lang.SerializationUtils;

import com.upc.EasyProduction.blocks.productionBlocks.ini.InitializeVars;
import com.upc.EasyProduction.panelManagement.MainPanel;
import com.upc.EasyProduction.panelManagement.Workflow;

public class Main {

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
	
	public static void main(String[] args) {
		
		Workflow wf = new Workflow();
		InitializeVars ini = new InitializeVars(wf);
		
		//InitializeData iniData = new InitializeData("hola");
		
		try {
			//byte[] wfData = SerializationUtils.serialize(ini.getDataToSerialize());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
