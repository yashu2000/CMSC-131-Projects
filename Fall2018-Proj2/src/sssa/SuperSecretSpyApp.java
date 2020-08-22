package sssa;

import studentCode.*;

public class SuperSecretSpyApp extends javax.swing.JFrame {
	private static final long serialVersionUID = 16080102L;


	// GUI variables declaration - do not modify                     
	private javax.swing.ButtonGroup buttonGroupDirection;
	private javax.swing.ButtonGroup buttonGroupSystem;
	private javax.swing.JButton buttonSafetyCheck;
	private javax.swing.JButton buttonSpyIt;
	private javax.swing.JLabel jLabelCipher;
	private javax.swing.JLabel jLabelPlain;
	private javax.swing.JLabel jLabelShiftKeyword;
	private javax.swing.JRadioButton jRadioButtonBellaso;
	private javax.swing.JRadioButton jRadioButtonCaesar;
	private javax.swing.JRadioButton jRadioButtonDecrypt;
	private javax.swing.JRadioButton jRadioButtonEncrypt;
	private javax.swing.JRadioButton jRadioButtonRot30;
	private javax.swing.JTextField jTextFieldCipher;
	private javax.swing.JTextField jTextFieldPlain;
	private javax.swing.JTextField jTextFieldShiftKeyword;
	// End of GUI variables declaration  




	public SuperSecretSpyApp() {
		initComponents();

		buttonGroupDirection.add(jRadioButtonDecrypt);
		buttonGroupDirection.add(jRadioButtonEncrypt);

		buttonGroupSystem.add(jRadioButtonRot30);
		buttonGroupSystem.add(jRadioButtonCaesar);
		buttonGroupSystem.add(jRadioButtonBellaso);

		jTextFieldPlain.grabFocus();
	}



	private void buttonSafetyCheckActionPerformed(java.awt.event.ActionEvent evt) {                                                  
		if (!CryptoCode.safeToUse(jTextFieldPlain.getText())) {
			MyLibrary.displayError(this, "Message uses characters that will not be encrypted!");
		}

		if (jRadioButtonCaesar.isSelected()) {
			Integer shift = MyLibrary.isInteger(jTextFieldShiftKeyword.getText(),-1);
			if (shift.equals(-1)) {
				MyLibrary.displayError(this, "The shift needs to be an integer!");
			}
			else {
				if (shift < 1  ||  shift>26) {
					MyLibrary.displayError(this, "The shift needs to be an integer between 1 and 26!");
				}
			}
		}

		if (jRadioButtonBellaso.isSelected() 
				&& !CryptoCode.safeToUse(jTextFieldShiftKeyword.getText())) {
			MyLibrary.displayError(this, "The keyword has invalid characters!");
		}

		if (!CryptoCode.safeToUse(jTextFieldCipher.getText())) {
			MyLibrary.displayError(this, "The message you received had some characters that were not encrypted!");
		}
	}  


	private void buttonSpyItActionPerformed(java.awt.event.ActionEvent evt) {
		if (!jRadioButtonEncrypt.isSelected() 
				&& !jRadioButtonDecrypt.isSelected()) {
			MyLibrary.displayError(this, "You need to select a direction!");
		}
		else if (!jRadioButtonRot30.isSelected() 
				&& !jRadioButtonCaesar.isSelected()
				&& !jRadioButtonBellaso.isSelected()) {
			MyLibrary.displayError(this, "You need to select a system!");
		}
		else if (jRadioButtonRot30.isSelected()) {
			if (jRadioButtonEncrypt.isSelected()) {
				jTextFieldCipher.setText(
						CryptoCode.rot30(jTextFieldPlain.getText()));
			}
			else {
				jTextFieldPlain.setText(
						CryptoCode.rot30(jTextFieldCipher.getText()));
			}
		}
		else if (jRadioButtonCaesar.isSelected()) {
			if (MyLibrary.isInteger(jTextFieldShiftKeyword.getText(),-1).equals(-1)) {
				MyLibrary.displayError(this, "Need a numeric shift!");
			}

			int shift = Integer.parseInt(jTextFieldShiftKeyword.getText()); 

			if (jRadioButtonEncrypt.isSelected()) {
				jTextFieldCipher.setText(
						CryptoCode.toCaesar(jTextFieldPlain.getText(), shift)
						);
			}
			else {
				jTextFieldPlain.setText(
						CryptoCode.fromCaesar(jTextFieldCipher.getText(), shift)
						);
			}
		}
		else if (jRadioButtonBellaso.isSelected()) {
			if (jRadioButtonEncrypt.isSelected()) {
				jTextFieldCipher.setText(
						CryptoCode.toBellaso(jTextFieldPlain.getText(), jTextFieldShiftKeyword.getText())
						);
			}
			else {
				jTextFieldPlain.setText(
						CryptoCode.fromBellaso(jTextFieldCipher.getText(), jTextFieldShiftKeyword.getText())
						);
			}
		}


	}                                           

	private void jRadioButtonDirectionStateChanged(javax.swing.event.ChangeEvent evt) {
		if (jRadioButtonEncrypt.isSelected()) {
			jTextFieldPlain.setEnabled(true);
			jTextFieldCipher.setEnabled(false);
		}
		else if (jRadioButtonDecrypt.isSelected()) {
			jTextFieldPlain.setEnabled(false);
			jTextFieldCipher.setEnabled(true);
		}
	}




