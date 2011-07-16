package com.manteam.iwant2learn.keywords.client.ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.keywords.client.handler.KeyWordMaintenanceHandler;
import com.manteam.iwant2learn.keywords.exceptions.MaintainKeyWordsException;
import com.manteam.iwant2learn.keywords.vo.KeyWordSaveVO;
import com.manteam.iwant2learn.subject.client.handler.SubjectHandler;
import com.manteam.iwant2learn.subject.exceptions.MaintainSubjectsException;
import com.manteam.iwant2learn.subject.vo.SubmoduleSaveVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;

/**
 * 
 * @author Praveen
 */
public class KeyWordMaintenanceUI extends JFrame {
	private JPanel buttonPanel;
	private JButton chooseKeywordImageButton;
	private JButton closeButton;
	private JTextField descriptionImagePathTextField;
	private JLabel descriptionLabel;
	private JScrollPane descriptionScrollPane;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JTextArea keywordDescriptionTextArea;
	private JLabel keywordImagePathLabel;
	private JLabel keywordNameLabel;
	private JTextField keywordNameTextField;
	private JMenuBar mainMenuBar;
	private JPanel mainPanel;
	private JButton saveButton;
	private JPanel statusPanel;
	private JLabel subjectNameLabel;
	private JPanel subjectPanel;
	private JComboBox subjectsComboBox;
	private JPanel submoduleDetailsPanel;
	private JComboBox submoduleNameComboBox;
	private JLabel submoduleNameLabel;
	private HashMap<String, ArrayList<String>> subjectsnSubmodules;

