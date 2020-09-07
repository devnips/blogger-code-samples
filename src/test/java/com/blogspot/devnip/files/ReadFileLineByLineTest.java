package com.blogspot.devnip.files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReadFileLineByLineTest
{
    private static final String expectedContent =
            "Line number one.\n" +
                    "Line number two.\n";

    @Test
    void test()
    {
        Assertions.assertEquals(expectedContent, ReadFileLineByLine.read());
    }
}