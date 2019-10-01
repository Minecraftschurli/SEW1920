package gburkl;

/**
 * @author Georg Burkl
 * @version 2019-09-17
 */
public interface Constants {
    String urlRegEx = "(https?://(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?://(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";

    String TITLE = "Word-Trainer";
    String QUESTION = "Which word is displayed below (ENTER to submit)?";

    String CORRECT = "Correct words:";
    String RESET = "Reset";
    String ALL = "Shown words:";
    String ADD_WORD = "Add word";
}
