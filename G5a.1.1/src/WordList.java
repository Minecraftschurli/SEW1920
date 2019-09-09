/**
 * @author georg burkl
 * @version 2019-09-09
 */
public class WordList {
    private WordEntry[] entries;

    /**
     * @param index the list index to get
     * @return the {@link WordEntry} at the specified index
     */
    public WordEntry get(int index) {
        return this.entries[index];
    }

    /**
     * @param word the word to delete
     * @return true if the specified Word got deleted
     * @throws IllegalArgumentException if argument word is not correct
     */
    public boolean delete(String word) {
        if (word == null){
            throw new IllegalArgumentException("Parameter word must not be null");
        } else if (word.length()==0){
            throw new IllegalArgumentException("Parameter word must not be an empty String");
        } else if (word.matches("\\s+")){
            throw new IllegalArgumentException("Parameter word must be a word");
        }
        boolean found = false;
        for(int i = 0; i < this.entries.length; i++){
            if(this.entries[i].getWord().equals(word)){
                // shifting elements
                if (this.entries.length - 1 - i >= 0)
                    System.arraycopy(this.entries, i + 1, this.entries, i, this.entries.length - 1 - i);
                found = true;
                break;
            }
        }
        return found;
    }

    public void add(WordEntry entry){

    }
}
