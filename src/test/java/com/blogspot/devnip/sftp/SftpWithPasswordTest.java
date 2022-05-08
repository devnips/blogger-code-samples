package com.blogspot.devnip.sftp;

import org.apache.commons.vfs2.FileSystemException;
import org.junit.jupiter.api.Assertions;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Sample usage of {@link SftpWithPassword} class
 */
class SftpWithPasswordTest {

    /**
     * Test that all files in movies folder are listed.
     *
     * @throws URISyntaxException
     * @throws FileSystemException
     */
    public void listAllFiles() throws URISyntaxException, FileSystemException {
        List<String> files = SftpWithPassword.connect("localhost", 22, "admin", "password")
                .cd("movies")
                .listFiles();
        Assertions.assertEquals(2, files.size());
    }

}