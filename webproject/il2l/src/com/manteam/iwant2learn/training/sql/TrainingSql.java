package com.manteam.iwant2learn.training.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.manteam.framework.sql.AbstractSql;
import com.manteam.iwant2learn.subject.vo.KeyWordVO;
import com.manteam.iwant2learn.subject.vo.ModuleVO;
import com.manteam.iwant2learn.subject.vo.SubjectVO;
import com.manteam.iwant2learn.vo.ExamQuestionsVO;
import com.manteam.iwant2learn.vo.QuestionReturnVO;
import com.manteam.iwant2learn.vo.QuestionSearchVO;

public class TrainingSql extends AbstractSql {

	private static TrainingSql trainingSql = null;

	public static TrainingSql getInstance() {
		if (trainingSql == null) {
			trainingSql = new TrainingSql();
		}
		return trainingSql;
	}

	public Collection<SubjectVO> retrieveSubjectDetails(Connection connection,
			String subjectName) throws SQLException {
		Collection<SubjectVO> subjectVOs = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = TrainingQueryConstructor.retrieveSubjectDetails(
					subjectName, connection);
			resultSet = preparedStatement.executeQuery();

			subjectVOs = getSubjectVOs(resultSet);
			//System.out.println(subjectVOs);
		} finally {
			close(connection, resultSet, preparedStatement);
		}

