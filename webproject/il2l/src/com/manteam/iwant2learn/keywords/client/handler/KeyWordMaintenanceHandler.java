package com.manteam.iwant2learn.keywords.client.handler;

import java.util.ArrayList;
import java.util.HashMap;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.keywords.exceptions.MaintainKeyWordsException;
import com.manteam.iwant2learn.keywords.manager.MaintainKeywordsManager;
import com.manteam.iwant2learn.keywords.vo.KeyWordSaveVO;
import com.manteam.iwant2learn.subject.server.MaintainSubjectsManager;
import com.manteam.iwant2learn.user.vo.LogonAttributesVO;

public class KeyWordMaintenanceHandler {

	private MaintainSubjectsManager maintainSubjectsManager;
	private MaintainKeywordsManager maintainKeywordsManager;

	public HashMap<String, ArrayList<String>> retrieveAllSubjectsnSubmodules()
			throws SystemException {

		return getManitainSubjectManager().retrieveAllSubjectsnSubmodules();
	}

	public int saveKeyWord(LogonAttributesVO logonAttributesVO,
			KeyWordSaveVO keyWordSaveVO) throws MaintainKeyWordsException,
			SystemException {
		return getMaintainKeywordsManager().saveKeyword(logonAttributesVO,
				keyWordSaveVO);
	}

	private MaintainSubjectsManager getManitainSubjectManager() {
		if (maintainSubjectsManager == null) {
			maintainSubjectsManager = new MaintainSubjectsManager();
			maintainSubjectsManager.setMode(AbstractManager.CLIENT_APP_MODE);
		}
		return maintainSubjectsManager;
	}

	private MaintainKeywordsManager getMaintainKeywordsManager() {
		if (maintainKeywordsManager == null) {
			maintainKeywordsManager = new MaintainKeywordsManager();
			maintainKeywordsManager.setMode(AbstractManager.CLIENT_APP_MODE);
		}
		return maintainKeywordsManager;
	}

}
