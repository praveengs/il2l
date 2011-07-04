/**
 * 
 */
package com.manteam.framework.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author Praveen
 * 
 */
public class ReadXML {

	public static Document parseXML(File file) throws XMLReadException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			doc = dBuilder.parse(file);
		} catch (SAXException saxException) {
			// TODO Auto-generated catch block
			saxException.printStackTrace();
			throw new XMLReadException(XMLReadException.SAX_EXCEPTION,
					saxException);
		} catch (IOException ioException) {
			// TODO Auto-generated catch block
			ioException.printStackTrace();
			throw new XMLReadException(XMLReadException.IO_EXCEPTION,
					ioException);
		} catch (ParserConfigurationException parserConfigurationException) {
			// TODO Auto-generated catch block
			parserConfigurationException.printStackTrace();
			throw new XMLReadException(XMLReadException.PARSER_EXCEPTION,
					parserConfigurationException);
		}
		doc.getDocumentElement().normalize();
		return doc;
	}
}
