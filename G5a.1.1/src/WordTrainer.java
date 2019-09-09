/**
 * @author georg burkl
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
     * @return the currently selected {@link WordEntry}
     */
    public WordEntry getCurrent() {
        return this.list.get(this.current);
    }

    /**
     * @param word the word to check
     * @return true if the current word equals the passed word
     */
    public boolean check(String word){
        return this.getCurrent().getWord().equals(word.trim());
    }

    /**
     * @param word the word to check
     * @return true if the current word equals the passed word ignoring the case
     */
    public boolean checkIgnoreCase(String word){
        return this.getCurrent().getWord().toLowerCase().trim().equals(word.toLowerCase().trim());
    }
}
