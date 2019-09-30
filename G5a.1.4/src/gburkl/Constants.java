package gburkl;

/**
 * @author Georg Burkl
 * @version 2019-09-17
 */
public class Constants {
    public static final String urlRegEx = "(https?://(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?://(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";

    public static final String TITLE = "Word-Trainer";
    public static final String QUESTION = "Which word is displayed below (ENTER to submit)?";

    public static final String CORRECT = "Correct words:";
    public static final String RESET = "Reset";
    public static final String ALL = "Shown words:";
    public static final String ADD_WORD = "Add word";
}
