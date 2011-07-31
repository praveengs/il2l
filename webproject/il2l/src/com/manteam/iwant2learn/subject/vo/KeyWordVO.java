/**
 * 
 */
package com.manteam.iwant2learn.subject.vo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Praveen
 * 
 */
public class KeyWordVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2117387489160913544L;

	private int keyWordId;

	private String keywordName;

	private String quantities;

	private String symbols;

	private String units;

	private String formulae;

	private String data;

	private byte[] keyWordImageByteArray;

	private String keyWordDescription;

	/**
	 * @return the keyWordId
	 */
	public int getKeyWordId() {
		return keyWordId;
	}

	/**
	 * @param keyWordId
	 *            the keyWordId to set
	 */
	public void setKeyWordId(int keyWordId) {
		this.keyWordId = keyWordId;
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
	 * @return the quantities
	 */
	public String getQuantities() {
		return quantities;
	}

	/**
	 * @param quantities
	 *            the quantities to set
	 */
	public void setQuantities(String quantities) {
		this.quantities = quantities;
	}

	/**
	 * @return the symbols
	 */
	public String getSymbols() {
		return symbols;
	}

	/**
	 * @param symbols
	 *            the symbols to set
	 */
	public void setSymbols(String symbols) {
		this.symbols = symbols;
	}

	/**
	 * @return the units
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * @param units
	 *            the units to set
	 */
	public void setUnits(String units) {
		this.units = units;
	}

	/**
	 * @return the formulae
	 */
	public String getFormulae() {
		return formulae;
	}

	/**
	 * @param formulae
	 *            the formulae to set
	 */
	public void setFormulae(String formulae) {
		this.formulae = formulae;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the keyWordImageByteArray
	 */
	public byte[] getKeyWordImageByteArray() {
		return keyWordImageByteArray;
	}

	/**
	 * @param keyWordImageByteArray
	 *            the keyWordImageByteArray to set
	 */
	public void setKeyWordImageByteArray(byte[] keyWordImageByteArray) {
		this.keyWordImageByteArray = keyWordImageByteArray;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((formulae == null) ? 0 : formulae.hashCode());
		result = prime
				* result
				+ ((keyWordDescription == null) ? 0 : keyWordDescription
						.hashCode());
		result = prime * result + keyWordId;
		result = prime * result + Arrays.hashCode(keyWordImageByteArray);
		result = prime * result
				+ ((keywordName == null) ? 0 : keywordName.hashCode());
		result = prime * result
				+ ((quantities == null) ? 0 : quantities.hashCode());
		result = prime * result + ((symbols == null) ? 0 : symbols.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
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
		KeyWordVO other = (KeyWordVO) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (formulae == null) {
			if (other.formulae != null) {
				return false;
			}
		} else if (!formulae.equals(other.formulae)) {
			return false;
		}
		if (keyWordDescription == null) {
			if (other.keyWordDescription != null) {
				return false;
			}
		} else if (!keyWordDescription.equals(other.keyWordDescription)) {
			return false;
		}
		if (keyWordId != other.keyWordId) {
			return false;
		}
		if (!Arrays.equals(keyWordImageByteArray, other.keyWordImageByteArray)) {
			return false;
		}
		if (keywordName == null) {
			if (other.keywordName != null) {
				return false;
			}
		} else if (!keywordName.equals(other.keywordName)) {
			return false;
		}
		if (quantities == null) {
			if (other.quantities != null) {
				return false;
			}
		} else if (!quantities.equals(other.quantities)) {
			return false;
		}
		if (symbols == null) {
			if (other.symbols != null) {
				return false;
			}
		} else if (!symbols.equals(other.symbols)) {
			return false;
		}
		if (units == null) {
			if (other.units != null) {
				return false;
			}
		} else if (!units.equals(other.units)) {
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
		builder.append("KeyWordVO [keyWordId=");
		builder.append(keyWordId);
		builder.append(", keywordName=");
		builder.append(keywordName);
		builder.append(", quantities=");
		builder.append(quantities);
		builder.append(", symbols=");
		builder.append(symbols);
		builder.append(", units=");
		builder.append(units);
		builder.append(", formulae=");
		builder.append(formulae);
		builder.append(", data=");
		builder.append(data);
		builder.append(", keyWordImageByteArray=");
		builder.append(Arrays.toString(keyWordImageByteArray));
		builder.append(", keyWordDescription=");
		builder.append(keyWordDescription);
		builder.append("]");
		return builder.toString();
	}

}
