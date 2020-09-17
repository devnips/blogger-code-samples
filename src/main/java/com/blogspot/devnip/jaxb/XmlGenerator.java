package com.blogspot.devnip.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Handles XML conversion
 */
public class XmlGenerator {

    /**
     * Convert Java object to XML
     *
     * @param input
     * @return
     * @throws JAXBException
     */
    public static String serialize(Object input) throws JAXBException {
        JAXBContext contextObj = JAXBContext.newInstance(input.getClass());

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);

        StringWriter sw = new StringWriter();
        marshallerObj.marshal(input, sw);

        return sw.toString();
    }
}
