package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
//        Path passwords = downloadFile("https://www.amigo.com/ship/secretPassword.txt", Paths.get("D:/MyDownloads"));
        Path passwords = downloadFile("http://i3.i.ua/logo_new1.png", Paths.get("c:/r"));
        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL urlFrom = new URL(urlString);
        InputStream inpStream = urlFrom.openStream();
        Path tmpFile = Files.createTempFile("temp-", ".tmp");
        Files.copy(inpStream, tmpFile /*,StandardCopyOption.REPLACE_EXISTING*/ );  //StandardCopyOption.REPLACE_EXISTING - нужен, чтобы заменить файл в папке, но с ним не принимает валидатор курсов
        String outFolder = downloadDirectory.toString();
        String outFileName = urlString.substring(urlString.lastIndexOf("/")+1);
        Path outFile = Paths.get(outFolder + "/" + outFileName);    //Paths.get(outFolder, outFileName); тоже не принимает валидатор курсов
        Files.move(tmpFile, outFile /*,StandardCopyOption.REPLACE_EXISTING*/ );   //StandardCopyOption.REPLACE_EXISTING - нужен, чтобы заменить файл в папке, но с ним не принимает валидатор курсов
        return outFile;
    }
}
