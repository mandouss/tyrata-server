package tools;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Servlet implementation class XmlAction
 * Author : Zizhao Fang
 */
public class XmlParser {
	public Message doParse(String recStr) {
	    JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();	
	    StringReader reader = new StringReader(recStr);
	    Message msg = (Message) jaxbUnmarshaller.unmarshal(reader);
	    return msg;
		
	}
}

