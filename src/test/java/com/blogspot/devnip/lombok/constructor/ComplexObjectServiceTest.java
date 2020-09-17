package com.blogspot.devnip.lombok.constructor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComplexObjectServiceTest {

    @Test
    void null_in_nonNul() {
        Assertions.assertThrows(NullPointerException.class, ComplexObjectService::requiredArgsConstructorWithNull);
    }
}