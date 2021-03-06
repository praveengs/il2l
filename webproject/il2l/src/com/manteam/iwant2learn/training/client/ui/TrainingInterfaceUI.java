package com.manteam.iwant2learn.training.client.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.subject.vo.KeyWordVO;
import com.manteam.iwant2learn.subject.vo.ModuleVO;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.training.client.handler.TrainingUIHandler;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;
import com.manteam.iwant2learn.vo.QuestionReturnVO;

/**
 * 
 * @author Praveen
 */
public class TrainingInterfaceUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2977502544501023756L;
	private JMenuItem closeMenuItem;
	private JPanel answerPanel;
	private JLabel categoryLabel;
	private JLabel descriptionLabel;
	private JPanel descriptionPanel;
	private JScrollPane descriptionScrollPane;
	private JMenu editMenu;
	private JMenu fileMenu;
	private JProgressBar jProgressBar1;
	private JLabel keyWordLabel;
	private JPanel keywordPanel;
	private JMenuBar mainMenuBar;
	private JPanel mainPanel;
	private JButton nextQuestionButton;
	private JButton prevQuestionButton;
	private JPanel questionPanel;
	private JLabel questionPictureLabel;
	private JLabel answerImageLabel;
	private JScrollPane questionScrollPane;
	private JButton showAnswerButton;
	private JButton startTrainingButton;
	private JScrollPane questionAreaScrollPane;
	private JTextArea questionTextArea;
	private JTextArea answerTextArea;
	private JPanel statusPanel;
	private JPanel subjectPanel;
	private JPanel rightPanel;
	private JScrollPane subjectScrollPane;
	private JScrollPane answerImageScrollPane;
	private JScrollPane answerTextScrollPane;
	private JTree subjectTree;
	private TrainingActionListener actionListener;
	private NodeSelectionListener nodeSelectionListener;
	private Collection<SubjectVO> backUpSubjectVOs;
	private int questionCount, currentQuestionIndex = 0;
	private ExamQuestionsVO[] examQuestionVOSArray;
	private HashMap<String, String> submoduleKeywordMap;
	private HashMap<String, KeyWordVO> keyWordMap;
	private HashMap<String, ImageIcon> imageIconStoreMap;
	private HashMap<String, ImageIcon> answerImageIconStoreMap;
	private JSplitPane mainSplitPane;
	

	/** Creates new form JFrameUI */
	public TrainingInterfaceUI() {
		this.setTitle("Question Bank Training");
		initComponents();
		// loadDataForTree();
	}

	private Collection<SubjectVO> loadDataForTree() {

		Collection<SubjectVO> subjectVOs = null;
		try {
			subjectVOs = TrainingUIHandler.getInstance().retrieveSubjects(
					"Physics");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subjectVOs;

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		initPanels();
		initMenu();
		registerActionListeners();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
	}// </editor-fold>

	private void registerActionListeners() {
		actionListener = new TrainingActionListener();
		nodeSelectionListener = new NodeSelectionListener(subjectTree);
		closeMenuItem.addActionListener(actionListener);
		startTrainingButton.addActionListener(actionListener);
		showAnswerButton.addActionListener(actionListener);
		nextQuestionButton.addActionListener(actionListener);
		prevQuestionButton.addActionListener(actionListener);
		subjectTree.addMouseListener(nodeSelectionListener);
	}

	private void initMenu() {
		mainMenuBar = new JMenuBar();
		fileMenu = new JMenu();
		closeMenuItem = new JMenuItem();
		editMenu = new JMenu();

		fileMenu.setText("File");
		closeMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK));
		closeMenuItem.setText("Exit");
		closeMenuItem.setActionCommand("EXIT_COMMAND");
		fileMenu.add(closeMenuItem);

		editMenu.setText("Edit");

		mainMenuBar.add(fileMenu);
		mainMenuBar.add(editMenu);

		setJMenuBar(mainMenuBar);
	}

	private void initPanels() {

		initAnswerPanel();
		initQuestionPanel();
		initSubjectPanel();
		initStatusPanel();
		initDescriptionPanel();
		initMainPanel();

	}

	private void initDescriptionPanel() {
		descriptionPanel = new JPanel();
		descriptionScrollPane = new JScrollPane();
		descriptionLabel = new JLabel();

		descriptionPanel.setBorder(BorderFactory
				.createTitledBorder("Description"));
		descriptionPanel.setLayout(new GridBagLayout());

		descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		descriptionLabel
				.setText("Select a Submodule and click on the Start Training button to start the training");
		descriptionLabel.setAlignmentX(1.0F);
		descriptionScrollPane.setViewportView(descriptionLabel);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		descriptionPanel.add(descriptionScrollPane, gridBagConstraints);

	}

	private void initKeywordPanel() {
		keywordPanel = new JPanel();
		categoryLabel = new JLabel();
		keyWordLabel = new JLabel();
		keywordPanel.setLayout(new GridBagLayout());

		categoryLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		categoryLabel.setText("Category: ");
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		keywordPanel.add(categoryLabel, gridBagConstraints);

		keyWordLabel.setText("Key Words: ");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		keywordPanel.add(keyWordLabel, gridBagConstraints);

	}

	private void initStatusPanel() {
		statusPanel = new JPanel();
		jProgressBar1 = new JProgressBar();

		statusPanel.setBorder(BorderFactory
				.createLineBorder(new Color(0, 0, 0)));
		statusPanel.setLayout(new GridBagLayout());
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.insets = new Insets(0, 0, 0, 10);
		statusPanel.add(jProgressBar1, gridBagConstraints);

	}

	private void initSubjectPanel() {
		subjectPanel = new JPanel();
		subjectScrollPane = new JScrollPane();
		subjectTree = new JTree();
		startTrainingButton = new JButton();
		subjectTree = new javax.swing.JTree(getTreeVector());
		// subjectTree = new javax.swing.JTree();
		CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();
		subjectTree.setCellRenderer(renderer);

		subjectTree.setCellEditor(new CheckBoxNodeEditor(subjectTree));
		subjectTree.setEditable(true);

		subjectPanel.setBorder(BorderFactory.createTitledBorder("Subject"));
		subjectPanel.setMinimumSize(new Dimension(200, 81));
		subjectPanel.setPreferredSize(new Dimension(200, 376));
		subjectPanel.setLayout(new GridBagLayout());

		subjectScrollPane.setViewportView(subjectTree);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		subjectPanel.add(subjectScrollPane, gridBagConstraints);

		startTrainingButton.setText("Start Training");
		startTrainingButton.setToolTipText("Click to Start Training");
		startTrainingButton.setActionCommand("START_TRAINING");

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		subjectPanel.add(startTrainingButton, gridBagConstraints);
	}

	private void initQuestionPanel() {
		showAnswerButton = new JButton();
		prevQuestionButton = new JButton();
		nextQuestionButton = new JButton();
		questionScrollPane = new JScrollPane();
		questionPanel = new JPanel();
		questionAreaScrollPane = new JScrollPane();
		questionTextArea = new JTextArea();

		initKeywordPanel();

		//String questionText = "What is the average speed within first 6 seconds as shown in Distance/Time graph given below?";
		questionPictureLabel = new JLabel("", new ImageIcon(), JLabel.CENTER);

		questionPanel.setBorder(BorderFactory.createTitledBorder("Question"));
		questionPanel.setLayout(new GridBagLayout());

		showAnswerButton.setText("Show Answer");
		showAnswerButton.setActionCommand("SHOW_ANSWER");
		showAnswerButton.setEnabled(false);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weightx = 1.0;
		questionPanel.add(showAnswerButton, gridBagConstraints);
		
		questionTextArea.setColumns(20);
		questionTextArea.setRows(5);
		questionTextArea.setEditable(false);
		questionAreaScrollPane.setMinimumSize(new Dimension(200,200));
		questionAreaScrollPane.setPreferredSize(new Dimension(200,200));
		questionAreaScrollPane.setViewportView(questionTextArea);
		
		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.weightx = 1.0;
        questionPanel.add(questionAreaScrollPane, gridBagConstraints);

		questionPictureLabel.setHorizontalAlignment(SwingConstants.LEFT);		
		//questionPictureLabel.setIcon(new ImageIcon("/sample.gif")); // NOI18N
		//questionPictureLabel.setText(getQuestionLabelText());
		questionPictureLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		questionPictureLabel.setVerticalTextPosition(SwingConstants.TOP);		
		questionScrollPane.setViewportView(questionPictureLabel);
		questionScrollPane.setMinimumSize(new Dimension(500,200));
		questionScrollPane.setPreferredSize(new Dimension(500,200));
		questionPictureLabel.getAccessibleContext().setAccessibleName(
				getQuestionLabelText());

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		//gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		questionPanel.add(questionScrollPane, gridBagConstraints);

		prevQuestionButton.setText("Previous Question");
		prevQuestionButton.setEnabled(false);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		gridBagConstraints.weightx = 0.0;
		questionPanel.add(prevQuestionButton, gridBagConstraints);

		nextQuestionButton.setText("Next Question");

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = GridBagConstraints.EAST;
		questionPanel.add(nextQuestionButton, gridBagConstraints);
		nextQuestionButton.setEnabled(false);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 3;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		questionPanel.add(keywordPanel, gridBagConstraints);

	}

	private void initAnswerPanel() {
		answerPanel = new JPanel();
		answerTextArea = new JTextArea();
		answerImageScrollPane = new JScrollPane();
		answerTextScrollPane = new JScrollPane();
		answerImageLabel = new JLabel();
		 
		answerPanel.setBorder(BorderFactory.createTitledBorder("Answer"));
		answerPanel.setMinimumSize(new Dimension(766, 200));
		answerPanel.setPreferredSize(new Dimension(766, 200));
		answerPanel.setLayout(new GridBagLayout());

        answerTextArea.setColumns(20);
        answerTextArea.setRows(5);
        answerTextArea.setEditable(false);
        //answerTextArea.setEnabled(false);
        answerTextScrollPane.setMinimumSize(new Dimension(200,200));
        answerTextScrollPane.setPreferredSize(new Dimension(200,200));
        answerTextScrollPane.setViewportView(answerTextArea);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        answerPanel.add(answerTextScrollPane, gridBagConstraints);

        //answerImageLabel.setText("jLabel1");
        answerImageScrollPane.setMinimumSize(new Dimension(500,200));
        answerImageScrollPane.setPreferredSize(new Dimension(500,200));
        answerImageScrollPane.setViewportView(answerImageLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.0;
        answerPanel.add(answerImageScrollPane, gridBagConstraints);

		//GroupLayout answerPanelLayout = new GroupLayout(answerPanel);
		/*answerPanel.setLayout(answerPanelLayout);
		answerPanelLayout.setHorizontalGroup(answerPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						754, Short.MAX_VALUE));
		answerPanelLayout.setVerticalGroup(answerPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						171, Short.MAX_VALUE));*/
	}

	private void initMainPanel() {
		mainPanel = new JPanel();
		rightPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		rightPanel.setLayout(new GridBagLayout());
		mainSplitPane = new JSplitPane();
		getContentPane().setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		rightPanel.add(answerPanel, gridBagConstraints);

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		rightPanel.add(questionPanel, gridBagConstraints);

		/*gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridheight = 3;
		gridBagConstraints.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.weighty = 1.0;
		mainPanel.add(subjectPanel, gridBagConstraints);*/

		/*gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weighty = 1.0;
		mainPanel.add(descriptionPanel, gridBagConstraints);*/
		
		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        rightPanel.add(descriptionPanel, gridBagConstraints);
        
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(mainSplitPane, gridBagConstraints);

		mainSplitPane.setLeftComponent(subjectPanel);
		mainSplitPane.setRightComponent(rightPanel);
		
		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 162;
        gridBagConstraints.ipady = 103;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);

        statusPanel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        statusPanel.setLayout(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 10);
        statusPanel.add(jProgressBar1, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 1113;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(18, 0, 0, 0);
        getContentPane().add(statusPanel, gridBagConstraints);
        
		/*GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(mainPanel, GroupLayout.Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
				.addComponent(statusPanel, GroupLayout.DEFAULT_SIZE, 966,
						Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 474,
								Short.MAX_VALUE)
						.addGap(18, 18, 18)
						.addComponent(statusPanel, GroupLayout.PREFERRED_SIZE,
								30, GroupLayout.PREFERRED_SIZE)));*/
	}

	private void CloseActionPerformed(ActionEvent evt) {
		dispose();
	}

	private void showAnswerButtonActionPerformed(ActionEvent evt) {
		populateAnswerPanel(examQuestionVOSArray[currentQuestionIndex]);
	}	

	private void prevQuestionButtonActionPerformed(ActionEvent evt) {
		populateQP(examQuestionVOSArray[--currentQuestionIndex]);
	}

	private void nextQuestionButtonActionPerformed(ActionEvent evt) {
		populateQP(examQuestionVOSArray[++currentQuestionIndex]);
	}

	private void startTrainingButtonActionPerformed(ActionEvent evt) {
		QuestionReturnVO questionReturnVO = null;
		showAnswerButton.setEnabled(false);
		if (backUpSubjectVOs.size() > 0) {
			SubjectVO thisSubjectVO = null;
			for (SubjectVO subjectVO : backUpSubjectVOs) {
				thisSubjectVO = subjectVO;
			}
			try {
				questionReturnVO = TrainingUIHandler.getInstance()
						.retrieveQuestionsForSelection(thisSubjectVO);

				// System.out.println(questionReturnVO);
				if (questionReturnVO != null) {
					populateQuestionPanel(questionReturnVO);
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

		}
	}

	private void populateQuestionPanel(QuestionReturnVO questionReturnVO) {
		System.out.println(questionReturnVO);
		Collection<ExamQuestionsVO> examQuestionsVOs = questionReturnVO
				.getExamQuestionVOs();
		submoduleKeywordMap = questionReturnVO.getSubmoduleKeyWordMap();
		keyWordMap = questionReturnVO.getKeywordMap();
		examQuestionVOSArray = new ExamQuestionsVO[examQuestionsVOs.size()];
		imageIconStoreMap = new HashMap<String, ImageIcon>(2);
		answerImageIconStoreMap = new HashMap<String, ImageIcon>(2);
		int i = 0;
		questionCount = examQuestionsVOs.size();
		currentQuestionIndex = 0;
		for (ExamQuestionsVO examQuestionsVO : examQuestionsVOs) {
			examQuestionVOSArray[i++] = examQuestionsVO;
		}
		populateQP(examQuestionVOSArray[currentQuestionIndex]);
	}

	private void populateQP(ExamQuestionsVO examQuestionsVO) {
		answerTextArea.setText("");
		showAnswerButton.setEnabled(true);
		descriptionLabel.setText(examQuestionsVO.getSubmoduleDescription());
		questionTextArea.setText(examQuestionsVO.getQuestion());
		//questionPictureLabel.setText(examQuestionsVO.getQuestion());
		byte[] bytes;
		BufferedInputStream bis;
		if (examQuestionsVO.getQuestionImage() != null) {
			//ImageIcon newIcon = imageIconStoreMap.get(currentQuestionIndex);
			if (imageIconStoreMap.get(String.valueOf(currentQuestionIndex)) == null) {
				try {
					bytes = new byte[50000];
					bis = new BufferedInputStream(
							examQuestionsVO.getQuestionImage());
	
					bis.read(bytes);
					//questionPictureLabel = new JLabel("", new ImageIcon(
					//bytes), JLabel.CENTER);
					imageIconStoreMap.put(String.valueOf(currentQuestionIndex), new ImageIcon(bytes));					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			questionPictureLabel.setIcon(imageIconStoreMap.get(String.valueOf(currentQuestionIndex)));
			//questionPictureLabel.repaint();
		} else {
			questionPictureLabel.setIcon(new ImageIcon());
		}
		categoryLabel
				.setText("Category: " + examQuestionsVO.getSubmoduleName());
		// keyWordLabel.setText("Key Words: "+examQuestionsVO.get)
		if (currentQuestionIndex == 0) {
			prevQuestionButton.setEnabled(false);
		}
		if (currentQuestionIndex < questionCount - 1) {
			nextQuestionButton.setEnabled(true);
		}
		if (currentQuestionIndex == questionCount - 1) {
			nextQuestionButton.setEnabled(false);
		}
		if (currentQuestionIndex > 0) {
			prevQuestionButton.setEnabled(true);

		}

	}
	
	private void populateAnswerPanel(ExamQuestionsVO examQuestionsVO) {
		answerTextArea.setText(examQuestionsVO.getAnswer());
		byte[] bytes;
		BufferedInputStream bis;
		if (examQuestionsVO.getAnswerImageStream() != null) {
			//ImageIcon newIcon = imageIconStoreMap.get(currentQuestionIndex);
			if (answerImageIconStoreMap.get(String.valueOf(currentQuestionIndex)) == null) {
				try {
					bytes = new byte[50000];
					bis = new BufferedInputStream(
							examQuestionsVO.getAnswerImageStream());
	
					bis.read(bytes);
					//questionPictureLabel = new JLabel("", new ImageIcon(
					//bytes), JLabel.CENTER);
					answerImageIconStoreMap.put(String.valueOf(currentQuestionIndex), new ImageIcon(bytes));					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			answerImageLabel.setIcon(answerImageIconStoreMap.get(String.valueOf(currentQuestionIndex)));			
		} else {
			answerImageLabel.setIcon(new ImageIcon());
		}
	}

	private String getQuestionLabelText() {
		String questionText = "What is the average speed within first 6 seconds as shown in Distance/Time graph given below?";
		return questionText;
	}

	private Vector getTreeVector() {
		// Collection<SubjectVO> subjectVOs = getSubjectVOs();
		Collection<SubjectVO> subjectVOs = loadDataForTree();
		Vector rootVector;
		Object[] subjectNodes = new Object[subjectVOs.size()];
		int subjectCount = 0;
		for (SubjectVO subjectVO : subjectVOs) {
			int moduleCount = 0;
			Object[] moduleNodes = new Object[subjectVO.getModules().size()];

			for (ModuleVO moduleVO : subjectVO.getModules()) {
				CheckBoxNode[] submodules = new CheckBoxNode[moduleVO
						.getSubmodules().size()];
				int submoduleCount = 0;
				for (String submodule : moduleVO.getSubmodules()) {
					submodules[submoduleCount++] = new CheckBoxNode(submodule,
							false);
				}
				moduleNodes[moduleCount++] = new NamedVector(
						moduleVO.getModuleName(), submodules);
			}
			subjectNodes[subjectCount] = new NamedVector(
					subjectVO.getSubjectName(), moduleNodes);
		}
		rootVector = new NamedVector("Root", subjectNodes);
		return rootVector;
	}

	/*
	 * private Vector getTreeVector(Collection<SubjectVO> subjectVOs) { Vector
	 * rootVector; Object[] subjectNodes = new Object[subjectVOs.size()]; int
	 * subjectCount = 0; for (SubjectVO subjectVO : subjectVOs) { int
	 * moduleCount = 0; Object[] moduleNodes = new
	 * Object[subjectVO.getModules().size()];
	 * 
	 * for (ModuleVO moduleVO : subjectVO.getModules()) { CheckBoxNode[]
	 * submodules = new CheckBoxNode[moduleVO .getSubmodules().size()]; int
	 * submoduleCount = 0; for (String submodule : moduleVO.getSubmodules()) {
	 * submodules[submoduleCount++] = new CheckBoxNode(submodule, false); }
	 * moduleNodes[moduleCount++] = new NamedVector( moduleVO.getModuleName(),
	 * submodules); } subjectNodes[subjectCount] = new NamedVector(
	 * subjectVO.getSubjectName(), moduleNodes); } rootVector = new
	 * NamedVector("Root", subjectNodes); return rootVector; }
	 */

	private Collection<SubjectVO> getSubjectVOs() {
		Collection<SubjectVO> subjectVOs = new ArrayList<SubjectVO>(2);

		SubjectVO subjectVO = new SubjectVO();
		subjectVO.setSubjectName("Physics");
		subjectVOs.add(subjectVO);

		Collection<ModuleVO> modules = new ArrayList<ModuleVO>(2);
		subjectVO.setModules(modules);

		ModuleVO moduleVO = new ModuleVO();
		modules.add(moduleVO);
		moduleVO.setModuleName("I General Physics");
		Collection<String> submodules = new ArrayList<String>(2);
		moduleVO.setSubmodules(submodules);

		submodules.add("Physical quantities and units");
		submodules.add("Measurement techniques");
		return subjectVOs;
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
		// http://www.java2s.com/Code/Java/Swing-JFC/CheckBoxNodeTreeSample.htm
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TrainingInterfaceUI().setVisible(true);
			}
		});
	}

	private class TrainingActionListener implements ActionListener,
			ItemListener {

		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getSource() == closeMenuItem) {
				CloseActionPerformed(actionEvent);
			} else if (actionEvent.getSource() == startTrainingButton) {
				startTrainingButtonActionPerformed(actionEvent);
			} else if (actionEvent.getSource() == showAnswerButton) {
				showAnswerButtonActionPerformed(actionEvent);
			} else if (actionEvent.getSource() == prevQuestionButton) {
				prevQuestionButtonActionPerformed(actionEvent);
			} else if (actionEvent.getSource() == nextQuestionButton) {
				nextQuestionButtonActionPerformed(actionEvent);
			}

		}

		public void itemStateChanged(ItemEvent itemEvent) {
			// System.out.println(itemEvent.getItem());

		}

	}

	class NodeSelectionListener extends MouseAdapter {
		JTree tree;

		NodeSelectionListener(JTree tree) {
			this.tree = tree;
		}

		public void mouseClicked(MouseEvent mouseEvent) {
			// MouseEvent mouseEvent = (MouseEvent) event;
			TreePath path = tree.getPathForLocation(mouseEvent.getX(),
					mouseEvent.getY());
			if (path != null) {
				Object node = path.getLastPathComponent();
				Object[] nodes = path.getPath();
				if ((node != null) && (node instanceof DefaultMutableTreeNode)) {
					DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
					Object userObject = treeNode.getUserObject();
					System.out.println("userObject: " + userObject);
					if (treeNode.isLeaf() && userObject instanceof CheckBoxNode) {
						CheckBoxNode checkBoxNode = (CheckBoxNode) userObject;
						SubjectVO subjectVO = buildSubjectVO(nodes,
								checkBoxNode);
						if (checkBoxNode.isSelected()) {
							addToSelectedList(subjectVO);
						} else {
							removeFromSelectedList(subjectVO);
						}
						System.out.println(backUpSubjectVOs);
					}
				}
			}
		}

		private void removeFromSelectedList(SubjectVO subjectVO) {
			if (backUpSubjectVOs != null && backUpSubjectVOs.size() > 0) {
				for (SubjectVO tempSubjectVO : backUpSubjectVOs) {
					if (tempSubjectVO.getSubjectName().equals(
							tempSubjectVO.getSubjectName())) {
						ModuleVO newModule = null;
						for (ModuleVO moduleVO : subjectVO.getModules()) {
							newModule = moduleVO;
						}
						for (ModuleVO moduleVO : tempSubjectVO.getModules()) {
							if (newModule.getModuleName().equals(
									moduleVO.getModuleName())) {
								String newSubmodule = "";
								for (String submodule : newModule
										.getSubmodules()) {
									newSubmodule = submodule;
								}
								if (moduleVO.getSubmodules().contains(
										newSubmodule)) {
									moduleVO.getSubmodules().remove(
											newSubmodule);
								}
								// If this was the last submodule in the Vo
								// collection then remove the VO itself
								if (moduleVO.getSubmodules().size() == 0) {
									tempSubjectVO.getModules().remove(moduleVO);
									break;
								}
							}
						}
						if (tempSubjectVO.getModules().size() == 0) {
							backUpSubjectVOs.remove(tempSubjectVO);
							break;
						}
					}
				}
			}
		}

		private void addToSelectedList(SubjectVO subjectVO) {
			boolean hasInserted = false;
			if (backUpSubjectVOs == null) {
				backUpSubjectVOs = new ArrayList<SubjectVO>(2);
			}
			if (backUpSubjectVOs.size() > 0) {
				for (SubjectVO tempSubjectVO : backUpSubjectVOs) {
					if (tempSubjectVO.getSubjectName().equals(
							tempSubjectVO.getSubjectName())) {
						ModuleVO newModule = null;
						for (ModuleVO moduleVO : subjectVO.getModules()) {
							newModule = moduleVO;
						}
						String newSubmodule = "";
						for (String submodule : newModule.getSubmodules()) {
							newSubmodule = submodule;
						}
						for (ModuleVO moduleVO : tempSubjectVO.getModules()) {
							if (newModule.getModuleName().equals(
									moduleVO.getModuleName())) {
								if (!moduleVO.getSubmodules().contains(
										newSubmodule)) {
									moduleVO.getSubmodules().add(newSubmodule);
									hasInserted = true;
								}
							}
						}
						if (!hasInserted) {
							tempSubjectVO.getModules().add(newModule);
							hasInserted = true;
							break;
						}
					} /*
					 * else { backUpSubjectVOs.add(subjectVO); }
					 */
				}
				if (!hasInserted) {
					backUpSubjectVOs.add(subjectVO);
				}
			} else {
				backUpSubjectVOs.add(subjectVO);
			}

		}

		private SubjectVO buildSubjectVO(Object[] nodes,
				CheckBoxNode checkBoxNode) {
			SubjectVO subjectVO = new SubjectVO();
			DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) nodes[1];
			NamedVector userObject = (NamedVector) treeNode.getUserObject();
			subjectVO.setSubjectName(userObject.name);
			Collection<ModuleVO> moduleVOs = new ArrayList<ModuleVO>(1);
			subjectVO.setModules(moduleVOs);

			treeNode = (DefaultMutableTreeNode) nodes[2];
			userObject = (NamedVector) treeNode.getUserObject();

			ModuleVO moduleVO = new ModuleVO();
			moduleVOs.add(moduleVO);
			moduleVO.setModuleName(userObject.name);

			Collection<String> submodules = new ArrayList<String>(1);
			submodules.add(checkBoxNode.getText());
			moduleVO.setSubmodules(submodules);
			return subjectVO;
		}
	}

	class CheckBoxNodeEditor extends AbstractCellEditor implements
			TreeCellEditor {

		CheckBoxNodeRenderer renderer = new CheckBoxNodeRenderer();

		// ChangeEvent changeEvent = null;

		JTree tree;

		public CheckBoxNodeEditor(JTree tree) {
			this.tree = tree;
		}

		public Object getCellEditorValue() {
			JCheckBox checkbox = renderer.getLeafRenderer();
			checkbox.addItemListener(actionListener);
			CheckBoxNode checkBoxNode = new CheckBoxNode(checkbox.getText(),
					checkbox.isSelected());
			return checkBoxNode;
		}

		public boolean isCellEditable(EventObject event) {
			boolean returnValue = false;
			if (event instanceof MouseEvent) {
				MouseEvent mouseEvent = (MouseEvent) event;
				TreePath path = tree.getPathForLocation(mouseEvent.getX(),
						mouseEvent.getY());
				if (path != null) {
					Object node = path.getLastPathComponent();
					if ((node != null)
							&& (node instanceof DefaultMutableTreeNode)) {
						DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) node;
						Object userObject = treeNode.getUserObject();
						returnValue = ((treeNode.isLeaf()) && (userObject instanceof CheckBoxNode));
					}
				}
			}
			return returnValue;
		}

		public Component getTreeCellEditorComponent(JTree tree, Object value,
				boolean selected, boolean expanded, boolean leaf, int row) {

			Component editor = renderer.getTreeCellRendererComponent(tree,
					value, true, expanded, leaf, row, true);

			// editor always selected / focused
			ItemListener itemListener = new ItemListener() {
				public void itemStateChanged(ItemEvent itemEvent) {
					if (stopCellEditing()) {
						fireEditingStopped();
					}
					// System.out.println(itemEvent.getItem());
				}
			};
			if (editor instanceof JCheckBox) {
				((JCheckBox) editor).addItemListener(itemListener);
			}

			return editor;
		}
	}

	class CheckBoxNode {
		private String text;

		private boolean selected;

		public CheckBoxNode(String text, boolean selected) {
			this.text = text;
			this.selected = selected;
		}

		public boolean isSelected() {
			return selected;
		}

		public void setSelected(boolean newValue) {
			selected = newValue;
		}

		public String getText() {
			return text;
		}

		public void setText(String newValue) {
			text = newValue;
		}

		public String toString() {
			return getClass().getName() + "[" + text + "/" + selected + "]";
		}
	}

	class NamedVector extends Vector {
		String name;

		public NamedVector(String name) {
			this.name = name;
		}

		public NamedVector(String name, Object elements[]) {
			this.name = name;
			for (int i = 0, n = elements.length; i < n; i++) {
				add(elements[i]);
			}
		}

		public String toString() {
			return "[" + name + "]";
		}
	}

	class CheckBoxNodeRenderer implements TreeCellRenderer {
		private JCheckBox leafRenderer = new JCheckBox();

		private DefaultTreeCellRenderer nonLeafRenderer = new DefaultTreeCellRenderer();

		Color selectionBorderColor, selectionForeground, selectionBackground,
				textForeground, textBackground;

		protected JCheckBox getLeafRenderer() {
			return leafRenderer;
		}

		public CheckBoxNodeRenderer() {
			Font fontValue;
			fontValue = UIManager.getFont("Tree.font");
			if (fontValue != null) {
				leafRenderer.setFont(fontValue);
			}
			Boolean booleanValue = (Boolean) UIManager
					.get("Tree.drawsFocusBorderAroundIcon");
			leafRenderer.setFocusPainted((booleanValue != null)
					&& (booleanValue.booleanValue()));

			selectionBorderColor = UIManager
					.getColor("Tree.selectionBorderColor");
			selectionForeground = UIManager
					.getColor("Tree.selectionForeground");
			selectionBackground = UIManager
					.getColor("Tree.selectionBackground");
			textForeground = UIManager.getColor("Tree.textForeground");
			textBackground = UIManager.getColor("Tree.textBackground");
		}

		public Component getTreeCellRendererComponent(JTree tree, Object value,
				boolean selected, boolean expanded, boolean leaf, int row,
				boolean hasFocus) {

			Component returnValue;
			if (leaf) {

				String stringValue = tree.convertValueToText(value, selected,
						expanded, leaf, row, false);
				leafRenderer.setText(stringValue);
				leafRenderer.setSelected(false);

				leafRenderer.setEnabled(tree.isEnabled());

				if (selected) {
					leafRenderer.setForeground(selectionForeground);
					leafRenderer.setBackground(selectionBackground);
				} else {
					leafRenderer.setForeground(textForeground);
					leafRenderer.setBackground(textBackground);
				}

				if ((value != null)
						&& (value instanceof DefaultMutableTreeNode)) {
					Object userObject = ((DefaultMutableTreeNode) value)
							.getUserObject();
					if (userObject instanceof CheckBoxNode) {
						CheckBoxNode node = (CheckBoxNode) userObject;
						leafRenderer.setText(node.getText());
						leafRenderer.setSelected(node.isSelected());
					}
				}
				returnValue = leafRenderer;
			} else {
				returnValue = nonLeafRenderer.getTreeCellRendererComponent(
						tree, value, selected, expanded, leaf, row, hasFocus);
			}
			return returnValue;
		}
	}

}
