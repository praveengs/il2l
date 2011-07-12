/**
 * 
 */
package com.manteam.iwant2learn.questions.vo;

import java.io.Serializable;

/**
 * @author Praveen
 *
 */
public class ImageStreamVO implements Serializable {
	
	private byte[] imageByteArray;
	
	private String imageString;

	/**
	 * @return the imageByteArray
	 */
	public byte[] getImageByteArray() {
		return imageByteArray;
	}

	/**
	 * @param imageByteArray the imageByteArray to set
	 */
	public void setImageByteArray(byte[] imageByteArray) {
		this.imageByteArray = imageByteArray;
	}

	/**
	 * @return the imageString
	 */
	public String getImageString() {
		return imageString;
	}

	/**
	 * @param imageString the imageString to set
	 */
	public void setImageString(String imageString) {
		this.imageString = imageString;
	}
	

}
