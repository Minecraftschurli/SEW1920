package gburkl;

import javax.swing.*;

/**
 * @author Georg Burkl
 * @version 2019-09-17
 */
public class Frame extends JFrame {
    private Controller controller;
    private Layout layout;
    private WordTrainer model;

    /**
     * @param c the {@link Controller} for this gui
     * @param t the {@link WordTrainer} displayed in this gui
     */
    public Frame (Controller c, WordTrainer t){
        this.model = t;
        this.controller = c;
        this.layout = new Layout();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(350,350);
        this.setTitle(Constants.TITLE);
        this.add(this.layout);
        this.setVisible(true);
    }
}
