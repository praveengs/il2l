/**
 * 
 */
package com.manteam.iwant2learn.keywords.vo;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author Praveen
 * 
 */
public class KeyWordSaveVO implements Serializable {

	private String subjectName;

	private String submoduleName;

	private String keywordName;

	private String keyWordDescription;

	private InputStream keywordImageStream;

	private int keyWordImageLength;

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
	 * @return the keywordName
	 */
	public String getKeywordName() {
		return keywordName;
	}

	/**
	 * @param keywordName
	 *            the keywordName to set
	 */
	public void setKeywordName(String keywordName) {
		this.keywordName = keywordName;
	}

	/**
	 * @return the keyWordDescription
	 */
	public String getKeyWordDescription() {
		return keyWordDescription;
	}

	/**
	 * @param keyWordDescription
	 *            the keyWordDescription to set
	 */
	public void setKeyWordDescription(String keyWordDescription) {
		this.keyWordDescription = keyWordDescription;
	}

	/**
	 * @return the keywordImageStream
	 */
	public InputStream getKeywordImageStream() {
		return keywordImageStream;
	}

	/**
	 * @param keywordImageStream
	 *            the keywordImageStream to set
	 */
	public void setKeywordImageStream(InputStream keywordImageStream) {
		this.keywordImageStream = keywordImageStream;
	}

	/**
	 * @return the keyWordImageLength
	 */
	public int getKeyWordImageLength() {
		return keyWordImageLength;
	}

	/**
	 * @param keyWordImageLength
	 *            the keyWordImageLength to set
	 */
	public void setKeyWordImageLength(int keyWordImageLength) {
		this.keyWordImageLength = keyWordImageLength;
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
		result = prime
				* result
				+ ((keyWordDescription == null) ? 0 : keyWordDescription
						.hashCode());
		result = prime * result + keyWordImageLength;
		result = prime * result
				+ ((keywordName == null) ? 0 : keywordName.hashCode());
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
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
		KeyWordSaveVO other = (KeyWordSaveVO) obj;
		if (keyWordDescription == null) {
			if (other.keyWordDescription != null) {
				return false;
			}
		} else if (!keyWordDescription.equals(other.keyWordDescription)) {
			return false;
		}
		if (keyWordImageLength != other.keyWordImageLength) {
			return false;
		}
		if (keywordName == null) {
			if (other.keywordName != null) {
				return false;
			}
		} else if (!keywordName.equals(other.keywordName)) {
			return false;
		}
		if (subjectName == null) {
			if (other.subjectName != null) {
				return false;
			}
		} else if (!subjectName.equals(other.subjectName)) {
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
		builder.append("KeyWordSaveVO [subjectName=");
		builder.append(subjectName);
		builder.append(", submoduleName=");
		builder.append(submoduleName);
		builder.append(", keywordName=");
		builder.append(keywordName);
		builder.append(", keyWordDescription=");
		builder.append(keyWordDescription);
		builder.append(", keywordImageStream=");
		builder.append(keywordImageStream);
		builder.append(", keyWordImageLength=");
		builder.append(keyWordImageLength);
		builder.append("]");
		return builder.toString();
	}

}
