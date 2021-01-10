package com.sunjun;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test1 {
	
	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./src/test.xml"));
		
		Element root = document.getRootElement();
		Attribute testTime = root.attribute("testTime");
		System.out.println(testTime.getText());
		Attribute testStatus = root.attribute("testStatus");
		System.out.println(testStatus.getText());
		Element contactElem = root.element("BoardXML");// 
		Attribute serialNumber = contactElem.attribute("serialNumber");
		 System.out.println(serialNumber.getText());
		 Attribute boardType = contactElem.attribute("boardType");
		System.out.println(boardType.getText()); 
		Element stationXML = root.element("StationXML");
		Attribute testerName = stationXML.attribute("testerName");
		System.out.println(testerName.getText());
	
		
		
	}
}
