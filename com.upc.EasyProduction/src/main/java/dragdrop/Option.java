package dragdrop;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Option extends JLabel {

	private String name;
	private final int WIDTH = 200;
	private final int HEIGHT = 50;
	
	Option(String name){
		
		this.name = name;
		
		initializeLabel();
	}

	private void initializeLabel() {
		
		this.setText(name);
		
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setSize(new Dimension(WIDTH, HEIGHT));
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		
		this.setLocation(0, 0);
		
		this.setOpaque(true);
		
	}
	

	
}
