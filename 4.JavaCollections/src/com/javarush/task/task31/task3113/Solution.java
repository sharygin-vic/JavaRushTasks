package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathName = reader.readLine();
        reader.close();
        Path path = null;

        try {
            path = Paths.get(pathName);
            path = path.toAbsolutePath();

            if(!Files.isDirectory(path)){
                System.out.println(path.toString() + " - не папка");
                return;
            }
            Visitor visitor = new Solution.Visitor();
            Files.walkFileTree(path, visitor);
            System.out.println("Всего папок - " + visitor.countDirs);
            System.out.println("Всего файлов - " + visitor.countFiles);
            System.out.println("Общий размер - " + visitor.sizeAll);
        }
        catch (InvalidPathException e) {
            System.out.println(path.toString() + " - не папка");
            return;
        }
        catch (NoSuchFileException e) {
            System.out.println(path.toString() + " - не папка");
            return;
        }
    }

    private static class Visitor extends SimpleFileVisitor<Path> {
        int countFiles = 0;
        int countDirs = -1;
        int sizeAll = 0;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (attrs.isDirectory()) {
                countDirs++;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (attrs.isRegularFile()) {
                countFiles++;
                sizeAll += Files.size(file);
            }
            else if (attrs.isDirectory()) {
                countDirs++;
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
