/**
 * 
 */
package com.manteam.iwant2learn.subject.client.ui;

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
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
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
import com.manteam.iwant2learn.subject.client.handler.SubjectHandler;
import com.manteam.iwant2learn.subject.exceptions.MaintainSubjectsException;
import com.manteam.iwant2learn.subject.vo.ModuleVO;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.subject.vo.SubmoduleSaveVO;
import com.sun.crypto.provider.DESCipher;

/**
 * 
 * @author Praveen
 */
public class SubModuleInterfaceUI extends JFrame {

	private JPanel buttonPanel;
	private JButton chooseQuestionImageButton;
	private JButton closeButton;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuBar mainMenuBar;
	private JPanel mainPanel;
	private JLabel moduleNameLabel;
	private JTextField moduleNameTextField;
	private JLabel questionImageLabel;
	private JTextField descriptionImagePathTextField;
	private JLabel descriptionLabel;
	private JScrollPane descriptionScrollPane;
	private JTextArea descriptionTextArea;
	private JButton saveButton;
	private JPanel statusPanel;
	private JLabel subjectNameLabel;
	private JPanel subjectPanel;
	private JComboBox subjectsComboBox;
	private JPanel submoduleDetailsPanel;
	private JLabel submoduleNameLabel;
	private JTextField submoduleNameTextField;
	private String[] subjects;

	/** Creates new form SubModuleInterfaceUI */
	public SubModuleInterfaceUI() {
		subjects = getAllSubjects();
		initComponents();
	}

