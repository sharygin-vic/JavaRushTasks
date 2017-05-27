package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<Path>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            long fileLength = Files.size(file);
            if (minSize > 0 && !(fileLength > minSize)) return FileVisitResult.CONTINUE;
            if (maxSize > 0 && !(fileLength < maxSize)) return FileVisitResult.CONTINUE;
            if (partOfName != null) {
                if (!file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;
            }
            if (partOfContent != null) {
                if (!new String(Files.readAllBytes(file)).contains(partOfContent)) return FileVisitResult.CONTINUE;
            }

            foundFiles.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }



    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
