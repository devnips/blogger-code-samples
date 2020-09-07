package com.blogspot.devnip.qrcode;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReadQRCodeZXingTest {

    @Test
    void test() {
        URL url = ReadQRCodeZXingTest.class.getResource("/qrcode/qrcode.png");
        assertNotNull(url);

        assertEquals("https://devnip.blogspot.com/", ReadQRCodeZXing.readFile(new File(url.getFile())));
    }
}