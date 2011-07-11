package com.manteam.iwant2learn.vo;

import java.util.Collection;
import java.util.HashMap;

public class QuestionSearchVO {

	
	private String subjectName;
	private Collection<String> submodules;
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
	 * @return the submodules
	 */
	public Collection<String> getSubmodules() {
		return submodules;
	}
	/**
	 * @param submodules the submodules to set
	 */
	public void setSubmodules(Collection<String> submodules) {
		this.submodules = submodules;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
		result = prime * result
				+ ((submodules == null) ? 0 : submodules.hashCode());
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
		QuestionSearchVO other = (QuestionSearchVO) obj;
		if (subjectName == null) {
			if (other.subjectName != null) {
				return false;
			}
		} else if (!subjectName.equals(other.subjectName)) {
			return false;
		}
		if (submodules == null) {
			if (other.submodules != null) {
				return false;
			}
		} else if (!submodules.equals(other.submodules)) {
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
		builder.append("QuestionSearchVO [subjectName=");
		builder.append(subjectName);
		builder.append(", submodules=");
		builder.append(submodules);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
