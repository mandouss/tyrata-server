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
	public Message doParse(String recStr) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Message.class);
			StringReader reader = new StringReader(recStr);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    Message msg = (Message) jaxbUnmarshaller.unmarshal(reader);
		    return msg;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    		
	}
}
