package com.manteam.iwant2learn.training.client.handler;

import java.util.Collection;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.training.server.TrainingServer;
import com.manteam.iwant2learn.vo.QuestionReturnVO;
import com.manteam.iwant2learn.vo.QuestionSearchVO;
import com.manteam.iwant2learn.vo.SubjectVO;

public class TrainingUIHandler {
	private static TrainingUIHandler trainingUIHandler = null;

	public static TrainingUIHandler getInstance() {
		if (trainingUIHandler == null) {
			trainingUIHandler = new TrainingUIHandler();
		}
		return trainingUIHandler;
	}

	public Collection<SubjectVO> retrieveSubjects(String subjectName)
			throws SystemException {
		Collection<SubjectVO> subjectVOs = null;
		TrainingServer trainingServer = new TrainingServer();

		subjectVOs = trainingServer.retrieveSubjects(subjectName);

		return subjectVOs;
	}

	public QuestionReturnVO retrieveQuestionsForSelection(SubjectVO subjectVO)
			throws SystemException {
		TrainingServer trainingServer = new TrainingServer();
		return trainingServer.retrieveQuestions(subjectVO);
	}

}
