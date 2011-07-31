/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manteam.iwant2learn.controller;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.keywords.exceptions.MaintainKeyWordsException;
import com.manteam.iwant2learn.keywords.manager.MaintainKeywordsManager;
import com.manteam.iwant2learn.keywords.vo.KeyWordSaveVO;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.server.MaintainQuestionsManager;
import com.manteam.iwant2learn.questions.vo.ImageStreamVO;
import com.manteam.iwant2learn.questions.vo.QuestionSaveVO;
import com.manteam.iwant2learn.subject.server.MaintainSubjectsManager;
import com.manteam.iwant2learn.subject.vo.KeyWordVO;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.training.server.TrainingServer;
import com.manteam.iwant2learn.training.util.WebXMLCreator;
import com.manteam.iwant2learn.user.exceptions.MaintainUserException;
import com.manteam.iwant2learn.user.manager.MaintainUserManager;
import com.manteam.iwant2learn.user.vo.LoginVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.user.vo.UserSaveVO;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;
import com.manteam.iwant2learn.vo.QuestionReturnVO;
import com.manteam.iwant2learn.vo.QuestionSearchVO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * 
 * @author Vandana
 */
public class TrainingController {
	private static TrainingServer trainingServer = null;
	private static MaintainQuestionsManager maintainQuestionsManager = null;
	private static MaintainSubjectsManager maintainSubjectsManager = null;
	private static MaintainKeywordsManager maintainKeywordsManager = null;
	private static MaintainUserManager maintainUserManager = null;

	/**
	 * This method returns the questions for the selected modules, submodules of
	 * a particular subject
	 * 
	 * @param subjectVO
	 * @return
	 * @throws SystemException
	 */
	public QuestionReturnVO retrieveQuestions(SubjectVO subjectVO)
			throws SystemException {
		return getTrainingServer().retrieveQuestions(subjectVO);
	}

	/**
	 * This method returns the questions for the selected modules, submodules of
	 * a particular subject
	 * 
	 * @param subjectVO
	 * @return
	 * @throws SystemException
	 */
	public QuestionReturnVO retrieveQuestions(QuestionSearchVO questionSearchVO)
			throws SystemException {
		return getTrainingServer().retrieveQuestionsForWeb(questionSearchVO);
	}

	/**
	 * This method retrieves all the subjects defined in the system
	 * 
	 * @return
	 * @throws SystemException
	 */
	public Collection<String> retrieveAllSubjects() throws SystemException {
		Collection<String> subjects = null;

		subjects = getMaintainSubjectsManager().retrieveAllSubjects();
		return subjects;
	}

	/**
	 * 
	 * @param keyWords 
	 * @return
	 * @throws SystemException
	 */
	public Collection<SubjectVO> retrieveSubjectDetails(String subjectName, Collection<String> keyWords)
			throws SystemException {

		return getTrainingServer().retrieveSubjects(subjectName, keyWords);
	}

	/**
	 * 
	 * @return
	 * @throws SystemException
	 */
	public String retrieveXMLStreamForSubject(String subjectName, Collection<String> keyWords)
			throws SystemException {
		String xmlString = null;
		Collection<SubjectVO> subjectVOs = retrieveSubjectDetails(subjectName, keyWords);
		for (SubjectVO subjectVO : subjectVOs) {
			xmlString = WebXMLCreator.createXMLStreamForWebClient(subjectVO);
		}
		return xmlString;
	}

	/**
	 * Method to save the question into the database
	 * 
	 * @param examQuestionsVO
	 * @return
	 * @throws SystemException
	 * @throws MaintainQuestionsException
	 */
	public boolean saveQuestion(ExamQuestionsVO examQuestionsVO)
			throws SystemException, MaintainQuestionsException {
		return getQuestionManager().saveQuestion(examQuestionsVO);
	}

	/**
	 * New Method to save question
	 * 
	 * @param logonAttributesVO
	 * @param questionSaveVO
	 * @return
	 * @throws SystemException
	 * @throws MaintainQuestionsException
	 */
	public boolean saveQuestionForSubmodules(
			LogonAttributesVO logonAttributesVO, QuestionSaveVO questionSaveVO)
			throws SystemException, MaintainQuestionsException {
		return getQuestionManager().saveQuestionForSubmodules(
				logonAttributesVO, questionSaveVO);
	}

	/**
	 * This method returns all the subjects and submodules associated with it in
	 * the form of a HashMap. This is used to populate the Question Creation
	 * screen
	 * 
	 * @return
	 * @throws SystemException
	 */
	public HashMap<String, ArrayList<String>> retrieveAllSubjectsnSubmodules()
			throws SystemException {
		return getMaintainSubjectsManager().retrieveAllSubjectsnSubmodules();
	}

