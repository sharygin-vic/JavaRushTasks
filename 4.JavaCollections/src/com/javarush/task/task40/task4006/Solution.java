package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        /*  //  vic ->
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String responseLine;

            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        try {
            String host = url.getHost();
            int port = 80;
            Socket socket = new Socket(host, port);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

            printWriter.print("GET "+ url.getFile() + " HTTP/1.1\r\n");
            printWriter.print("Host: "+ host + "\r\n");
//            printWriter.print("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36\r\n");
//            printWriter.print("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n");
//            printWriter.print("Accept-Language: en-us,en;q=0.5\r\n");
//            printWriter.print("Accept-Encoding: gzip,deflate\r\n");
//            printWriter.print("Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7\r\n");
            //printWriter.print("Keep-Alive: 300\r\n");
            //printWriter.print("Connection: keep-alive\r\n");
            //printWriter.print("Cookie: PHPSESSID=r2t5uvjq435r4q7ib3vtdjq120\r\n");
            //printWriter.print("Pragma: no-cache\r\n");
            //printWriter.print("Cache-Control: no-cache\r\n");
            printWriter.print("\r\n");
            printWriter.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String responseLine;
            while ((responseLine = bufferedReader.readLine()) != null) {
                System.out.println(responseLine);
            }

            printWriter.close();
            bufferedReader.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //  <- vic
    }
}