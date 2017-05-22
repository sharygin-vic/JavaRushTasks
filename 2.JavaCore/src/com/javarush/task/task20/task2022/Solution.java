package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
        //out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        this.stream = new FileOutputStream(fileName, true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        Solution solution = null;
        try{
            solution = new Solution("c:\\r\\trtrtr-2022.txt");
            solution.writeObject("test test test");

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:\\r\\trtrtr-2022.dat"));
            out.writeObject(solution);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\r\\trtrtr-2022.dat"));
            Solution loadedSolution = (Solution) in.readObject();
            in.close();

            loadedSolution.writeObject("loaded loaded");

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                solution.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
