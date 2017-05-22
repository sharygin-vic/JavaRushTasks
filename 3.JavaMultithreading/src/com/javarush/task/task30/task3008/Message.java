package com.javarush.task.task30.task3008;

import java.io.Serializable;

/**
 * Created by dell on 01-May-17.
 */
public class Message implements Serializable {
    private final MessageType type;
    private final String data;

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public Message(MessageType type) {
        this.type = type;
        this.data = null;

    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
