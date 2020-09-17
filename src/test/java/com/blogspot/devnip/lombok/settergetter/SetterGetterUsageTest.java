package com.blogspot.devnip.lombok.settergetter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class SetterGetterUsageTest {

    @Test
    void test() {
        SimpleObject simpleObject = SetterGetterUsage.createDummy();

        Assertions.assertEquals("James Smith", simpleObject.getName());
        Assertions.assertEquals(LocalDate.of(1980, 11, 27), simpleObject.getDateOfBirth());
    }
}