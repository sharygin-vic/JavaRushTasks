package com.javarush.task.task38.task3804;

/**
 * Created by dell on 08-Jul-17.
 */
public class ExceptionFactory {
    public static Throwable getExceptionClass(Enum exceptionType) {
        if (exceptionType == ExceptionApplicationMessage.UNHANDLED_EXCEPTION) {
            return new Exception("Unhandled exception");
        }
        else if (exceptionType == ExceptionApplicationMessage.SOCKET_IS_CLOSED) {
            return new Exception("Socket is closed");
        }
        else if (exceptionType == ExceptionDBMessage.NOT_ENOUGH_CONNECTIONS) {
            return new RuntimeException("Not enough connections");
        }
        else if (exceptionType == ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT) {
            return new RuntimeException("Result has not gotten because of timeout");
        }
        else if (exceptionType == ExceptionUserMessage.USER_DOES_NOT_EXIST) {
            return new Error("User does not exist");
        }
        else if (exceptionType == ExceptionUserMessage.USER_DOES_NOT_HAVE_PERMISSIONS) {
            return new Error("User does not have permissions");
        }
        else {
            return new IllegalArgumentException();
        }
    }
}
