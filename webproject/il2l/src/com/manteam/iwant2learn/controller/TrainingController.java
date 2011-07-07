/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manteam.iwant2learn.controller;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.server.MaintainQuestionsManager;
import com.manteam.iwant2learn.training.server.TrainingServer;
import com.manteam.iwant2learn.training.util.WebXMLCreator;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;
import com.manteam.iwant2learn.vo.SubjectVO;

import java.util.Collection;

/**
 * 
 * @author Vandana
 */
public class TrainingController {
	private static TrainingServer trainingServer = null;
	private static MaintainQuestionsManager maintainQuestionsManager = null;

	/**
	 * 
	 * @return
	 * @throws SystemException
	 */
	public Collection<String> retrieveAllSubjects() throws SystemException {
		Collection<String> subjects = null;

		subjects = getTrainingServer().retrieveAllSubjects();
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
}
