package com.javarush.task.task38.task3805;

/* 
Улучшения в Java 7 (multiple exceptions)
*/

public class Solution {
    private final Connection connection;

    public Solution() throws SolutionException {
        try {
            connection = new ConnectionMock();
            connection.connect();
        }
        //  vic  ->
        //catch (WrongDataException e) {
        //    throw new SolutionException("WrongDataException: " + e.getMessage());
        //}
        //catch (ConnectionException e) {
        //    throw new SolutionException("ConnectionException: " + e.getMessage());
        //}
        catch (WrongDataException | ConnectionException e) {
            throw new SolutionException("WrongDataException | ConnectionException: " + e.getMessage());
        }
        //    <- vic
    }

    public void write(Object data) throws SolutionException {
        try {
            connection.write(data);
        }
        //  vic  ->
        //catch (WrongDataException e) {
        //    throw new SolutionException("WrongDataException: " + e.getMessage());
        //}
        //catch (ConnectionException e) {
        //    throw new SolutionException("ConnectionException: " + e.getMessage());
        //}
        catch (WrongDataException | ConnectionException e) {
            throw new SolutionException("WrongDataException | ConnectionException: " + e.getMessage());
        }
        //    <- vic
    }

    public Object read() throws SolutionException {
        try {
            return connection.read();
        }
        //  vic  ->
        //catch (WrongDataException e) {
        //    throw new SolutionException("WrongDataException: " + e.getMessage());
        //}
        //catch (ConnectionException e) {
        //    throw new SolutionException("ConnectionException: " + e.getMessage());
        //}
        catch (WrongDataException | ConnectionException e) {
            throw new SolutionException("WrongDataException | ConnectionException: " + e.getMessage());
        }
        //    <- vic
    }

    public void disconnect() throws SolutionException {
        try {
            connection.disconnect();
        }
        //  vic  ->
        //catch (WrongDataException e) {
        //    throw new SolutionException("WrongDataException: " + e.getMessage());
        //}
        //catch (ConnectionException e) {
        //    throw new SolutionException("ConnectionException: " + e.getMessage());
        //}
        catch (WrongDataException | ConnectionException e) {
            throw new SolutionException("WrongDataException | ConnectionException: " + e.getMessage());
        }
        //    <- vic
    }

    public static void main(String[] args) {

    }
}
