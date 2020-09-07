package com.blogspot.devnip.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Read file line by line.
 */
public class ReadFileLineByLine {

    public static String read() {
        String fileName = "/multiline-text-file.txt";

        InputStream is = ReadFileLineByLine.class.getResourceAsStream(fileName);

        StringBuilder resultStringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line)
                        .append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }
}
