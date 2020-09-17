package com.blogspot.devnip.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TrimStringToNullConfigurationTest {

    private TrimStringToNullConfiguration configuration = new TrimStringToNullConfiguration();

    /**
     * Demonstrates trimming of all string values in a Java object.
     *
     * @throws JsonProcessingException
     */
    @Test
    void test() throws JsonProcessingException {
        Client testClient = new Client();
        testClient.setName("   James Smith ");      // String with spaces
        testClient.setSocialId(null);               // Null value
        testClient.setAge(23);                      // Non string value
        Address address = new Address();
        address.setCity("   New York");             // Demonstrates nested fields
        testClient.setOfficeAddress(address);

        Client result = configuration.trimToNull(testClient);

        Assertions.assertEquals("James Smith", result.getName());
        Assertions.assertEquals("New York", result.getOfficeAddress().getCity());
    }
}