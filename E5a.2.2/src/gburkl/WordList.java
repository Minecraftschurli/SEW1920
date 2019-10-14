package gburkl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Georg Burkl
 * @version 2019-09-09
 */
public class WordList implements Serializable {
    private static final long serialVersionUID = -968295287166859713L;
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
     * Gets the {@link WordEntry} at the specified index if the index is in this {@link WordList}
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
     * Deletes the {@link WordEntry} matching the given word if it is not null and a valid word
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
     * Adds a passed {@link WordEntry} to this {@link WordList} if it's not null
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
     * Gets the number of {@link WordEntry}s of this {@link WordList}
     * @see Object#toString()
     * @return the length of the List
     */
    public int length() {
        return this.entries.length;
    }

    /**
     * Gets the {@link String} representation of this {@link WordList}
     * @return the String representation of this object
     */
    @Override
    public String toString() {
        return Arrays.stream(this.entries).map(WordEntry::toString).collect(Collectors.joining("\n"));
    }

    /**
     * Returns this object as a JSON String
     * @return the JSON String
     */
    public String toSaveString() {
        StringBuilder b = new StringBuilder();
        for (WordEntry e : this.entries) {
            b.append(e.toSaveString()).append(System.lineSeparator());
        }
        return b.toString();
    }

    /**
     * Sets internal values from save-string
     * @param data the save-string
     */
    public void fromSaveString(String[] data) {
        WordEntry[] entries = new WordEntry[data.length];
        for (int i = 0; i < data.length; i++) {
            String[] s = data[i].split(",");
            entries[i] = new WordEntry(s[0], s[1]);
        }
        this.entries = entries;
    }
}