		return subjectVOs;
	}        
	

	private Collection<SubjectVO> getSubjectVOs(ResultSet resultSet)
			throws SQLException {
		Collection<SubjectVO> subjectVOs = null;
		Collection<ModuleVO> moduleVOs = null;
		HashMap<String, ModuleVO> moduleMap = null;
		HashMap<Integer, String> idSubmoduleMap = null;
		//HashMap<String, ModuleVO> moduleMap = null;
		Collection<String> subModules = null;
		SubjectVO subjectVO = null;
		ModuleVO moduleVO = null;
		String prevSubject = null;
		String curSubject = null;
		String subModuleName = null;
		String curModuleName = null;
		if (resultSet.next()) {
			do {
				curSubject = resultSet
						.getString(TrainingQueryConstants.SUBJECT_NAME);
				if (!curSubject.equals(prevSubject)) {
					subjectVO = new SubjectVO();
					if (subjectVOs == null) {
						subjectVOs = new ArrayList<SubjectVO>(2);
					}
					subjectVOs.add(subjectVO);
					subjectVO.setSubjectName(curSubject);					
					subjectVO.setSubjectId(resultSet
							.getInt(TrainingQueryConstants.IDSYB_SUBJECT));
				}
				if (moduleMap == null) {
					moduleMap = new HashMap<String, ModuleVO>(2);
				}
				curModuleName = resultSet
						.getString(TrainingQueryConstants.MODULE_NAME);
				moduleVO = moduleMap.get(curModuleName);
				if (moduleVO == null) {
					moduleVO = new ModuleVO();
					subModules = new ArrayList<String>(2);
					idSubmoduleMap = new HashMap<Integer, String>(2);
					moduleVO.setSubmodules(subModules);
					moduleVO.setIdSubModuleMap(idSubmoduleMap);
					moduleVO.setModuleName(curModuleName);
					moduleVO.setModuleId( resultSet
						.getInt(TrainingQueryConstants.SYB_SUB_MODULE_ID));
					if (moduleVOs == null) {
						moduleVOs = new ArrayList<ModuleVO>(2);
						subjectVO.setModules(moduleVOs);
					}
					moduleVOs.add(moduleVO);
					moduleMap.put(curModuleName, moduleVO);
				}
				
				subModuleName = resultSet
						.getString(TrainingQueryConstants.SUBMODULE_NAME);
				moduleVO.getSubmodules().add(subModuleName);
				moduleVO.getIdSubModuleMap().put(resultSet
						.getInt(TrainingQueryConstants.SYB_SUB_SUBMODULE_ID), subModuleName);	
				
				prevSubject = curSubject;

			} while (resultSet.next());
		}
		return subjectVOs;
	}

	public QuestionReturnVO retrieveQuestionsForSelection(
			Connection connection, SubjectVO subjectVO) throws SQLException {
		QuestionReturnVO questionReturnVO = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		// Hashmap to hold submodule-keyword mappings
		HashMap<String, String> submoduleKeyWordMap;

		// Hashmap to hold the keyword details
		HashMap<String, KeyWordVO> keywordMap;

		try {
			preparedStatement = TrainingQueryConstructor.retrieveQuestions(
					subjectVO, connection);
			resultSet = preparedStatement.executeQuery();
			questionReturnVO = getExamQuestionsVOs(resultSet);

			if (questionReturnVO != null) {
				submoduleKeyWordMap = new HashMap<String, String>(2);
				keywordMap = new HashMap<String, KeyWordVO>(2);
				questionReturnVO.setKeywordMap(keywordMap);
				questionReturnVO.setSubmoduleKeyWordMap(submoduleKeyWordMap);
				retrieveKeyWordsForSubmodulesofSubject(connection, subjectVO,
						submoduleKeyWordMap, keywordMap);
			}

		} finally {
			close(connection, resultSet, preparedStatement);
		}

		return questionReturnVO;
	}

	public void retrieveKeyWordsForSubmodulesofSubject(Connection connection,
			SubjectVO subjectVO, HashMap<String, String> submoduleKeyWordMap,
			HashMap<String, KeyWordVO> keywordMap) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = TrainingQueryConstructor
					.retrieveKeyWordsForSubmodulesofSubject(subjectVO,
							connection);
			resultSet = preparedStatement.executeQuery();
			getSubmoduleKeyWordMap(resultSet, submoduleKeyWordMap, keywordMap);
		} finally {
			close(resultSet, preparedStatement);
		}
	}

	private void getSubmoduleKeyWordMap(ResultSet resultSet,
			HashMap<String, String> submoduleKeyWordMap,
			HashMap<String, KeyWordVO> keywordMap) throws SQLException {
		String submoduleName;
		String keyWordName;
		KeyWordVO keyWordVO = null;
		if (resultSet.next()) {
			do {
				submoduleName = resultSet
						.getString(TrainingQueryConstants.SUBMODULE_NAME);
				keyWordName = resultSet
						.getString(TrainingQueryConstants.KEYWORD);
				if (!submoduleKeyWordMap.containsKey(submoduleName)) {
					submoduleKeyWordMap.put(submoduleName, keyWordName);
				}
				if (!keywordMap.containsKey(keyWordName)) {
					keyWordVO = new KeyWordVO();
					keywordMap.put(keyWordName, keyWordVO);
					keyWordVO.setKeywordName(resultSet
							.getString(TrainingQueryConstants.KEYWORD));
					keyWordVO.setQuantities(resultSet
							.getString(TrainingQueryConstants.QUANTITIES));
					keyWordVO.setSymbols(resultSet
							.getString(TrainingQueryConstants.SYMBOLS));
					keyWordVO.setUnits(resultSet
							.getString(TrainingQueryConstants.UNITS));
					keyWordVO.setFormulae(resultSet
							.getString(TrainingQueryConstants.FORMULAE));
					keyWordVO.setData(resultSet
							.getString(TrainingQueryConstants.DATA));
				}
			} while (resultSet.next());
		}
		;
	}

	private QuestionReturnVO getExamQuestionsVOs(ResultSet resultSet)
			throws SQLException {

		Collection<ExamQuestionsVO> examQuestionsVOs = null;
		ExamQuestionsVO examQuestionsVO = null;
		QuestionReturnVO questionReturnVO = null;
		if (resultSet.next()) {
			questionReturnVO = new QuestionReturnVO();
			examQuestionsVOs = new ArrayList<ExamQuestionsVO>(2);
			questionReturnVO.setExamQuestionVOs(examQuestionsVOs);
			do {
				examQuestionsVO = new ExamQuestionsVO();
				examQuestionsVO.setQuestionId(resultSet
						.getInt(TrainingQueryConstants.EXAM_QUESTIONS_ID));
				examQuestionsVO.setSubjectName(resultSet
						.getString(TrainingQueryConstants.SUBJECT_NAME));
				examQuestionsVO.setModuleName(resultSet
						.getString(TrainingQueryConstants.MODULE_NAME));
				examQuestionsVO.setSubmoduleName(resultSet
						.getString(TrainingQueryConstants.SUBMODULE_NAME));
				examQuestionsVO.setSubmoduleDescription(resultSet
						.getString(TrainingQueryConstants.SUBMODULE_DESC));
				examQuestionsVO.setQuestion(resultSet
						.getString(TrainingQueryConstants.QUESTION));
				examQuestionsVO.setQuestionImage(resultSet
						.getBinaryStream(TrainingQueryConstants.QUES_IMG));
				examQuestionsVO.setQuestionImageByteArray(resultSet
						.getBytes(TrainingQueryConstants.QUES_IMG));
				examQuestionsVO.setQuestionYearMarkString(resultSet
						.getString(TrainingQueryConstants.QNO_YEAR_MARKS));
				examQuestionsVO.setAnswer(resultSet
						.getString(TrainingQueryConstants.ANSWER));
				examQuestionsVO.setAnswerImageStream(resultSet
						.getBinaryStream(TrainingQueryConstants.ANSWER_IMG));
				examQuestionsVOs.add(examQuestionsVO);
			} while (resultSet.next());
		}
		return questionReturnVO;
	}

	public QuestionReturnVO retrieveQuestionsForWeb(Connection connection,
			QuestionSearchVO questionSearchVO) throws SQLException {
		QuestionReturnVO questionReturnVO = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		// Hashmap to hold submodule-keyword mappings
		HashMap<String, String> submoduleKeyWordMap;

		// Hashmap to hold the keyword details
		HashMap<String, KeyWordVO> keywordMap;

		try {
			preparedStatement = TrainingQueryConstructor.retrieveQuestionsForWeb(
					questionSearchVO, connection);
			resultSet = preparedStatement.executeQuery();
			questionReturnVO = getExamQuestionsVOs(resultSet);

			if (questionReturnVO != null) {
				submoduleKeyWordMap = new HashMap<String, String>(2);
				keywordMap = new HashMap<String, KeyWordVO>(2);
				questionReturnVO.setKeywordMap(keywordMap);
				questionReturnVO.setSubmoduleKeyWordMap(submoduleKeyWordMap);
				retrieveKeyWordsForSubmodulesofSubject(connection, questionSearchVO,
						submoduleKeyWordMap, keywordMap);
			}

		} finally {
			close(connection, resultSet, preparedStatement);
		}

		return questionReturnVO;
	}

	private void retrieveKeyWordsForSubmodulesofSubject(Connection connection,
			QuestionSearchVO questionSearchVO,
			HashMap<String, String> submoduleKeyWordMap,
			HashMap<String, KeyWordVO> keywordMap) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = TrainingQueryConstructor
					.retrieveKeyWordsForSubmodulesofSubject(questionSearchVO,
							connection);
			resultSet = preparedStatement.executeQuery();
			getSubmoduleKeyWordMap(resultSet, submoduleKeyWordMap, keywordMap);
		} finally {
			close(resultSet, preparedStatement);
		}
		
	}

}