	/** Creates new form KeyWordInterfaceUI */
	public KeyWordMaintenanceUI() {
		try {
			subjectsnSubmodules = getSubjectsnSubmodules();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
	}

	private HashMap<String, ArrayList<String>> getSubjectsnSubmodules()
			throws SystemException {
		KeyWordMaintenanceHandler keyWordMaintenanceHandler = new KeyWordMaintenanceHandler();

		return keyWordMaintenanceHandler.retrieveAllSubjectsnSubmodules();
	}

	private void initComponents() {
		GridBagConstraints gridBagConstraints;

		mainPanel = new JPanel();
		submoduleDetailsPanel = new JPanel();
		descriptionLabel = new JLabel();
		descriptionScrollPane = new JScrollPane();
		keywordDescriptionTextArea = new JTextArea();
		keywordImagePathLabel = new JLabel();
		descriptionImagePathTextField = new JTextField();
		chooseKeywordImageButton = new JButton();
		keywordNameLabel = new JLabel();
		keywordNameTextField = new JTextField();
		subjectPanel = new JPanel();
		subjectNameLabel = new JLabel();
		subjectsComboBox = new JComboBox();
		submoduleNameLabel = new JLabel();
		submoduleNameComboBox = new JComboBox();
		buttonPanel = new JPanel();
		closeButton = new JButton();
		saveButton = new JButton();
		statusPanel = new JPanel();
		mainMenuBar = new JMenuBar();
		jMenu1 = new JMenu();
		jMenu2 = new JMenu();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridBagLayout());

		mainPanel.setLayout(new GridBagLayout());

		submoduleDetailsPanel.setBorder(BorderFactory
				.createTitledBorder("Submodule Details"));
		submoduleDetailsPanel.setLayout(new GridBagLayout());

		descriptionLabel.setText("Descirption");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new Insets(5, 10, 5, 10);
		submoduleDetailsPanel.add(descriptionLabel, gridBagConstraints);

		keywordDescriptionTextArea.setColumns(20);
		keywordDescriptionTextArea.setRows(5);
		descriptionScrollPane.setViewportView(keywordDescriptionTextArea);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(descriptionScrollPane, gridBagConstraints);

		keywordImagePathLabel.setText("Image File");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		submoduleDetailsPanel.add(keywordImagePathLabel, gridBagConstraints);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(descriptionImagePathTextField,
				gridBagConstraints);

		chooseKeywordImageButton.setText("Browse");
		chooseKeywordImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				chooseKeywordImageButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets(5, 5, 5, 10);
		submoduleDetailsPanel.add(chooseKeywordImageButton, gridBagConstraints);

		keywordNameLabel.setText("KeyWord Name");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(keywordNameLabel, gridBagConstraints);

		keywordNameTextField.setPreferredSize(new Dimension(200, 22));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(keywordNameTextField, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		mainPanel.add(submoduleDetailsPanel, gridBagConstraints);

		subjectPanel.setBorder(BorderFactory
				.createTitledBorder("Subject Details"));
		subjectPanel.setLayout(new GridBagLayout());

		subjectNameLabel.setText("Subject Name");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(10, 10, 5, 5);
		subjectPanel.add(subjectNameLabel, gridBagConstraints);

		DefaultComboBoxModel defaultComboBoxModel = null;
		if (subjectsnSubmodules != null && subjectsnSubmodules.size() > 0) {
			defaultComboBoxModel = new DefaultComboBoxModel(subjectsnSubmodules
					.keySet().toArray());
		} else {
			defaultComboBoxModel = new DefaultComboBoxModel(new String[] {});
		}
		subjectsComboBox.setModel(defaultComboBoxModel);
		subjectsComboBox.setPreferredSize(new Dimension(200, 22));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		subjectPanel.add(subjectsComboBox, gridBagConstraints);

		submoduleNameLabel.setText("SubModule Name");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = new Insets(10, 5, 5, 5);
		subjectPanel.add(submoduleNameLabel, gridBagConstraints);

		submoduleNameComboBox.setMinimumSize(new Dimension(59, 20));
		submoduleNameComboBox.setPreferredSize(new Dimension(200, 22));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = new Insets(10, 5, 5, 10);
		subjectPanel.add(submoduleNameComboBox, gridBagConstraints);

		subjectsComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				submoduleNameComboBox.setModel(new DefaultComboBoxModel(
						subjectsnSubmodules.get(
								subjectsComboBox.getSelectedItem()).toArray()));
			}
		});

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		gridBagConstraints.weightx = 1.0;
		mainPanel.add(subjectPanel, gridBagConstraints);

		buttonPanel.setBorder(BorderFactory.createTitledBorder(""));
		buttonPanel.setLayout(new GridBagLayout());

		closeButton.setText("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				closeButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = new Insets(10, 5, 10, 10);
		buttonPanel.add(closeButton, gridBagConstraints);

		saveButton.setText("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				saveButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new Insets(10, 0, 10, 5);
		buttonPanel.add(saveButton, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints.weightx = 1.0;
		mainPanel.add(buttonPanel, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new Insets(0, 5, 0, 0);
		getContentPane().add(mainPanel, gridBagConstraints);

		statusPanel.setBorder(BorderFactory.createEtchedBorder());
		statusPanel.setLayout(new GridBagLayout());
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.ipadx = 396;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.weightx = 1.0;
		getContentPane().add(statusPanel, gridBagConstraints);

		jMenu1.setText("File");
		mainMenuBar.add(jMenu1);

		jMenu2.setText("Edit");
		mainMenuBar.add(jMenu2);

		setJMenuBar(mainMenuBar);

		pack();
	}// </editor-fold>

	private void chooseKeywordImageButtonActionPerformed(ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: "
					+ chooser.getSelectedFile().getName());
			descriptionImagePathTextField.setText(chooser.getSelectedFile()
					.getAbsolutePath());
		}
	}

	private void closeButtonActionPerformed(ActionEvent evt) {
		dispose();
	}

	private void saveButtonActionPerformed(ActionEvent evt) {
		if (isValidEntry()) {
			KeyWordSaveVO keyWordSaveVO = new KeyWordSaveVO();
			
			keyWordSaveVO.setSubjectName((String) subjectsComboBox
					.getSelectedItem());
			keyWordSaveVO.setSubmoduleName((String) submoduleNameComboBox
					.getSelectedItem());
			keyWordSaveVO.setKeywordName(keywordNameTextField.getText());
			keyWordSaveVO.setKeyWordDescription(keywordDescriptionTextArea.getText());
			
			if (descriptionImagePathTextField.getText() != null
					&& descriptionImagePathTextField.getText().trim().length() > 0) {

				File file = new File(descriptionImagePathTextField.getText());
				if (file.isFile()) {
					keyWordSaveVO
							.setKeywordImageStream(createInputStreamForImage(file));
					keyWordSaveVO.setKeyWordImageLength((int) file.length());
				}
			}

			KeyWordMaintenanceHandler keyWordMaintenanceHandler = new KeyWordMaintenanceHandler();

			int keyWordId = 0;

			LogonAttributesVO logonAttributesVO = new LogonAttributesVO();
			logonAttributesVO.setUserName("App Client");
			logonAttributesVO.setUserRole("App Role");
			try {
				keyWordId = keyWordMaintenanceHandler.saveKeyWord(
						logonAttributesVO, keyWordSaveVO);
			} catch (MaintainKeyWordsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (keyWordId > 0) {
				JOptionPane.showMessageDialog(this,
						"Succesfully added the Keyword with id: " + keyWordId,
						"SUCCESS", JOptionPane.INFORMATION_MESSAGE);
				resetAllFields();
				keywordNameTextField.requestFocus();
			}
		}
	}

	private boolean isValidEntry() {
		if (subjectsComboBox.getSelectedItem() == null
				|| subjectsComboBox.getSelectedItem().toString().length() == 0) {
			JOptionPane.showMessageDialog(this,
					"Please specify the Subject Name", "Inane error",
					JOptionPane.ERROR_MESSAGE);
			subjectsComboBox.requestFocus();
			return false;
		}
		if (submoduleNameComboBox.getSelectedItem() == null
				|| submoduleNameComboBox.getSelectedItem().toString().length() == 0) {
			JOptionPane.showMessageDialog(this,
					"Please specify the Sub Module Name", "Inane error",
					JOptionPane.ERROR_MESSAGE);
			submoduleNameComboBox.requestFocus();
			return false;
		}
		if (keywordNameTextField.getText() == null
				|| keywordNameTextField.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,
					"Please specify the key Word Name", "Inane error",
					JOptionPane.ERROR_MESSAGE);
			keywordNameTextField.requestFocus();
			return false;
		}
		if (keywordDescriptionTextArea.getText() == null
				|| keywordDescriptionTextArea.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,
					"Please specify the key Word description", "Inane error",
					JOptionPane.ERROR_MESSAGE);
			keywordDescriptionTextArea.requestFocus();
			return false;
		}

		if (descriptionImagePathTextField.getText() != null
				&& descriptionImagePathTextField.getText().length() != 0) {
			File file = new File(descriptionImagePathTextField.getText());
			if (!file.isFile()) {
				JOptionPane.showMessageDialog(this,
						"Please specify a valid file for the image",
						"Inane error", JOptionPane.ERROR_MESSAGE);
				descriptionImagePathTextField.requestFocus();
				return false;
			}

		}
		return true;
	}

	private InputStream createInputStreamForImage(File file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fis;
	}

	private void resetAllFields() {
		keywordNameTextField.setText("");
		keywordDescriptionTextArea.setText("");
		descriptionImagePathTextField.setText("");
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new KeyWordMaintenanceUI().setVisible(true);
			}
		});
	}

}
