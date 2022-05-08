package com.blogspot.devnip.sftp;

import org.apache.commons.vfs2.FileName;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.VFS;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static org.apache.commons.vfs2.Selectors.SELECT_FILES;

/**
 * This class uses Apache's VFS project to connect to remote SFTP server using
 * username and password based authentication.
 * <p>
 * Maven Dependency: https://mvnrepository.com/artifact/org.apache.commons/commons-vfs2
 * Apache Commons-VFS Project: https://commons.apache.org/proper/commons-vfs/
 */
public class SftpWithPassword {

    public static final String SFTP = "sftp";

    /**
     * Holds instance of remote SFTP folder.
     */
    private FileObject fileObject;

    /**
     * Direct instantiation not allowed. Use {@link #connect(String, Integer, String, String)}
     * method to initiate connection.
     *
     * @param fileObject
     */
    private SftpWithPassword(FileObject fileObject) {
        this.fileObject = fileObject;
    }

    /**
     * Initiate connection to remote SFTP server
     *
     * @param host
     * @param port
     * @param userName
     * @param password
     * @return
     */
    public static SftpWithPassword connect(String host,
                                           Integer port,
                                           String userName,
                                           String password) throws URISyntaxException, FileSystemException {
        URI sftpUri = createSftpUri(host, port, userName, password);
        return new SftpWithPassword(VFS.getManager().resolveFile(sftpUri.toString()));
    }

    /**
     * Create SFTP URI
     *
     * @param host
     * @param port
     * @param userName
     * @param password
     * @return
     */
    private static URI createSftpUri(String host,
                                     Integer port,
                                     String userName,
                                     String password) throws URISyntaxException {
        String userInfo = userName + ":" + password;
        return new URI(SFTP, userInfo, host, Objects.requireNonNullElse(port, -1), null, null, null);
    }

    /**
     * Navigate to specific folder in SFTP
     *
     * @param folderPath
     * @return
     */
    public SftpWithPassword cd(String folderPath) throws FileSystemException {
        if (this.fileObject == null) {
            throw new RuntimeException("SFTP connection not initiated.");
        }
        FileObject newFolder = this.fileObject.resolveFile(folderPath);
        if (!newFolder.exists() || !newFolder.isFolder()) {
            throw new RuntimeException("Path does not exist or is not a folder.");
        }
        this.fileObject = newFolder;
        return this;
    }

    /**
     * List all file names. Only file names are listed, not the folders.
     *
     * @return
     */
    public List<String> listFiles() throws FileSystemException {
        return ofNullable(this.fileObject.findFiles(SELECT_FILES))
                .map(Arrays::asList)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(FileObject::getName)
                .map(FileName::getBaseName)
                .collect(Collectors.toList());
    }
}
