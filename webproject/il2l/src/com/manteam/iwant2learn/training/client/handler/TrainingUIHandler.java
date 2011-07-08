package com.manteam.iwant2learn.training.client.handler;

import java.util.Collection;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.training.server.TrainingServer;
import com.manteam.iwant2learn.vo.QuestionReturnVO;
import com.manteam.iwant2learn.vo.SubjectVO;

public class TrainingUIHandler {
	private static TrainingUIHandler trainingUIHandler = null;
	
	private TrainingServer trainingServer = null;

	public static TrainingUIHandler getInstance() {
		if (trainingUIHandler == null) {
			trainingUIHandler = new TrainingUIHandler();
		}
		return trainingUIHandler;
	}

	public Collection<SubjectVO> retrieveSubjects(String subjectName)
			throws SystemException {
		Collection<SubjectVO> subjectVOs = null;		

		subjectVOs = getTrainingServer().retrieveSubjects(subjectName);

		return subjectVOs;
	}

	public QuestionReturnVO retrieveQuestionsForSelection(SubjectVO subjectVO)
			throws SystemException {
		
		return getTrainingServer().retrieveQuestions(subjectVO);
	}
	
	public TrainingServer getTrainingServer() {
		if (trainingServer == null) {
			trainingServer = new TrainingServer();
			trainingServer.setMode(AbstractManager.CLIENT_APP_MODE);
		}
		return trainingServer;
	}

}
