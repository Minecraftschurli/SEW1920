import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author georg burkl
 * @version 2019-09-09
 */
public class WordList {
    private WordEntry[] entries;

    /**
     *
     */
    public WordList(){
        this.entries = new WordEntry[0];
    }

    /**
     * @param entries values to pre populate the list
     */
    public WordList(WordEntry... entries){
        this.entries = entries;
    }

    /**
     * @param index the list index to get
     * @return the {@link WordEntry} at the specified index
     * @throws IndexOutOfBoundsException if the specified index is not in the list
     */
    public WordEntry get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.entries.length)
            throw new IndexOutOfBoundsException();
        return this.entries[index];
    }

    /**
     * @param word the word to delete
     * @return true if the specified Word got deleted
     * @throws IllegalArgumentException if argument word is not correct
     */
    public boolean delete(String word) throws IllegalArgumentException{
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
                if (this.entries.length - 1 - i >= 0)
                    System.arraycopy(this.entries, i + 1, this.entries, i, this.entries.length - 1 - i);
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * @param entry the {@link WordEntry} to add to the list
     * @throws IllegalArgumentException if argument entry is null
     */
    public void add(WordEntry entry) throws IllegalArgumentException{
        if (entry==null)
            throw new IllegalArgumentException("Parameter entry must not be null");
        final int N = this.entries.length;
        WordEntry[] arr = Arrays.copyOf(this.entries, N + 1);
        arr[N] = entry;
        this.entries = arr;
    }

    /**
     * @return the length of the List
     */
    public int length() {
        return this.entries.length;
    }

    /**
     * @return the String representation of this object
     */
    @Override
    public String toString() {
        return Arrays.stream(this.entries).map(WordEntry::toString).collect(Collectors.joining("\n"));
    }
}
