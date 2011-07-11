/**
 * 
 */
package com.manteam.iwant2learn.training.util;

import java.io.StringWriter;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.manteam.iwant2learn.subject.vo.ModuleVO;
import com.manteam.iwant2learn.subject.vo.SubjectVO;

/**
 * @author Praveen
 * 
 */
public class WebXMLCreator {

	public static String createXMLStreamForWebClient(SubjectVO subjectVO) {
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		String xmlString = null;
		try {
			docBuilder = dbfac.newDocumentBuilder();

			Document doc = docBuilder.newDocument();

			// //////////////////////
			// Creating the XML tree

			// create the root element and add it to the document

			Element root = doc.createElement(WebXMLConstants.ROOT);
			root.setAttribute(WebXMLConstants.ID, "0");
			doc.appendChild(root);

			// create a comment and put it in the root element
			/*
			 * Comment comment = doc.createComment("Just a thought");
			 * root.appendChild(comment);
			 */

			Element subjectChild = getChild(doc, subjectVO.getSubjectName(),
					WebXMLConstants.SUBJECT+subjectVO.getSubjectName());
			root.appendChild(subjectChild);
			Element moduleChild;
			Element submoduleChild;
			for (ModuleVO moduleVO : subjectVO.getModules()) {
				moduleChild = getChild(doc, moduleVO.getModuleName(),
						WebXMLConstants.MODULE+moduleVO.getModuleName());
				HashMap<Integer, String> idSubmoduleMap = moduleVO
						.getIdSubModuleMap();
				for (Integer key : idSubmoduleMap.keySet()) {
					submoduleChild = getChild(doc, idSubmoduleMap.get(key), WebXMLConstants.SUBMODULE+ idSubmoduleMap.get(key));
					moduleChild.appendChild(submoduleChild);
				}

				subjectChild.appendChild(moduleChild);
			}
			// ///////////////
			// Output the XML

			// set up a transformer
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			//trans.setOutputProperty(OutputKeys.INDENT, "yes");

			// create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			xmlString = sw.toString();

			// print xml
			//System.out.println("Here's the xml:\n\n" + xmlString);
		} catch (ParserConfigurationException parserConfigurationException) {
			// TODO Auto-generated catch block
			parserConfigurationException.printStackTrace();
		} catch (TransformerException transformerException) {
			// TODO Auto-generated catch block
			transformerException.printStackTrace();
		}
		return xmlString;

	}

	private static Element getChild(Document doc, String name, String id) {
		Element child = doc.createElement(WebXMLConstants.ITEM);
		child.setAttribute(WebXMLConstants.TEXT, name);
		child.setAttribute(WebXMLConstants.ID, id);
		return child;

	}

}
