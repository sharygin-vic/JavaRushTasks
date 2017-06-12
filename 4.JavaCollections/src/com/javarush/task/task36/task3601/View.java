package com.javarush.task.task36.task3601;

/**
 * Created by dell on 13-Jun-17.
 */
public class View {
    private Controller controller;
    {
        controller = new Controller();
        controller.view = this;
    }

    public void fireEventShowData() {
        System.out.println(controller.onDataListShow());
    }
}
