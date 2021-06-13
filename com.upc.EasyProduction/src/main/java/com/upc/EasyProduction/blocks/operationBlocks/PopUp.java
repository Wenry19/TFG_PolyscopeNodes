package com.upc.EasyProduction.blocks.operationBlocks;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.upc.EasyProduction.blocks.BlockData;
import com.upc.EasyProduction.blocks.dataBlocks.PopUpData;
import com.upc.EasyProduction.panelManagement.Workflow;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardInputCallback;
import com.ur.urcap.api.domain.userinteraction.keyboard.KeyboardTextInput;


public class PopUp extends Operation implements ActionListener{
	
	private JLabel titleLabel = new JLabel("Title");
	private JLabel messageLabel = new JLabel("Message");
	
	private JTextField titleField = new JTextField();
	private JTextField messageField = new JTextField();
	
	private JRadioButton messageButton = new JRadioButton("Message");
	private JRadioButton warningButton = new JRadioButton("Warning");
	private JRadioButton errorButton = new JRadioButton("Error");
	private JRadioButton blockingButton = new JRadioButton("Blocking");
	
	private String title = "";
	private String message = "";
	
	private boolean isMessage = true;
	private boolean isWarning = false;
	private boolean isError = false;
	private boolean isBlocking = false;
	
	private boolean controlUpdateDataModel = true;
	
	
	public PopUp() {
				
		defaultCode = "popup(\"Demo message\")";
		
		name = "PopUp"; // can be whatever
				
		this.setText(name);
		
		// param panel
		
		titleField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KeyboardTextInput keyboardInput = Workflow.getInstance().getUserInteraction().getKeyboardInputFactory().createStringKeyboardInput().setInitialValue(title);
				keyboardInput.show(titleField, new KeyboardInputCallback<String>() {
					
					@Override
					public void onOk(String value) {
						
						title = value;
						titleField.setText(value);
						
						if (controlUpdateDataModel) {
							Workflow.getInstance().updateDataModel(new int[] {wfPos});
						}
						
					}
				});
			}
		});
		
		titleField.setPreferredSize(new Dimension(300, titleField.getPreferredSize().height));
		
		messageField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				KeyboardTextInput keyboardInput = Workflow.getInstance().getUserInteraction().getKeyboardInputFactory().createStringKeyboardInput().setInitialValue(message);
				keyboardInput.show(messageField, new KeyboardInputCallback<String>() {
					
					@Override
					public void onOk(String value) {
						
						message = value;
						messageField.setText(value);
						
						if (controlUpdateDataModel) {
							Workflow.getInstance().updateDataModel(new int[] {wfPos});
						}
						
					}
				});
			}
		});
		
		messageField.setPreferredSize(new Dimension(300, messageField.getPreferredSize().height));
		
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.ipadx = 5;
		c.ipady = 5;
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 0;
		c.gridy = 0;
		
		panel.add(titleLabel, c);
		
		c.gridheight = 1;
		c.gridwidth = 4;
		
		c.gridx = 1;
		c.gridy = 0;
		
		panel.add(titleField, c);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 0;
		c.gridy = 1;
		
		panel.add(messageLabel, c);
		
		
		c.gridheight = 1;
		c.gridwidth = 4;
		
		c.gridx = 1;
		c.gridy = 1;
		
		panel.add(messageField, c);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(messageButton);
		buttonGroup.add(warningButton);
		buttonGroup.add(errorButton);
		
		messageButton.addActionListener(this);
		warningButton.addActionListener(this);
		errorButton.addActionListener(this);
		blockingButton.addActionListener(this);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 1;
		c.gridy = 2;
		
		messageButton.setSelected(true);
		
		panel.add(messageButton, c);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 2;
		c.gridy = 2;
		
		panel.add(warningButton, c);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 3;
		c.gridy = 2;
		
		panel.add(errorButton, c);
		
		c.gridheight = 1;
		c.gridwidth = 1;
		
		c.gridx = 0;
		c.gridy = 3;
		
		
		panel.add(blockingButton, c);
		
	}
	
	@Override
	public String generateCode() {
		
		String auxIsWarning = String.valueOf(isWarning).substring(0, 1).toUpperCase() + String.valueOf(isWarning).substring(1);
		String auxIsError = String.valueOf(isError).substring(0, 1).toUpperCase() + String.valueOf(isError).substring(1);
		String auxIsBlocking = String.valueOf(isBlocking).substring(0, 1).toUpperCase() + String.valueOf(isBlocking).substring(1);
		
		code = "popup(" + "\"" + message + "\"" + ", title=" + "\"" + title + "\"" + ", warning=" + auxIsWarning +
				", error=" + auxIsError + ", blocking=" + auxIsBlocking + ")\n";
		
		return "\n" + indentation + code;
	}
	
	@Override
	public BlockData getBlockData() {
		return new PopUpData(getClassName(), isSelected, indentation, title, message, isMessage, isWarning, isError, isBlocking);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JRadioButton source = (JRadioButton) e.getSource();
		if (source != blockingButton) {
			isMessage = (source == messageButton);
			isWarning = (source == warningButton);
			isError = (source == errorButton);
		}
		else {
		isBlocking = !isBlocking;
		}
		
		if (controlUpdateDataModel) {
			Workflow.getInstance().updateDataModel(new int[] {wfPos});
		}
	}
	
	@Override
	public void setPanel() {
		
		controlUpdateDataModel = false; // per evitar que faci update de la datamodel al fer setValue...
		
		messageButton.setSelected(isMessage); // diria que no fan action event però per si de cas
		warningButton.setSelected(isWarning);
		errorButton.setSelected(isError);
		blockingButton.setSelected(isBlocking);
		
		titleField.setText(title);
		messageField.setText(message);

		controlUpdateDataModel = true;
	}
	
	// setters
	
	public void setMessage(String message) {
		this.message = message;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setIsMessage(boolean isMessage) {
		this.isMessage = isMessage;
	}
	public void setIsWarning(boolean isWarning) {
		this.isWarning = isWarning;
	}
	public void setIsError(boolean isError) {
		this.isError = isError;
	}
	public void setIsBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}
	
}
