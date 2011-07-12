/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manteam.iwant2learn.controller;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.server.MaintainQuestionsManager;
import com.manteam.iwant2learn.questions.vo.ImageStreamVO;
import com.manteam.iwant2learn.questions.vo.QuestionSaveVO;
import com.manteam.iwant2learn.subject.server.MaintainSubjectsManager;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.training.server.TrainingServer;
import com.manteam.iwant2learn.training.util.WebXMLCreator;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
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
	 * @return
	 * @throws SystemException
	 */
	public Collection<SubjectVO> retrieveSubjectDetails(String subjectName)
			throws SystemException {

		return getTrainingServer().retrieveSubjects(subjectName);
	}
	
	/**
	 * 
	 * @return
	 * @throws SystemException
	 */
	public String retrieveXMLStreamForSubject(String subjectName)
			throws SystemException {
		String xmlString = null;
		Collection<SubjectVO> subjectVOs = retrieveSubjectDetails(subjectName);
		for (SubjectVO subjectVO: subjectVOs) {
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
		return getQuestionManager().saveQuestionForSubmodules(logonAttributesVO, questionSaveVO);
	}
	
	/**
	 * This method returns all the subjects and submodules associated with it
	 * in the form of a HashMap. This is used to populate the Question Creation
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
	 * This method returns all the subjects and submodules associated with it
	 * in the form of a HashMap. This is used to populate the Question Creation
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
	 * To get the question manager
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
	 * @return
	 */
	private MaintainSubjectsManager getMaintainSubjectsManager() {
		if (maintainSubjectsManager == null) {
			maintainSubjectsManager = new MaintainSubjectsManager();
		}
		return maintainSubjectsManager;
	}
}