	private void jRadioButtonSystemStateChanged(javax.swing.event.ChangeEvent evt) {                                               
		if (jRadioButtonRot30.isSelected()) {
			jLabelShiftKeyword.setText("Irrelevant:");
		}
		else if (jRadioButtonCaesar.isSelected()) {
			jLabelShiftKeyword.setText("Shift:");
		}
		else if (jRadioButtonBellaso.isSelected()) {
			jLabelShiftKeyword.setText("Keyword:");
		}


		if (jRadioButtonRot30.isSelected()) {
			jTextFieldShiftKeyword.setEnabled(false);
			jLabelShiftKeyword.setEnabled(false);
		}
		else  {
			jTextFieldShiftKeyword.setEnabled(true);
			jLabelShiftKeyword.setEnabled(true);
		}
	}                                              




	private void jTextFieldPlainFocusGained(java.awt.event.FocusEvent evt) {                                            
		jTextFieldCipher.setText("");
	}                                           

	private void jTextFieldCipherFocusGained(java.awt.event.FocusEvent evt) {                                             
		jTextFieldPlain.setText("");
	}     































	private void initComponents() {

		buttonGroupDirection = new javax.swing.ButtonGroup();
		buttonGroupSystem = new javax.swing.ButtonGroup();
		buttonSpyIt = new javax.swing.JButton();
		jRadioButtonEncrypt = new javax.swing.JRadioButton();
		jRadioButtonDecrypt = new javax.swing.JRadioButton();
		jRadioButtonRot30 = new javax.swing.JRadioButton();
		jRadioButtonCaesar = new javax.swing.JRadioButton();
		jRadioButtonBellaso = new javax.swing.JRadioButton();
		jLabelPlain = new javax.swing.JLabel();
		jLabelShiftKeyword = new javax.swing.JLabel();
		jLabelCipher = new javax.swing.JLabel();
		jTextFieldPlain = new javax.swing.JTextField();
		jTextFieldShiftKeyword = new javax.swing.JTextField();
		jTextFieldCipher = new javax.swing.JTextField();
		buttonSafetyCheck = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Super Secret Spy App");
		setBackground(new java.awt.Color(204, 255, 255));
		setBounds(new java.awt.Rectangle(100, 100, 0, 0));
		setResizable(false);

		buttonSpyIt.setText("Spy it!");
		buttonSpyIt.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSpyItActionPerformed(evt);
			}
		});

		jRadioButtonEncrypt.setText("Encrypt");
		jRadioButtonEncrypt.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jRadioButtonDirectionStateChanged(evt);
			}
		});

		jRadioButtonDecrypt.setText("Decrypt");
		jRadioButtonDecrypt.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jRadioButtonDirectionStateChanged(evt);
			}
		});

		jRadioButtonRot30.setText("Rotate30");
		jRadioButtonRot30.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jRadioButtonSystemStateChanged(evt);
			}
		});

		jRadioButtonCaesar.setText("Caesar");
		jRadioButtonCaesar.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jRadioButtonSystemStateChanged(evt);
			}
		});

		jRadioButtonBellaso.setText("Bellaso");
		jRadioButtonBellaso.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jRadioButtonSystemStateChanged(evt);
			}
		});

		jLabelPlain.setText("Plain Text:");

		jLabelShiftKeyword.setText("Key:");

		jLabelCipher.setText("Cipher Text:");

		java.awt.Color disabledColor = new java.awt.Color(64,64,64);

		jTextFieldPlain.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jTextFieldPlainFocusGained(evt);
			}
		});
		jTextFieldPlain.setDisabledTextColor(disabledColor);


		jTextFieldShiftKeyword.setDisabledTextColor(disabledColor);


		jTextFieldCipher.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jTextFieldCipherFocusGained(evt);
			}
		});
		jTextFieldCipher.setDisabledTextColor(disabledColor);



		buttonSafetyCheck.setText("Safety Check");
		buttonSafetyCheck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSafetyCheckActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(buttonSafetyCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
												.addGap(10, 10, 10)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabelPlain)
														.addComponent(jLabelCipher)
														.addComponent(jLabelShiftKeyword))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jTextFieldShiftKeyword)
																.addComponent(jTextFieldCipher)
																.addComponent(jTextFieldPlain)))
																.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																		.addGap(31, 31, 31)
																		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(jRadioButtonEncrypt)
																				.addComponent(jRadioButtonDecrypt))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(jRadioButtonBellaso)
																						.addComponent(jRadioButtonRot30)
																						.addComponent(jRadioButtonCaesar))
																						.addGap(35, 35, 35))
																						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																								.addContainerGap()
																								.addComponent(buttonSpyIt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																								.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jRadioButtonEncrypt)
								.addComponent(jRadioButtonRot30))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jRadioButtonDecrypt)
										.addComponent(jRadioButtonCaesar))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jRadioButtonBellaso)
										.addGap(40, 40, 40)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabelPlain)
												.addComponent(jTextFieldPlain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabelShiftKeyword)
														.addComponent(jTextFieldShiftKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(jLabelCipher)
																.addComponent(jTextFieldCipher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(buttonSafetyCheck)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
																.addComponent(buttonSpyIt)
																.addContainerGap())
				);

		pack();
	}

}
