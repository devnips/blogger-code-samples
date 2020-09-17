package com.blogspot.devnip.lombok.constructor;

import java.time.LocalDate;

public class ComplexObjectService {

    /**
     * Instantiating object using constructor generate by {@link lombok.RequiredArgsConstructor} of Lombok.
     *
     * @return
     */
    public static ComplexObject requiredArgsConstructor() {
        return new ComplexObject("1", "James Smith", LocalDate.now());
    }

    /**
     * Instantiating object using constructor generate by {@link lombok.RequiredArgsConstructor} of Lombok.
     * Setting null in NonNull field produces NullPointerException error at runtime. See test class for usage.
     *
     * @return
     */
    public static ComplexObject requiredArgsConstructorWithNull() {
        return new ComplexObject(null, "James Smith", LocalDate.now());
    }
}
