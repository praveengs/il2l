/**
 * 
 */
package com.manteam.iwant2learn.vo;

import java.io.Serializable;
import java.util.HashMap;

import com.manteam.iwant2learn.questions.vo.QuestionVO;

/**
 * @author Praveen
 * 
 */
public class ExamQuestionsVO extends QuestionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7563438310076340511L;

	private int subjectID;

	private String subjectName;

	private String moduleName;

	private String submoduleName;

	private String submoduleDescription;

	private HashMap<String, KeyWordVO> keyWordMap;

	/**
	 * @return the subjectID
	 */
	public int getSubjectID() {
		return subjectID;
	}

	/**
	 * @param subjectID
	 *            the subjectID to set
	 */
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * @param subjectName
	 *            the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName
	 *            the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the submoduleName
	 */
	public String getSubmoduleName() {
		return submoduleName;
	}

	/**
	 * @param submoduleName
	 *            the submoduleName to set
	 */
	public void setSubmoduleName(String submoduleName) {
		this.submoduleName = submoduleName;
	}

	/**
	 * @return the submoduleDescription
	 */
	public String getSubmoduleDescription() {
		return submoduleDescription;
	}

	/**
	 * @param submoduleDescription
	 *            the submoduleDescription to set
	 */
	public void setSubmoduleDescription(String submoduleDescription) {
		this.submoduleDescription = submoduleDescription;
	}

	/**
	 * @return the keyWordMap
	 */
	public HashMap<String, KeyWordVO> getKeyWordMap() {
		return keyWordMap;
	}

	/**
	 * @param keyWordMap
	 *            the keyWordMap to set
	 */
	public void setKeyWordMap(HashMap<String, KeyWordVO> keyWordMap) {
		this.keyWordMap = keyWordMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((keyWordMap == null) ? 0 : keyWordMap.hashCode());
		result = prime * result
				+ ((moduleName == null) ? 0 : moduleName.hashCode());
		result = prime * result + subjectID;
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
		result = prime
				* result
				+ ((submoduleDescription == null) ? 0 : submoduleDescription
						.hashCode());
		result = prime * result
				+ ((submoduleName == null) ? 0 : submoduleName.hashCode());
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
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ExamQuestionsVO other = (ExamQuestionsVO) obj;
		if (keyWordMap == null) {
			if (other.keyWordMap != null) {
				return false;
			}
		} else if (!keyWordMap.equals(other.keyWordMap)) {
			return false;
		}
		if (moduleName == null) {
			if (other.moduleName != null) {
				return false;
			}
		} else if (!moduleName.equals(other.moduleName)) {
			return false;
		}
		if (subjectID != other.subjectID) {
			return false;
		}
		if (subjectName == null) {
			if (other.subjectName != null) {
				return false;
			}
		} else if (!subjectName.equals(other.subjectName)) {
			return false;
		}
		if (submoduleDescription == null) {
			if (other.submoduleDescription != null) {
				return false;
			}
		} else if (!submoduleDescription.equals(other.submoduleDescription)) {
			return false;
		}
		if (submoduleName == null) {
			if (other.submoduleName != null) {
				return false;
			}
		} else if (!submoduleName.equals(other.submoduleName)) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("ExamQuestionsVO [subjectID=");
		builder.append(subjectID);
		builder.append(", subjectName=");
		builder.append(subjectName);
		builder.append(", moduleName=");
		builder.append(moduleName);
		builder.append(", submoduleName=");
		builder.append(submoduleName);
		builder.append(", submoduleDescription=");
		builder.append(submoduleDescription);
		builder.append(", keyWordMap=");
		builder.append(keyWordMap);
		builder.append("]");
		return builder.toString();
	}

}