	/**
	 * This method returns all the subjects and submodules associated with it in
	 * the form of a HashMap. This is used to populate the Question Creation
	 * screen
	 * 
	 * @return
	 * @throws SystemException
	 */
	public ImageStreamVO retrieveImageInfoForQuestion(int questionId)
			throws SystemException {
		return getQuestionManager().retrieveImageInfoForQuestion(questionId);
	}

	/**
	 * This method adds a new keyword into the system
	 * 
	 * @param logonAttributesVO
	 * @param keyWordSaveVO
	 * @return
	 * @throws MaintainKeyWordsException
	 * @throws SystemException
	 */
	public int saveKeyword(LogonAttributesVO logonAttributesVO,
			KeyWordSaveVO keyWordSaveVO) throws MaintainKeyWordsException,
			SystemException {
		return getMaintainKeywordsManager().saveKeyword(logonAttributesVO,
				keyWordSaveVO);
	}

	/**
	 * This method returns all the subjects, submodules and the keywords
	 * associated with it. This is used to populate the Question Creation screen
	 * 
	 * @return
	 * @throws SystemException
	 */
	public HashMap<String, HashMap<String, ArrayList<String>>> retrieveAllSubjectDetailsForAddQuestion()
			throws SystemException {
		return getMaintainSubjectsManager()
				.retrieveAllSubjectDetailsForAddQuestion();
	}

	/**
	 * This method is used to authenticate a user logged in through the system
	 * 
	 * @param loginVO
	 * @return
	 * @throws MaintainUserException
	 * @throws SystemException
	 */
	public LogonAttributesVO authenticateUser(LoginVO loginVO)
			throws MaintainUserException, SystemException {
		return getMaintainUserManager().authenticateUser(loginVO);
	}

	/**
	 * This method is used to save a user into the system
	 * 
	 * @param logonAttributesVO
	 * @param userSaveVO
	 * @return
	 * @throws SystemException 
	 * @throws MaintainUserException 
	 */
	public boolean addUser(LogonAttributesVO logonAttributesVO,
			UserSaveVO userSaveVO) throws MaintainUserException, SystemException {
		return getMaintainUserManager().addUser(logonAttributesVO, userSaveVO);
	}
	
	
	/**
	 * This method returns all the keywords attached with a subject
	 * 
	 * @param subjectName
	 * @return
	 * @throws SystemException
	 */
	public Collection<String> retrieveKeyWordsForSubject(String subjectName)
			throws SystemException {

		return getMaintainSubjectsManager().retrieveKeyWordsForSubject(subjectName);
	}
	
	/**
	 * 
	 * THis method retrieves the keyword Info for the keyword Id
	 * 
	 * 
	 * @param keyWordId
	 * @return
	 * @throws MaintainKeyWordsException
	 * @throws SystemException
	 */
	public KeyWordVO retrieveKeywordInfo(int keyWordId) throws MaintainKeyWordsException,
			SystemException {
		return getMaintainKeywordsManager().retrieveKeywordInfo(keyWordId);
	}


	/**
	 * To get the question manager
	 * 
	 * @return
	 */
	private MaintainQuestionsManager getQuestionManager() {
		if (maintainQuestionsManager == null) {
			maintainQuestionsManager = new MaintainQuestionsManager();
		}
		return maintainQuestionsManager;
	}

	/**
	 * Get the training server
	 * 
	 * @return
	 */
	private TrainingServer getTrainingServer() {
		if (trainingServer == null) {
			trainingServer = new TrainingServer();
		}
		return trainingServer;
	}

	/**
	 * To get the instance of the Maintain Subjects Manager class
	 * 
	 * @return
	 */
	private MaintainSubjectsManager getMaintainSubjectsManager() {
		if (maintainSubjectsManager == null) {
			maintainSubjectsManager = new MaintainSubjectsManager();
		}
		return maintainSubjectsManager;
	}

	/**
	 * Method to return the keywords manager
	 * 
	 * @return
	 */
	private MaintainKeywordsManager getMaintainKeywordsManager() {
		if (maintainKeywordsManager == null) {
			maintainKeywordsManager = new MaintainKeywordsManager();
		}
		return maintainKeywordsManager;
	}

	/**
	 * Method to return the user manager
	 * 
	 * @return
	 */
	private MaintainUserManager getMaintainUserManager() {
		if (maintainUserManager == null) {
			maintainUserManager = new MaintainUserManager();
		}
		return maintainUserManager;
	}
}
