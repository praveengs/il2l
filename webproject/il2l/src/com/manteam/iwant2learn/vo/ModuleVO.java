package com.manteam.iwant2learn.vo;

import java.io.Serializable;
import java.util.Collection;

public class ModuleVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2611574426072452787L;

	private String moduleName;

	private Collection<String> submodules;

	/**
	 * @param moduleName
	 *            the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param submodules
	 *            the submodules to set
	 */
	public void setSubmodules(Collection<String> submodules) {
		this.submodules = submodules;
	}

	/**
	 * @return the submodules
	 */
	public Collection<String> getSubmodules() {
		return submodules;
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
				+ ((submodules == null) ? 0 : submodules.hashCode());
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
		ModuleVO other = (ModuleVO) obj;
		if (moduleName == null) {
			if (other.moduleName != null) {
				return false;
			}
		} else if (!moduleName.equals(other.moduleName)) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModuleVO [moduleName=");
		builder.append(moduleName);
		builder.append(", submodules=");
		builder.append(submodules);
		builder.append("]");
		return builder.toString();
	}

}
