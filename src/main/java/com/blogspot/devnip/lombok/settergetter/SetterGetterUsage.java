package com.blogspot.devnip.lombok.settergetter;

import java.time.LocalDate;

public class SetterGetterUsage {

    /**
     * Create SimpleObject using Lombok generated setter and getters
     *
     * @return
     */
    public static SimpleObject createDummy() {
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setName("James Smith");
        simpleObject.setDateOfBirth(LocalDate.of(1980, 11, 27));
        return simpleObject;
    }
}
