/**
 * 
 */
package com.manteam.iwant2learn.subject.vo;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author Praveen
 * 
 */
public class SubmoduleSaveVO implements Serializable {

	private String subjectName;

	private String moduleName;

	private String submoduleName;

	private String submoduleDescription;

	private InputStream descriptionImage;

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
	 * @return the descriptionImage
	 */
	public InputStream getDescriptionImage() {
		return descriptionImage;
	}

	/**
	 * @param descriptionImage
	 *            the descriptionImage to set
	 */
	public void setDescriptionImage(InputStream descriptionImage) {
		this.descriptionImage = descriptionImage;
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
				+ ((moduleName == null) ? 0 : moduleName.hashCode());
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
		SubmoduleSaveVO other = (SubmoduleSaveVO) obj;
		if (moduleName == null) {
			if (other.moduleName != null) {
				return false;
			}
		} else if (!moduleName.equals(other.moduleName)) {
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
		builder.append("SubmoduleSaveVO [subjectName=");
		builder.append(subjectName);
		builder.append(", moduleName=");
		builder.append(moduleName);
		builder.append(", submoduleName=");
		builder.append(submoduleName);
		builder.append(", submoduleDescription=");
		builder.append(submoduleDescription);
		builder.append(", descriptionImage=");
		builder.append(descriptionImage);
		builder.append("]");
		return builder.toString();
	}

}
