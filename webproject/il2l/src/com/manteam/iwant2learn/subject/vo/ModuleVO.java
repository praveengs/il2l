package com.manteam.iwant2learn.subject.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class ModuleVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2611574426072452787L;

	private int moduleId;
	
	private String moduleName;

	private Collection<String> submodules;
	
	private HashMap<Integer, String> idSubModuleMap;

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

	/**
	 * @return the moduleId
	 */
	public int getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the idSubModuleMap
	 */
	public HashMap<Integer, String> getIdSubModuleMap() {
		return idSubModuleMap;
	}

	/**
	 * @param idSubModuleMap the idSubModuleMap to set
	 */
	public void setIdSubModuleMap(HashMap<Integer, String> idSubModuleMap) {
		this.idSubModuleMap = idSubModuleMap;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSubModuleMap == null) ? 0 : idSubModuleMap.hashCode());
		result = prime * result + moduleId;
		result = prime * result
				+ ((moduleName == null) ? 0 : moduleName.hashCode());
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
		ModuleVO other = (ModuleVO) obj;
		if (idSubModuleMap == null) {
			if (other.idSubModuleMap != null) {
				return false;
			}
		} else if (!idSubModuleMap.equals(other.idSubModuleMap)) {
			return false;
		}
		if (moduleId != other.moduleId) {
			return false;
		}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModuleVO [moduleId=");
		builder.append(moduleId);
		builder.append(", moduleName=");
		builder.append(moduleName);
		builder.append(", submodules=");
		builder.append(submodules);
		builder.append(", idSubModuleMap=");
		builder.append(idSubModuleMap);
		builder.append("]");
		return builder.toString();
	}

	

	
}
