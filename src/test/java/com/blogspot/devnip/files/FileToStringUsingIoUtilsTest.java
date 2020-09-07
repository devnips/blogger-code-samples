package com.blogspot.devnip.files;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileToStringUsingIoUtilsTest {

    @Test
    void test() {
        assertEquals("Content of sample text file.", FileToStringUsingIoUtils.read());
    }
}