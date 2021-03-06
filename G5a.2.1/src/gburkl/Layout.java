package gburkl;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Georg Burkl
 * @version 2019-09-17
 */
@SuppressWarnings("FieldCanBeLocal")
public class Layout extends JPanel {
    private JLabel question;
    private JTextField input;
    private JLabel image;

    private JLabel correctLabel;
    private JLabel correctNum;
    private JButton reset;

    private JLabel allLabel;
    private JLabel allNum;
    private JButton addWord;


    private JButton saveBtn;
    private JLabel saveLabel;
    private JTextField savePath;

    private JButton loadBtn;
    private JLabel loadLabel;
    private JTextField loadPath;

    /**
     *
     */
    public Layout (){
        this.question = new JLabel(Constants.QUESTION);
        this.input = new JTextField();
        this.image = new JLabel();

        this.correctLabel = new JLabel(Constants.CORRECT);
        this.correctNum = new JLabel("0");
        this.correctNum.setHorizontalAlignment(SwingConstants.CENTER);
        this.reset = new JButton(Constants.RESET);

        this.allLabel = new JLabel(Constants.ALL);
        this.allNum = new JLabel("0");
        this.allNum.setHorizontalAlignment(SwingConstants.CENTER);
        this.addWord = new JButton(Constants.ADD_WORD);

        this.saveBtn = new JButton(Constants.SAVE);
        this.saveLabel = new JLabel(Constants.PATH_LABEL);
        this.saveLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.savePath = new JTextField();

        this.loadBtn = new JButton(Constants.LOAD);
        this.loadLabel = new JLabel(Constants.PATH_LABEL);
        this.loadLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        this.loadPath = new JTextField();

        this.setLayout(new BorderLayout());

        Container c = new Container();
        c.setLayout(new GridLayout(2,1));
        c.add(this.question);
        c.add(this.input);
        this.add(c,BorderLayout.NORTH);

        this.add(this.image,BorderLayout.CENTER);

        Container c1 = new Container();
        c1.setLayout(new GridLayout(4, 3));
        c1.add(this.correctLabel);
        c1.add(this.correctNum);
        c1.add(this.reset);

        c1.add(this.allLabel);
        c1.add(this.allNum);
        c1.add(this.addWord);

        c1.add(this.saveBtn);
        c1.add(this.saveLabel);
        c1.add(this.savePath);

        c1.add(this.loadBtn);
        c1.add(this.loadLabel);
        c1.add(this.loadPath);
        this.add(c1,BorderLayout.SOUTH);
    }

    /**
     * @param isCorrect {@code true} if the checked word was correct
     * @param correct the amount of correct words entered since last reset
     * @param all the amount of words shown since last reset
     */
    public void wordChecked(boolean isCorrect, int correct, int all){
        this.correctNum.setText(""+correct);
        this.allNum.setText(""+all);
    }

    /**
     * @param url the url as {@link String} of the image to display
     * @throws MalformedURLException if url is incorrect
     */
    public void setImg(String url) throws MalformedURLException {
        if(!url.matches(Constants.urlRegEx))
            throw new MalformedURLException("Argument is not a URL-String");
        ImageIcon icon = new ImageIcon(new URL(url));
        Image image = icon.getImage();
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH);
        this.image.setIcon(new ImageIcon(image));
    }
}
