/**
 * 
 */
package com.manteam.iwant2learn.user.vo;

import java.io.Serializable;

/**
 * @author Praveen
 * 
 */
public class UserSaveVO implements Serializable {

	private String userName;
	private String password;
	private String userRole;
	private String emailId;
	private String phoneNumber;
	private String addressField1;
	private String addressField2;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the addressField1
	 */
	public String getAddressField1() {
		return addressField1;
	}

	/**
	 * @param addressField1
	 *            the addressField1 to set
	 */
	public void setAddressField1(String addressField1) {
		this.addressField1 = addressField1;
	}

	/**
	 * @return the addressField2
	 */
	public String getAddressField2() {
		return addressField2;
	}

	/**
	 * @param addressField2
	 *            the addressField2 to set
	 */
	public void setAddressField2(String addressField2) {
		this.addressField2 = addressField2;
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
				+ ((addressField1 == null) ? 0 : addressField1.hashCode());
		result = prime * result
				+ ((addressField2 == null) ? 0 : addressField2.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((userRole == null) ? 0 : userRole.hashCode());
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
		UserSaveVO other = (UserSaveVO) obj;
		if (addressField1 == null) {
			if (other.addressField1 != null) {
				return false;
			}
		} else if (!addressField1.equals(other.addressField1)) {
			return false;
		}
		if (addressField2 == null) {
			if (other.addressField2 != null) {
				return false;
			}
		} else if (!addressField2.equals(other.addressField2)) {
			return false;
		}
		if (emailId == null) {
			if (other.emailId != null) {
				return false;
			}
		} else if (!emailId.equals(other.emailId)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		if (userRole == null) {
			if (other.userRole != null) {
				return false;
			}
		} else if (!userRole.equals(other.userRole)) {
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
		builder.append("UserSaveVO [userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", userRole=");
		builder.append(userRole);
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", addressField1=");
		builder.append(addressField1);
		builder.append(", addressField2=");
		builder.append(addressField2);
		builder.append("]");
		return builder.toString();
	}

}
