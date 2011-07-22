package com.manteam.iwant2learn.questions.vo;

import java.io.Serializable;
import java.util.Collection;

public class QuestionSaveVO extends QuestionVO implements Serializable {
	
	private String subjectName;
	private String submodule;
	private Collection<String> keywords;
	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}
	/**
	 * @param subjectName the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	/**
	 * @return the submodule
	 */
	public String getSubmodule() {
		return submodule;
	}
	/**
	 * @param submodule the submodule to set
	 */
	public void setSubmodule(String submodule) {
		this.submodule = submodule;
	}
	/**
	 * @return the keywords
	 */
	public Collection<String> getKeywords() {
		return keywords;
	}
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(Collection<String> keywords) {
		this.keywords = keywords;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
		result = prime * result
				+ ((submodule == null) ? 0 : submodule.hashCode());
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
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		QuestionSaveVO other = (QuestionSaveVO) obj;
		if (keywords == null) {
			if (other.keywords != null) {
				return false;
			}
		} else if (!keywords.equals(other.keywords)) {
			return false;
		}
		if (subjectName == null) {
			if (other.subjectName != null) {
				return false;
			}
		} else if (!subjectName.equals(other.subjectName)) {
			return false;
		}
		if (submodule == null) {
			if (other.submodule != null) {
				return false;
			}
		} else if (!submodule.equals(other.submodule)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QuestionSaveVO [subjectName=");
		builder.append(subjectName);
		builder.append(", submodule=");
		builder.append(submodule);
		builder.append(", keywords=");
		builder.append(keywords);
		builder.append("]");
		return builder.toString();
	}	
	

}
