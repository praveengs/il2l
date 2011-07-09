package com.manteam.iwant2learn.questions.client.handler;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.server.MaintainQuestionsManager;
import com.manteam.iwant2learn.questions.vo.QuestionSaveVO;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;

public class MaintainQuestionsHandler {
	private static MaintainQuestionsHandler maintainQuestionsHandler = null;

	private MaintainQuestionsManager maintainQuestionsManager = null;

	public static MaintainQuestionsHandler getInstance() {
		if (maintainQuestionsHandler == null) {
			maintainQuestionsHandler = new MaintainQuestionsHandler();
		}
		return maintainQuestionsHandler;
	}

	public boolean saveQuestion(ExamQuestionsVO examQuestionsVO)
			throws SystemException, MaintainQuestionsException {
		return getMaintainQuestionsManager().saveQuestion(examQuestionsVO);
	}

	public boolean saveQuestion(QuestionSaveVO questionSaveVO)
			throws SystemException, MaintainQuestionsException {
		LogonAttributesVO logonAttributesVO = new LogonAttributesVO();
		return getMaintainQuestionsManager().saveQuestionForSubmodules(
				logonAttributesVO, questionSaveVO);
	}

	private MaintainQuestionsManager getMaintainQuestionsManager() {
		if (maintainQuestionsManager == null) {
			maintainQuestionsManager = new MaintainQuestionsManager();
			maintainQuestionsManager.setMode(AbstractManager.CLIENT_APP_MODE);
		}
		return maintainQuestionsManager;
	}
}
