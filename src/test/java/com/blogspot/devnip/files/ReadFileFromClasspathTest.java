package com.blogspot.devnip.files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReadFileFromClasspathTest
{

    @Test
    void test()
    {
        Assertions.assertEquals("Content of sample text file.", ReadFileFromClasspath.read());
    }
}