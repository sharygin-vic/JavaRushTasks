package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by dell on 11-Jul-17.
 */
public class HtmlView implements View {
    private final String filePath = "./src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        return null;
    }

    private void updateFile(String fileContent) {
        try (
                //BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get(filePath).toAbsolutePath().normalize().toFile()))

                // for debug:
                //BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get(filePath).getFileName().toAbsolutePath().toFile()))

                // for JavaRush validation !!!!!!!!!!!!!!!!!!!!!!! :
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))
        ) {
            writer.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
