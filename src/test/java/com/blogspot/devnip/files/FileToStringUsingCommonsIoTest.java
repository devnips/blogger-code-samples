package com.blogspot.devnip.files;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileToStringUsingCommonsIoTest {

    @Test
    void test() {
        assertEquals("Content of sample text file.", FileToStringUsingCommonsIo.read());
    }
}