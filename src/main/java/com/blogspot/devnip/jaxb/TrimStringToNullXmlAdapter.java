package com.blogspot.devnip.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import static java.util.Objects.isNull;

/**
 * Trim all string values while converting to XML, and replace empty Strings with Null.
 * Null values will be excluded from generated XML
 */
public class TrimStringToNullXmlAdapter extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String value) {
        return value;
    }

    @Override
    public String marshal(String value) {
        if (isNull(value)) {
            return null;
        }

        value = value.trim();

        if (value.length() == 0) {
            value = null;
        }

        return value;
    }
}
