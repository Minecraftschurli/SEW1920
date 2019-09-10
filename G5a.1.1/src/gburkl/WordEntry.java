package gburkl;

/**
 * @author Georg Burkl
 * @version 2019-09-09
 */
public class WordEntry {
    private static final String urlRegEx = "(https?://(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?://(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";
    private String word;
    private String url;

    /**
     * @param word the Word to set for this Entry
     * @param url the URL to set for this Entry
     */
    public WordEntry(String word, String url){
        this.setWord(word);
        this.setUrl(url);
    }

    /**
     * Gets the word of this {@link WordEntry}
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the word if it is a not empty, non null {@link String}
     * @param word the word to set
     * @throws IllegalArgumentException if the argument word is not correct
     */
    public void setWord(String word) throws IllegalArgumentException {
        if (word == null){
            throw new IllegalArgumentException("Parameter word must not be null");
        } else if (word.length()==0){
            throw new IllegalArgumentException("Parameter word must not be an empty String");
        } else if (word.matches("\\s+")){
            throw new IllegalArgumentException("Parameter word must be a word");
        } else {
            this.word = word.trim();
        }
    }

    /**
     * Gets the url of this {@link WordEntry}
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url if it is a not empty, non null {@link String} and matches a valid url
     * @param url the URL to set
     * @throws IllegalArgumentException if the argument url is not correct
     */
    public void setUrl(String url) throws IllegalArgumentException {
        if (url == null){
            throw new IllegalArgumentException("Parameter url must not be null");
        } else if (url.length()==0){
            throw new IllegalArgumentException("Parameter url must not be an empty String");
        } else if (!url.matches(urlRegEx)) {
            throw new IllegalArgumentException("Parameter url must be a valid URL");
        } else {
            this.url = url;
        }
    }

    /**
     * Gets the {@link String} representation of this {@link WordEntry}
     * @see Object#toString()
     * @return the String representation of this object
     */
    @Override
    public String toString() {
        return this.word+", "+this.url;
    }
}
