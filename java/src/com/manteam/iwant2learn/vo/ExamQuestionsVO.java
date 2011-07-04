/**
 * 
 */
package com.manteam.iwant2learn.vo;

import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Praveen
 * 
 */
public class ExamQuestionsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7563438310076340511L;

	private String subjectName;

	private String moduleName;

	private String submoduleName;

	private String submoduleDescription;

	private String question;

	private InputStream questionImage;

	private int questionImageLength;

	private String questionYearMarkString;

	private String answer;

	private String answerImageName;

	private int answerImageLength;

	private InputStream answerImageStream;

	private HashMap<String, KeyWordVO> keyWordMap;

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
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the questionImage
	 */
	public InputStream getQuestionImage() {
		return questionImage;
	}

	/**
	 * @param questionImage
	 *            the questionImage to set
	 */
	public void setQuestionImage(InputStream questionImage) {
		this.questionImage = questionImage;
	}

	/**
	 * @return the questionYearMarkString
	 */
	public String getQuestionYearMarkString() {
		return questionYearMarkString;
	}

	/**
	 * @param questionYearMarkString
	 *            the questionYearMarkString to set
	 */
	public void setQuestionYearMarkString(String questionYearMarkString) {
		this.questionYearMarkString = questionYearMarkString;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the answerImageName
	 */
	public String getAnswerImageName() {
		return answerImageName;
	}

	/**
	 * @param answerImageName
	 *            the answerImageName to set
	 */
	public void setAnswerImageName(String answerImageName) {
		this.answerImageName = answerImageName;
	}

	/**
	 * @return the answerImageStream
	 */
	public InputStream getAnswerImageStream() {
		return answerImageStream;
	}

	/**
	 * @param answerImageStream
	 *            the answerImageStream to set
	 */
	public void setAnswerImageStream(InputStream answerImageStream) {
		this.answerImageStream = answerImageStream;
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

	public void setQuestionImageLength(int questionImageLength) {
		this.questionImageLength = questionImageLength;
	}

	public int getQuestionImageLength() {
		return questionImageLength;
	}

	public void setAnswerImageLength(int answerImageLength) {
		this.answerImageLength = answerImageLength;
	}

	public int getAnswerImageLength() {
		return answerImageLength;
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
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + answerImageLength;
		result = prime * result
				+ ((answerImageName == null) ? 0 : answerImageName.hashCode());
		result = prime
				* result
				+ ((answerImageStream == null) ? 0 : answerImageStream
						.hashCode());
		result = prime * result
				+ ((keyWordMap == null) ? 0 : keyWordMap.hashCode());
		result = prime * result
				+ ((moduleName == null) ? 0 : moduleName.hashCode());
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result
				+ ((questionImage == null) ? 0 : questionImage.hashCode());
		result = prime * result + questionImageLength;
		result = prime
				* result
				+ ((questionYearMarkString == null) ? 0
						: questionYearMarkString.hashCode());
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
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ExamQuestionsVO other = (ExamQuestionsVO) obj;
		if (answer == null) {
			if (other.answer != null) {
				return false;
			}
		} else if (!answer.equals(other.answer)) {
			return false;
		}
		if (answerImageLength != other.answerImageLength) {
			return false;
		}
		if (answerImageName == null) {
			if (other.answerImageName != null) {
				return false;
			}
		} else if (!answerImageName.equals(other.answerImageName)) {
			return false;
		}
		if (answerImageStream == null) {
			if (other.answerImageStream != null) {
				return false;
			}
		} else if (!answerImageStream.equals(other.answerImageStream)) {
			return false;
		}
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
		if (question == null) {
			if (other.question != null) {
				return false;
			}
		} else if (!question.equals(other.question)) {
			return false;
		}
		if (questionImage == null) {
			if (other.questionImage != null) {
				return false;
			}
		} else if (!questionImage.equals(other.questionImage)) {
			return false;
		}
		if (questionImageLength != other.questionImageLength) {
			return false;
		}
		if (questionYearMarkString == null) {
			if (other.questionYearMarkString != null) {
				return false;
			}
		} else if (!questionYearMarkString.equals(other.questionYearMarkString)) {
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
		return "ExamQuestionsVO [subjectName=" + subjectName + ", moduleName="
				+ moduleName + ", submoduleName=" + submoduleName
				+ ", submoduleDescription=" + submoduleDescription
				+ ", question=" + question + ", questionImage=" + questionImage
				+ ", questionImageLength=" + questionImageLength
				+ ", questionYearMarkString=" + questionYearMarkString
				+ ", answer=" + answer + ", answerImageName=" + answerImageName
				+ ", answerImageLength=" + answerImageLength
				+ ", answerImageStream=" + answerImageStream + ", keyWordMap="
				+ keyWordMap + "]";
	}

}
