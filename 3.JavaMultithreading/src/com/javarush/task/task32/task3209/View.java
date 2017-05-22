package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dell on 09-May-17.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private  JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager= new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        super();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException e) {
            ExceptionHandler.log(e);
        } catch (InstantiationException e) {
            ExceptionHandler.log(e);
        } catch (UnsupportedLookAndFeelException e) {
            ExceptionHandler.log(e);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }


    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Новый" :
                controller.createNewDocument();
                break;
            case "Открыть" :
                controller.openDocument();
                break;
            case "Сохранить" :
                controller.saveDocument();
                break;
            case "Сохранить как..." :
                controller.saveDocumentAs();
                break;
            case "Выход" :
                controller.exit();
                break;
            case "О программе" :
                showAbout();
                break;
        }
    }

    public void init() {
        initGui();
        FrameListener lstnr = new FrameListener(this);
        this.addWindowListener(lstnr);
        setVisible(true);
    }

    public void initMenuBar() {
        JMenuBar mb = new JMenuBar();
        MenuHelper.initFileMenu(this, mb );
        MenuHelper.initEditMenu(this, mb);
        MenuHelper.initStyleMenu(this, mb);
        MenuHelper.initAlignMenu(this, mb);
        MenuHelper.initColorMenu(this, mb);
        MenuHelper.initFontMenu(this, mb);
        MenuHelper.initHelpMenu(this, mb);
        this.getContentPane().add(mb, BorderLayout.NORTH);
    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane scrl1 = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrl1);
        JScrollPane scrl2 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrl2);
        tabbedPane.setPreferredSize(new Dimension(800, 600));
        TabbedPaneChangeListener lsnr = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(lsnr);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void exit() {
        controller.exit();
    }

    public void selectedTabChanged() {
        if (tabbedPane.getSelectedIndex() == 0) {
            controller.setPlainText(plainTextPane.getText());
        }
        else if (tabbedPane.getSelectedIndex() == 1) {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {
        try {
            undoManager.undo();
        }
        catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        }
        catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(new JFrame(), "Java Rush HTML Edtor v0.1", "About", JOptionPane.INFORMATION_MESSAGE);
    }


}
