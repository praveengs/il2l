package com.manteam.iwant2learn.questions.vo;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;

public class QuestionVO implements Serializable {

	private int questionId;

	private String question;

	private InputStream questionImage;
	
	private int questionImageLength;
	
	private byte[] questionImageByteArray;

	private String questionYearMarkString;

	private String answer;

	private InputStream answerImageStream;
	
	private int answerImageLength;

	private String lastModifiedBy;

	private Calendar lastModifiedDate;

	private String lastModifiedRole;

	/**
	 * @return the questionId
	 */
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId
	 *            the questionId to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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
	 * @return the lastModifiedBy
	 */
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	/**
	 * @param lastModifiedBy
	 *            the lastModifiedBy to set
	 */
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public Calendar getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate
	 *            the lastModifiedDate to set
	 */
	public void setLastModifiedDate(Calendar lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @return the lastModifiedRole
	 */
	public String getLastModifiedRole() {
		return lastModifiedRole;
	}

	/**
	 * @param lastModifiedRole
	 *            the lastModifiedRole to set
	 */
	public void setLastModifiedRole(String lastModifiedRole) {
		this.lastModifiedRole = lastModifiedRole;
	}

	/**
	 * @return the questionImageByteArray
	 */
	public byte[] getQuestionImageByteArray() {
		return questionImageByteArray;
	}

	/**
	 * @param questionImageByteArray the questionImageByteArray to set
	 */
	public void setQuestionImageByteArray(byte[] questionImageByteArray) {
		this.questionImageByteArray = questionImageByteArray;
	}

	/**
	 * @return the questionImageLength
	 */
	public int getQuestionImageLength() {
		return questionImageLength;
	}

	/**
	 * @param questionImageLength the questionImageLength to set
	 */
	public void setQuestionImageLength(int questionImageLength) {
		this.questionImageLength = questionImageLength;
	}

	/**
	 * @return the answerImageLength
	 */
	public int getAnswerImageLength() {
		return answerImageLength;
	}

	/**
	 * @param answerImageLength the answerImageLength to set
	 */
	public void setAnswerImageLength(int answerImageLength) {
		this.answerImageLength = answerImageLength;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + answerImageLength;
		result = prime * result
				+ ((lastModifiedBy == null) ? 0 : lastModifiedBy.hashCode());
		result = prime
				* result
				+ ((lastModifiedDate == null) ? 0 : lastModifiedDate.hashCode());
		result = prime
				* result
				+ ((lastModifiedRole == null) ? 0 : lastModifiedRole.hashCode());
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result + questionId;
		result = prime * result + Arrays.hashCode(questionImageByteArray);
		result = prime
				* result
				+ ((questionYearMarkString == null) ? 0
						: questionYearMarkString.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		QuestionVO other = (QuestionVO) obj;
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
		if (lastModifiedBy == null) {
			if (other.lastModifiedBy != null) {
				return false;
			}
		} else if (!lastModifiedBy.equals(other.lastModifiedBy)) {
			return false;
		}
		if (lastModifiedDate == null) {
			if (other.lastModifiedDate != null) {
				return false;
			}
		} else if (!lastModifiedDate.equals(other.lastModifiedDate)) {
			return false;
		}
		if (lastModifiedRole == null) {
			if (other.lastModifiedRole != null) {
				return false;
			}
		} else if (!lastModifiedRole.equals(other.lastModifiedRole)) {
			return false;
		}
		if (question == null) {
			if (other.question != null) {
				return false;
			}
		} else if (!question.equals(other.question)) {
			return false;
		}
		if (questionId != other.questionId) {
			return false;
		}		
		if (!Arrays
				.equals(questionImageByteArray, other.questionImageByteArray)) {
			return false;
		}
		if (questionYearMarkString == null) {
			if (other.questionYearMarkString != null) {
				return false;
			}
		} else if (!questionYearMarkString.equals(other.questionYearMarkString)) {
			return false;
		}
		return true;
	}

	
}
