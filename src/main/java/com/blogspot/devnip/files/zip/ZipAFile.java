package com.blogspot.devnip.files.zip;

import java.io.*;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Zip a file can create a compressed .zip file.
 */
public class ZipAFile {

    /**
     * @param sourceFileName
     * @param destinationFileName
     * @throws IOException
     */
    public static void create(String sourceFileName, String destinationFileName) throws IOException {
        File fileToZip = new File(sourceFileName);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(destinationFileName));
             FileInputStream sourceInputStream = new FileInputStream(fileToZip)) {

            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = sourceInputStream.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
        }
    }

    /**
     * Execution method for testing. Compressed file is created in base folder of this repository
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        URL url = ZipAFile.class.getResource("/sample-text-file.txt");
        assert url != null;

        create(url.getFile(), "./single-compress.zip");
    }
}
