package gburkl;

/**
 * @author Georg Burkl
 * @version 2019-09-09
 */
public class WordTrainer {
    private WordList list;
    private int current;


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
        return this.getCurrent().getWord().equals(word.trim());
    }

    /**
     * Checks if the passed word matches the currently selected {@link WordEntry} ignoring the case
     * @param word the word to check
     * @return true if the current word equals the passed word ignoring the case
     */
    public boolean checkIgnoreCase(String word){
        return this.getCurrent().getWord().toLowerCase().trim().equals(word.toLowerCase().trim());
    }
}
