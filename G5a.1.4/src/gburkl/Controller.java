package gburkl;

/**
 * @author Georg Burkl
 * @version 2019-09-17
 */
public class Controller {
    private WordTrainer model;
    private Frame frame;

    /**
     *
     */
    public Controller (){
        this.model = new WordTrainer();
        this.frame = new Frame(this, this.model);
    }

    public static void main(String[] args) {
        new Controller();
    }
}
