package com.blogspot.devnip.jaxb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.util.Collections;

class XmlGeneratorTest {

    private static final String TRIMMED_RESPONSE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Document><Name>James Smith</Name><Code>123123</Code><EmailAddresses><Value>james@test.com</Value><Type>OFFICE</Type></EmailAddresses></Document>";

    @Test
    void test() throws JAXBException {
        XMLDocument xmlDocument = new XMLDocument();
        xmlDocument.setName(" James Smith ");
        xmlDocument.setCode(" 123123 ");

        XMLEmail xmlEmail = new XMLEmail();
        xmlEmail.setType(" OFFICE ");
        xmlEmail.setValue("    james@test.com");
        xmlDocument.setEmails(Collections.singletonList(xmlEmail));

        String result = XmlGenerator.serialize(xmlDocument);

        Assertions.assertEquals(TRIMMED_RESPONSE, result);
    }
}