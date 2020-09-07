package com.blogspot.devnip.files.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Zip multiple files to create a single compressed .zip file.
 */
public class ZipMultipleFiles {

    /**
     * Receives a list of file paths and writes them to a single destination zip file.
     *
     * @param sourceFileNames
     * @param destinationFileName
     * @throws IOException
     */
    public static void create(List<String> sourceFileNames, String destinationFileName) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(destinationFileName))) {

            sourceFileNames.forEach(it -> {
                File fileToZip = new File(it);
                try (FileInputStream sourceInputStream = new FileInputStream(fileToZip)) {
                    ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = sourceInputStream.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * Execution method for testing. Compressed file is created in base folder of this repository
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        URL urlOne = ZipAFile.class.getResource("/sample-text-file.txt");
        URL urlTwo = ZipAFile.class.getResource("/qrcode/qrcode.png");

        assert urlOne != null;
        assert urlTwo != null;

        ZipMultipleFiles.create(Arrays.asList(urlOne.getFile(), urlTwo.getFile()),
                "./multiple-compress.zip");
    }
}
