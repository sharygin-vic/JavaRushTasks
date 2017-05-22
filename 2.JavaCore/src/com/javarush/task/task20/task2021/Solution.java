package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Запрет сериализации
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void readObject(ObjectInputStream is) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void writeObject(ObjectOutputStream os) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
