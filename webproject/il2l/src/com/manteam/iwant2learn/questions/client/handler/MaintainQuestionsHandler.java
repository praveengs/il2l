package com.manteam.iwant2learn.questions.client.handler;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException;
import com.manteam.iwant2learn.questions.server.MaintainQuestionsManager;
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

	private MaintainQuestionsManager getMaintainQuestionsManager() {
		if (maintainQuestionsManager == null) {
			maintainQuestionsManager = new MaintainQuestionsManager();
		}
		return maintainQuestionsManager;
	}
}