	private String[] getAllSubjects() {
		SubjectHandler subjectHandler = new SubjectHandler();
		Collection<String> returnsubjects = null;
		String[] subjectsToReturn = null;
		try {
			returnsubjects = subjectHandler.retrieveAllSubjects();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (returnsubjects != null && returnsubjects.size() > 0) {
			subjectsToReturn = new String[returnsubjects.size()];
			int i = 0;
			for (String subject : returnsubjects) {
				subjectsToReturn[i++] = subject;
			}
		}
		return subjectsToReturn;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		GridBagConstraints gridBagConstraints;

		mainPanel = new JPanel();
		submoduleDetailsPanel = new JPanel();
		descriptionLabel = new JLabel();
		descriptionScrollPane = new JScrollPane();
		descriptionTextArea = new JTextArea();
		questionImageLabel = new JLabel();
		descriptionImagePathTextField = new JTextField();
		chooseQuestionImageButton = new JButton();
		moduleNameLabel = new JLabel();
		moduleNameTextField = new JTextField();
		submoduleNameLabel = new JLabel();
		submoduleNameTextField = new JTextField();
		subjectPanel = new JPanel();
		subjectNameLabel = new JLabel();
		subjectsComboBox = new JComboBox();
		buttonPanel = new JPanel();
		closeButton = new JButton();
		saveButton = new JButton();
		statusPanel = new JPanel();
		mainMenuBar = new JMenuBar();
		jMenu1 = new JMenu();
		jMenu2 = new JMenu();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		mainPanel.setLayout(new GridBagLayout());

		submoduleDetailsPanel.setBorder(BorderFactory
				.createTitledBorder("Submodule Details"));
		submoduleDetailsPanel.setLayout(new GridBagLayout());

		descriptionLabel.setText("Descirption");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
		gridBagConstraints.insets = new Insets(5, 10, 5, 10);
		submoduleDetailsPanel.add(descriptionLabel, gridBagConstraints);

		descriptionTextArea.setColumns(20);
		descriptionTextArea.setRows(5);
		descriptionScrollPane.setViewportView(descriptionTextArea);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(descriptionScrollPane, gridBagConstraints);

		questionImageLabel.setText("Image File");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		submoduleDetailsPanel.add(questionImageLabel, gridBagConstraints);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(descriptionImagePathTextField,
				gridBagConstraints);

		descriptionImagePathTextField.setEditable(false);
		chooseQuestionImageButton.setText("Browse");
		chooseQuestionImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				chooseQuestionImageButtonActionPerformed(evt);
			}
		});
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets(5, 5, 5, 10);
		submoduleDetailsPanel
				.add(chooseQuestionImageButton, gridBagConstraints);

		moduleNameLabel.setText("Module Name");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(moduleNameLabel, gridBagConstraints);

		moduleNameTextField.setPreferredSize(new Dimension(200, 22));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(moduleNameTextField, gridBagConstraints);

		submoduleNameLabel.setText("Submodule Name");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(submoduleNameLabel, gridBagConstraints);

		submoduleNameTextField.setPreferredSize(new Dimension(200, 22));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		submoduleDetailsPanel.add(submoduleNameTextField, gridBagConstraints);

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

		subjectsComboBox.setModel(new DefaultComboBoxModel(subjects));
		subjectsComboBox.setPreferredSize(new Dimension(200, 22));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);
		subjectPanel.add(subjectsComboBox, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
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

		statusPanel.setBorder(BorderFactory.createEtchedBorder());

		GroupLayout statusPanelLayout = new GroupLayout(statusPanel);
		statusPanel.setLayout(statusPanelLayout);
		statusPanelLayout.setHorizontalGroup(statusPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						812, Short.MAX_VALUE));
		statusPanelLayout.setVerticalGroup(statusPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						15, Short.MAX_VALUE));

		jMenu1.setText("File");
		mainMenuBar.add(jMenu1);

		jMenu2.setText("Edit");
		mainMenuBar.add(jMenu2);

		setJMenuBar(mainMenuBar);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 816, Short.MAX_VALUE)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup()
										.addGap(5, 5, 5)
										.addComponent(mainPanel,
												GroupLayout.DEFAULT_SIZE, 799,
												Short.MAX_VALUE)
										.addContainerGap()))
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addComponent(
								statusPanel, GroupLayout.Alignment.TRAILING,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 366, Short.MAX_VALUE)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup()
										.addComponent(mainPanel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(25, Short.MAX_VALUE)))
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addGroup(
								GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup()
										.addContainerGap(347, Short.MAX_VALUE)
										.addComponent(statusPanel,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))));

		pack();
	}// </editor-fold>

	private void chooseQuestionImageButtonActionPerformed(ActionEvent evt) {
		JFileChooser chooser = new JFileChooser();
		// Note: source for ExampleFileFilter can be found in FileChooserDemo,
		// under the demo/jfc directory in the Java 2 SDK, Standard Edition.
		/*
		 * ExampleFileFilter filter = new ExampleFileFilter();
		 * filter.addExtension("jpg"); filter.addExtension("gif");
		 * filter.setDescription("JPG & GIF Images");
		 * chooser.setFileFilter(filter);
		 */
		// chooser.setFileFilter(filter)
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
			SubmoduleSaveVO submoduleSaveVO = new SubmoduleSaveVO();
			submoduleSaveVO.setSubjectName((String) subjectsComboBox
					.getSelectedItem());
			submoduleSaveVO.setModuleName(moduleNameTextField.getText());
			submoduleSaveVO.setSubmoduleName(submoduleNameTextField.getText());
			submoduleSaveVO.setSubmoduleDescription(descriptionTextArea.getText());
			if (descriptionImagePathTextField.getText() != null
					&& descriptionImagePathTextField.getText().trim().length() > 0) {

				submoduleSaveVO
						.setDescriptionImage(createInputStreamForImage(descriptionImagePathTextField
								.getText()));
			}

			SubjectHandler subjectHandler = new SubjectHandler();
			int submoduleId = 0;
			try {
				submoduleId = subjectHandler.saveModulenSubmodule(submoduleSaveVO);
			} catch (MaintainSubjectsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (submoduleId > 0) {
				JOptionPane
						.showMessageDialog(
								this,
								"Succesfully added the Module and the submodule to the subject with id: "+submoduleId,
								"SUCCESS", JOptionPane.OK_OPTION);
				resetAllFields();
			}
		}
	}

	private InputStream createInputStreamForImage(String text) {
		FileInputStream fis = null;
		File file = new File(text);
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fis;
	}

	private void resetAllFields() {
		moduleNameTextField.setText("");
		submoduleNameTextField.setText("");
		descriptionTextArea.setText("");
		descriptionImagePathTextField.setText("");
	}

	private boolean isValidEntry() {
		if (moduleNameTextField.getText() == null
				|| moduleNameTextField.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,
					"Please specify the Module Name", "Inane error",
					JOptionPane.ERROR_MESSAGE);
			moduleNameTextField.requestFocus();
			return false;
		}
		if (submoduleNameTextField.getText() == null
				|| submoduleNameTextField.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,
					"Please specify the Sub Module Name", "Inane error",
					JOptionPane.ERROR_MESSAGE);
			submoduleNameTextField.requestFocus();
			return false;
		}
		if (descriptionTextArea.getText() == null
				|| descriptionTextArea.getText().length() == 0) {
			JOptionPane.showMessageDialog(this,
					"Please specify the description for the submodule",
					"Inane error", JOptionPane.ERROR_MESSAGE);
			descriptionTextArea.requestFocus();
			return false;
		}
		return true;
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
				new SubModuleInterfaceUI().setVisible(true);
			}
		});
	}

}
