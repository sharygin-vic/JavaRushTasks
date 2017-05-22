package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by dell on 02-May-17.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите IP сервера или 'localhost':");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения.");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                wait();

            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }

        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        }
        else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            String s = ConsoleHelper.readString();
            if ("exit".equals(s)) {
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(s);
            }
        }
    }

    public static void main(String[] args) {
        (new Client()).run();
    }


    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message msg = connection.receive();
                if (msg.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }
                else  if (msg.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message msg = connection.receive();
                if (msg.getType() == MessageType.TEXT) {
                    processIncomingMessage(msg.getData());
                }
                else  if (msg.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(msg.getData());
                }
                else  if (msg.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(msg.getData());
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run() {
            String address = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e) {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
