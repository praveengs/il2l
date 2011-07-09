/**
 * 
 */
package com.manteam.iwant2learn.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

import com.manteam.iwant2learn.subject.vo.KeyWordVO;

/**
 * @author Praveen
 * 
 */
public class QuestionReturnVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7087846808636651727L;

	private Collection<ExamQuestionsVO> examQuestionVOs;

	// Hashmap to hold submodule-keyword mappings
	private HashMap<String, String> submoduleKeyWordMap;

	// Hashmap to hold the keyword details
	private HashMap<String, KeyWordVO> keywordMap;

	/**
	 * @return the examQuestionVOs
	 */
	public Collection<ExamQuestionsVO> getExamQuestionVOs() {
		return examQuestionVOs;
	}

	/**
	 * @param examQuestionVOs
	 *            the examQuestionVOs to set
	 */
	public void setExamQuestionVOs(Collection<ExamQuestionsVO> examQuestionVOs) {
		this.examQuestionVOs = examQuestionVOs;
	}

	/**
	 * @return the submoduleKeyWordMap
	 */
	public HashMap<String, String> getSubmoduleKeyWordMap() {
		return submoduleKeyWordMap;
	}

	/**
	 * @param submoduleKeyWordMap
	 *            the submoduleKeyWordMap to set
	 */
	public void setSubmoduleKeyWordMap(
			HashMap<String, String> submoduleKeyWordMap) {
		this.submoduleKeyWordMap = submoduleKeyWordMap;
	}

	/**
	 * @return the keywordMap
	 */
	public HashMap<String, KeyWordVO> getKeywordMap() {
		return keywordMap;
	}

	/**
	 * @param keywordMap
	 *            the keywordMap to set
	 */
	public void setKeywordMap(HashMap<String, KeyWordVO> keywordMap) {
		this.keywordMap = keywordMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((examQuestionVOs == null) ? 0 : examQuestionVOs.hashCode());
		result = prime * result
				+ ((keywordMap == null) ? 0 : keywordMap.hashCode());
		result = prime
				* result
				+ ((submoduleKeyWordMap == null) ? 0 : submoduleKeyWordMap
						.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		QuestionReturnVO other = (QuestionReturnVO) obj;
		if (examQuestionVOs == null) {
			if (other.examQuestionVOs != null) {
				return false;
			}
		} else if (!examQuestionVOs.equals(other.examQuestionVOs)) {
			return false;
		}
		if (keywordMap == null) {
			if (other.keywordMap != null) {
				return false;
			}
		} else if (!keywordMap.equals(other.keywordMap)) {
			return false;
		}
		if (submoduleKeyWordMap == null) {
			if (other.submoduleKeyWordMap != null) {
				return false;
			}
		} else if (!submoduleKeyWordMap.equals(other.submoduleKeyWordMap)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QuestionReturnVO [examQuestionVOs=" + examQuestionVOs
				+ ", submoduleKeyWordMap=" + submoduleKeyWordMap
				+ ", keywordMap=" + keywordMap + "]";
	}
}
