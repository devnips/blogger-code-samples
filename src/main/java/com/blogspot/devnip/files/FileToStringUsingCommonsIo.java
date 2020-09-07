package com.blogspot.devnip.files;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Read file as string using Apache commons-io package
 */
public class FileToStringUsingCommonsIo {

    public static String read() {
        URL url = FileToStringUsingCommonsIo.class.getResource("/sample-text-file.txt");
        if (url != null) {
            File file = new File(url.getFile());
            try {
                return FileUtils.readFileToString(file, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
