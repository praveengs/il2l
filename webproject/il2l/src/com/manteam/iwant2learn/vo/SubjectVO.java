package com.manteam.iwant2learn.vo;

import java.io.Serializable;
import java.util.Collection;

public class SubjectVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5595765900211939870L;


	private int subjectId;
	
	private String subjectName;

	private Collection<ModuleVO> modules;

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
	 * @return the modules
	 */
	public Collection<ModuleVO> getModules() {
		return modules;
	}

	/**
	 * @param modules
	 *            the modules to set
	 */
	public void setModules(Collection<ModuleVO> modules) {
		this.modules = modules;
	}

	/**
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modules == null) ? 0 : modules.hashCode());
		result = prime * result + subjectId;
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
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
		SubjectVO other = (SubjectVO) obj;
		if (modules == null) {
			if (other.modules != null) {
				return false;
			}
		} else if (!modules.equals(other.modules)) {
			return false;
		}
		if (subjectId != other.subjectId) {
			return false;
		}
		if (subjectName == null) {
			if (other.subjectName != null) {
				return false;
			}
		} else if (!subjectName.equals(other.subjectName)) {
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
		builder.append("SubjectVO [subjectId=");
		builder.append(subjectId);
		builder.append(", subjectName=");
		builder.append(subjectName);
		builder.append(", modules=");
		builder.append(modules);
		builder.append("]");
		return builder.toString();
	}

	

}
