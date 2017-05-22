package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dell on 02-May-17.
 */
public class BotClient extends Client {


    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message.contains(":")) {
                String[] pair = message.split(":");
                String userName = pair[0].trim();
                String text = pair[1].trim();
                String fmtStr = null;
                if ("дата".equals(text)) {
                    fmtStr = "d.MM.YYYY";
                }
                else if ("день".equals(text)) {
                    fmtStr = "d";
                }
                else if ("месяц".equals(text)) {
                    fmtStr = "MMMM";
                }
                else if ("год".equals(text)) {
                    fmtStr = "YYYY";
                }
                else if ("время".equals(text)) {
                    fmtStr = "H:mm:ss";
                }
                else if ("час".equals(text)) {
                    fmtStr = "H";
                }
                else if ("минуты".equals(text)) {
                    fmtStr = "m";
                }
                else if ("секунды".equals(text)) {
                    fmtStr = "s";
                }
                else {
                    return;
                }

                SimpleDateFormat fmtDate = new SimpleDateFormat(fmtStr);
                String outText = "Информация для " + userName + ": " + fmtDate.format(new Date().getTime());
                sendTextMessage(outText);
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }
}
