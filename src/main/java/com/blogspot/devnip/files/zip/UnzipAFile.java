package com.blogspot.devnip.files.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Unzip a compressed zip file
 */
public class UnzipAFile {

    /**
     * Unzip a zip file to given destination folder.
     *
     * @param zipFile
     * @param destinationDirectory
     * @throws IOException
     */
    private static void unzip(String zipFile, String destinationDirectory) throws IOException {
        File destDir = new File(destinationDirectory);

        //create destination directory if missing.
        destDir.mkdirs();

        byte[] buffer = new byte[1024];

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry zipEntry = zis.getNextEntry();

            // iterate over each entry.
            while (zipEntry != null) {
                File newFile = new File(destDir, zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    // if entry is a directory simply create the directory
                    newFile.mkdirs();
                } else {
                    // write file content
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
    }

    /**
     * Execution method for testing. Compressed file is created in base folder of this repository
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String fileZip = UnzipAFile.class.getResource("/zip/dir-compress.zip").getFile();
        String destinationDirectory = "./unzip-test";

        unzip(fileZip, destinationDirectory);
    }
}
