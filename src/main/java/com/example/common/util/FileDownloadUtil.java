package com.example.common.util;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class FileDownloadUtil {
    private Path foundFile;
    private static final String UPLOAD_FOLDER = "/Users/mahimatripathi/Downloads/postgres/src/main/resources/image/"; // Replace with the actual upload folder path

    public Resource getFileAsResource(String fileCode) throws IOException {
        Path dirPath = Paths.get(UPLOAD_FOLDER);

        Files.list(dirPath).forEach(file -> {
            if (file.getFileName().toString().startsWith(fileCode)) {
                foundFile = file;
                return;
            }
        });

        if (foundFile != null) {
            return new UrlResource(foundFile.toUri());
        }

        return null;
    }
}