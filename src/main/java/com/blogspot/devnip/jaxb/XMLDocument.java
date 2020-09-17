package com.blogspot.devnip.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Document")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLDocument {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Code")
    private String code;

    @XmlElement(name = "EmailAddresses")
    private List<XMLEmail> emails;

    @XmlElement(name = "Country")
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<XMLEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<XMLEmail> emails) {
        this.emails = emails;
    }
}
