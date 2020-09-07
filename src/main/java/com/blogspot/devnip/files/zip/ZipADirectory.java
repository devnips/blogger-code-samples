package com.blogspot.devnip.files.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Create a compressed zip file from a directory.
 */
public class ZipADirectory {

    private static final String SEPARATOR = "/";

    /**
     * Compresses a directory to a zip file
     *
     * @param sourceDir
     * @param destinationFile
     * @throws IOException
     */
    private static void create(String sourceDir, String destinationFile) throws IOException {
        try (FileOutputStream destinationOutputStream = new FileOutputStream(destinationFile);
             ZipOutputStream zipOut = new ZipOutputStream(destinationOutputStream)) {
            File fileToZip = new File(sourceDir);

            zipFile(fileToZip, fileToZip.getName(), zipOut);
        }
    }

    /**
     * Add file or directory to the output Zip file.
     *
     * @param fileToZip
     * @param fileName
     * @param zipOut
     * @throws IOException
     */
    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (!fileToZip.isHidden()) {
            if (fileToZip.isDirectory()) {
                if (fileName.endsWith(SEPARATOR)) {
                    zipOut.putNextEntry(new ZipEntry(fileName));
                } else {
                    zipOut.putNextEntry(new ZipEntry(fileName + SEPARATOR));
                }
                zipOut.closeEntry();

                if (fileToZip.listFiles() != null) {
                    Arrays.stream(fileToZip.listFiles())
                            .forEach(child -> {
                                try {
                                    zipFile(child, fileName + SEPARATOR + child.getName(), zipOut);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                }
            } else {
                try (FileInputStream inputStream = new FileInputStream(fileToZip)) {
                    ZipEntry zipEntry = new ZipEntry(fileName);
                    zipOut.putNextEntry(zipEntry);
                    byte[] bytes = new byte[1024];
                    int length;
                    while ((length = inputStream.read(bytes)) >= 0) {
                        zipOut.write(bytes, 0, length);
                    }
                }
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
        String sourceFile = ZipADirectory.class.getResource("/").getFile();
        String destinationFile = "./dir-compress.zip";

        create(sourceFile, destinationFile);
    }
}
