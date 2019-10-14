package gburkl;

import javax.swing.*;

/**
 * @author Georg Burkl
 * @version 2019-09-17
 */
public class Frame extends JFrame {
    private static final long serialVersionUID = -3471726364075045134L;
    private final JMenuBar menuBar;
    private final JMenu fileMenu;
    private final JMenu gameMenu;
    private final JMenuItem saveFile;
    private final JMenuItem loadFile;
    private final JMenuItem reset;
    private final JMenuItem addWord;
    private final JCheckBoxMenuItem saveBinary;

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
        // region menu-bar
        this.menuBar = new JMenuBar();
        // region file-menu
        this.fileMenu = new JMenu(Constants.FILE_MENU);
        // region save
        this.saveFile = new JMenuItem(Constants.SAVE);
        this.saveFile.addActionListener(this.controller::save);
        this.fileMenu.add(this.saveFile);
        // endregion
        // region load
        this.loadFile = new JMenuItem(Constants.LOAD);
        this.loadFile.addActionListener(this.controller::load);
        this.fileMenu.add(this.loadFile);
        // endregion
        this.saveBinary = new JCheckBoxMenuItem(Constants.SAVE_BINARY);
        this.fileMenu.add(this.saveBinary);
        this.menuBar.add(this.fileMenu);
        // endregion
        //region game-menu
        this.gameMenu = new JMenu(Constants.GAME_MENU);
        //region reset
        this.reset = new JMenuItem(Constants.RESET);
        this.reset.addActionListener(this.controller::reset);
        this.gameMenu.add(this.reset);
        //endregion
        //region add-word
        this.addWord = new JMenuItem(Constants.ADD_WORD);
        this.addWord.addActionListener(this.controller::addWord);
        this.gameMenu.add(this.addWord);
        //endregion
        this.menuBar.add(this.gameMenu);
        //endregion
        this.setJMenuBar(this.menuBar);
        // endregion
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(350,350);
        this.setTitle(Constants.TITLE);
        this.add(this.layout);
        this.setVisible(true);
    }

    /**
     * Gets the state of the saveBinary checkbox
     * @return the state of the saveBinary checkbox
     */
    public boolean getSaveBinary() {
        return this.saveBinary.getState();
    }
}
