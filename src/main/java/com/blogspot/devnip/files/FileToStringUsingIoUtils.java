package com.blogspot.devnip.files;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Reading file as String using Apache IOUtils
 */
public class FileToStringUsingIoUtils {

    public static String read() {
        try {
            InputStream inputStream = FileToStringUsingIoUtils.class.getResourceAsStream("/sample-text-file.txt");
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
