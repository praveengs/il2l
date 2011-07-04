package com.manteam.iwant2learn.training.server;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.ejb.Stateless;

import com.manteam.framework.exceptions.SystemException;
import com.manteam.iwant2learn.training.sql.TrainingSql;
import com.manteam.iwant2learn.vo.SubjectVO;


@Stateless
public class TrainingServerBean implements TrainingServerInterface {
	public Collection<SubjectVO> retrieveSubjects(String subjectName)
			throws SystemException {
		Collection<SubjectVO> subjectVOs = null;
		Connection connection;
		try {
			connection = null;

			subjectVOs = TrainingSql.getInstance().retrieveSubjects(connection,
					subjectName);
		} catch (SQLException sqlException) {
			throw new SystemException(SystemException.UNEXPECTED_DB_ERROR,
					sqlException);
		}
		return subjectVOs;
	}
}
