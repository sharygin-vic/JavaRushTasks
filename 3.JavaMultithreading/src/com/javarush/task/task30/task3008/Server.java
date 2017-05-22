package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dell on 01-May-17.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        int portServer = ConsoleHelper.readInt();
        //serverSocket = null;
        try (
                ServerSocket serverSocket = new ServerSocket(portServer);
        ){
            System.out.println("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                (new Handler(socket)).start();
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    static public void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> item : connectionMap.entrySet()) {
            try {
                item.getValue().send(message);
            }
            catch (IOException e) {
                System.out.println("Ошибка отправки. Сообщение: [" + message + "],  клиент: [" + item.getKey() + "]");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        private Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String clientName = "";
            boolean ok = false;
            while (!ok) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message inMsg = connection.receive();
                if (!(inMsg.getType() == MessageType.USER_NAME)) {
                    continue;
                }
                clientName = inMsg.getData();
                if ("".equals(clientName) || connectionMap.containsKey(clientName)) {
                    continue;
                }
                connectionMap.put(clientName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                ok = true;
            }

            return clientName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> item : connectionMap.entrySet()) {
                String name = item.getKey();
                if (!name.equals(userName)) {
                    Message msg = new Message(MessageType.USER_ADDED, name);
                    //item.getValue().send(msg);
                    connection.send(msg);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message inMsg = connection.receive();
                if (inMsg.getType() == MessageType.TEXT) {
                    Message outMsg = new Message(MessageType.TEXT, userName + ": " + inMsg.getData());
                    sendBroadcastMessage(outMsg);
                }
                else {
                    System.out.println("Ошибка получения текста. Клиент: [" + userName + "], MessageType: " + inMsg.getType());
                }
            }
        }

        public void run() {
            //InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            //System.out.println("Установлено новое соединение с удаленным адресом - " + socketAddress.getAddress() + ":" + socketAddress.getPort());
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            System.out.println("Установлено новое соединение с удаленным адресом " + socketAddress);
            String userName = null;
            try (Connection connection = new Connection(socket);)
            {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);

            }
            catch (IOException e) {
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом.");
                //delUser(userName);
            }
            catch (ClassNotFoundException e) {
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом.");
                //delUser(userName);
            }
            finally {
                delUser(userName);
                System.out.println("Соединение с удаленным адресом закрыто.");
            }

        }

        private void delUser(String userName) {
            if (userName != null) {
                if (connectionMap.containsKey(userName)) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
        }

    }
}
