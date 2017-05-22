package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by dell on 09-May-17.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader sr = new StringReader(text);
        try {
            new HTMLEditorKit().read(sr, document, 0);
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter sw = new StringWriter();
        HTMLEditorKit editorKit = new HTMLEditorKit();
        try {
            editorKit.write(sw, document, 0, document.getLength());
        }
        catch (IOException e) {
            ExceptionHandler.log(e);
        }
        catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return sw.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser  = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        jFileChooser.setDialogTitle("Open File");
        int n = jFileChooser.showOpenDialog(view);
        if (n == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try (FileReader fileReader = new FileReader(currentFile))
            {
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {
        if (currentFile == null) {
            saveDocumentAs();
        }
        else {
            view.selectHtmlTab();
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser jFileChooser  = new JFileChooser();
        jFileChooser.setFileFilter(new HTMLFileFilter());
        jFileChooser.setDialogTitle("Save File");
        int n = jFileChooser.showSaveDialog(view);
        if (n == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile))
            {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

}
