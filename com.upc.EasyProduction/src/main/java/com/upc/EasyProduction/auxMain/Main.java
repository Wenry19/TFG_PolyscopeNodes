package com.upc.EasyProduction.auxMain;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import com.upc.EasyProduction.panelManagement.MainPanel;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		MainPanel mainPanel = MainPanel.getInstance();
		
		frame.setLayout(null);
		frame.setPreferredSize(new Dimension(606, 407));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainPanel);
		frame.pack();
		frame.setVisible(true);

	}

}
