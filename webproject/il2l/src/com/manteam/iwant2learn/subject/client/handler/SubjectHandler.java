/**
 * 
 */
package com.manteam.iwant2learn.subject.client.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.framework.manager.AbstractManager;
import com.manteam.iwant2learn.subject.exceptions.MaintainSubjectsException;
import com.manteam.iwant2learn.subject.server.MaintainSubjectsManager;
import com.manteam.iwant2learn.subject.vo.SubmoduleSaveVO;

/**
 * @author Praveen
 * 
 */
public class SubjectHandler {

	private MaintainSubjectsManager maintainSubjectsManager;

	public Collection<String> retrieveAllSubjects() throws SystemException {
		return getManitainSubjectManager().retrieveAllSubjects();
	}

	private MaintainSubjectsManager getManitainSubjectManager() {
		if (maintainSubjectsManager == null) {
			maintainSubjectsManager = new MaintainSubjectsManager();
			maintainSubjectsManager.setMode(AbstractManager.CLIENT_APP_MODE);
		}
		return maintainSubjectsManager;
	}

	public int saveModulenSubmodule(SubmoduleSaveVO submoduleSaveVO)
			throws MaintainSubjectsException, SystemException {
		return getManitainSubjectManager()
				.saveModulenSubmodule(submoduleSaveVO);
	}

	public HashMap<String, ArrayList<String>> retrieveAllSubjectsnSubmodules()
			throws SystemException {

		return getManitainSubjectManager().retrieveAllSubjectsnSubmodules();
	}
}
