package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by dell on 15-May-17.
 */
public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        String s = f.getName().toLowerCase();
        return f.isDirectory() || s.endsWith(".html") || s.endsWith(".htm");
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
