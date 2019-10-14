package gburkl;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * @author Georg Burkl
 * @version 2019-09-17
 */
public class Controller {
    private WordTrainer model;
    private Frame frame;
    private WordTrainerFileRW fileRW;

    /**
     *
     */
    public Controller (){
        this.model = new WordTrainer();
        this.frame = new Frame(this, this.model);
        this.fileRW = new WordTrainerFileRW(this.model);
    }

    /**
     * The main method for the program
     * @param args the calling args
     */
    public static void main(String[] args) {
        new Controller();
    }

    /**
     * Open the save dialog
     * @param actionEvent the calling event
     */
    public void save(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        switch (fileChooser.showSaveDialog(this.frame)) {
            case JFileChooser.APPROVE_OPTION:
                try {
                    this.fileRW.save(fileChooser.getSelectedFile().getPath()+(this.frame.getSaveBinary()?".bin":".txt"), this.frame.getSaveBinary());
                } catch (IOException ignored) {}
                break;
        }
    }

    /**
     * Open the load dialog
     * @param actionEvent the calling event
     */
    public void load(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        switch (fileChooser.showOpenDialog(this.frame)) {
            case JFileChooser.APPROVE_OPTION:
                try {
                    boolean bin = this.frame.getSaveBinary();
                    this.fileRW.load(fileChooser.getSelectedFile().getPath(), bin);
                } catch (IOException | ClassNotFoundException ignored) {}
                break;
        }
    }

    /**
     * Handler for the reset button of the GUI
     * @param actionEvent the calling event
     */
    public void reset(ActionEvent actionEvent) {
        this.model.reset();
    }

    /**
     * Handler for the addWord button of the GUI
     * @param actionEvent the calling event
     */
    public void addWord(ActionEvent actionEvent) {
        this.model.addWord("", "");
    }
}
