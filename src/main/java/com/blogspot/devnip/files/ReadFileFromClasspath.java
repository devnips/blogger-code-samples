package com.blogspot.devnip.files;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * Read file content using plain Java 8
 */
public class ReadFileFromClasspath
{
    public static String read()
    {
        InputStream is = ReadFileFromClasspath.class.getResourceAsStream("/sample-text-file.txt");

        String fileContent = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        return fileContent;
    }
}
