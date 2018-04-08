package tools;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import models.Message;

/**
 * Servlet implementation class XmlAction
 * Author : Zizhao Fang
 */
public class XmlParser {
	public static Message doParse(String recStr) {
	    JAXBContext jaxbContext;
			Message msg;
	    try {
			jaxbContext = JAXBContext.newInstance(Message.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();	
		    StringReader reader = new StringReader(recStr);
		    msg = (Message) jaxbUnmarshaller.unmarshal(reader);
		    return msg;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
