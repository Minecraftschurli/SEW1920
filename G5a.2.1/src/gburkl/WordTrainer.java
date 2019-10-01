package gburkl;

import java.util.Arrays;

/**
 * @author Georg Burkl
 * @version 2019-09-09
 */
public class WordTrainer {
    private WordList list;
    private int current;
    private int checked;
    private int correct;


    /**
     *
     */
    public WordTrainer(){
        this(new WordList());
    }

    /**
     * @param list {@link WordList} to set
     */
    public WordTrainer(WordList list){
        this.list = list;
        this.selectRandom();
    }

    /**
     * Sets the currently selected {@link WordEntry} to a random index in the {@link WordList}'s range and returns it
     * @return a randomly selected {@link WordEntry} from the {@link WordList}
     */
    public WordEntry selectRandom(){
        int i = (int) Math.floor(Math.random() * (this.list.length()-1));
        if (i < 0){
            return null;
        }
        return this.select(i);
    }

    /**
     * Sets the currently selected {@link WordEntry} to the specified index if the index is in the {@link WordList}'s range and returns it
     * @param index the index to select
     * @return the selected {@link WordEntry}
     * @throws IndexOutOfBoundsException if the index is not in the list
     */
    protected WordEntry select(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.list.length())
            throw new IndexOutOfBoundsException();
        this.current = index;
        return this.getCurrent();
    }

    /**
     * Gets the currently selected {@link WordEntry}
     * @return the currently selected {@link WordEntry}
     */
    public WordEntry getCurrent() {
        return this.list.get(this.current);
    }

    /**
     * Gets the {@link WordList} associated with this {@link WordTrainer}
     * @return the {@link WordList} associated with this {@link WordTrainer}
     */
    public WordList getList() {
        return list;
    }

    /**
     * Checks if the passed word matches the currently selected {@link WordEntry}
     * @param word the word to check
     * @return true if the current word equals the passed word
     */
    public boolean check(String word){
        this.checked++;
        if (this.getCurrent().getWord().equals(word.trim())){
            this.correct++;
            return true;
        }
        return false;
    }

    /**
     * Checks if the passed word matches the currently selected {@link WordEntry} ignoring the case
     * @param word the word to check
     * @return true if the current word equals the passed word ignoring the case
     */
    public boolean checkIgnoreCase(String word){
        this.checked++;
        if (this.getCurrent().getWord().toLowerCase().trim().equals(word.toLowerCase().trim())){
            this.correct++;
            return true;
        }
        return false;
    }

    public void reset(){
        this.checked = 0;
        this.correct = 0;
    }

    /**
     * Gets the number of check requests
     * @return the number of check requests
     */
    public int getChecked() {
        return checked;
    }

    /**
     * Gets the number of correct words
     * @return the number of correct words
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * Returns this object as a JSON String
     * @return the JSON String
     */
    public String toSaveString() {
        StringBuilder b = new StringBuilder();
        b.append(this.current)
                .append(",")
                .append(this.checked)
                .append(",")
                .append(this.correct)
                .append(System.lineSeparator())
                .append(System.lineSeparator());
        b.append(this.list.toSaveString());
        return b.toString();
    }

    /**
     * Sets internal values from save-string
     * @param s the save-string
     */
    public void fromSaveString(String s) {
        String[] data = s.split(System.lineSeparator());
        String[] tData = data[0].split(",");
        this.current = Integer.parseInt(tData[0]);
        this.checked = Integer.parseInt(tData[1]);
        this.correct = Integer.parseInt(tData[2]);

        this.list.fromSaveString(Arrays.copyOfRange(data, 2, data.length));
    }
}
