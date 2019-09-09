/**
 * @author georg burkl
 * @version 2019-09-09
 */
public class WordEntry {
    private static final String urlRegEx = "(https?://(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?://(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})";
    private String word;
    private String url;

    /**
     * @param word the Word for this Entry
     * @param url the URL for this Entry
     */
    public WordEntry (String word, String url){
        this.setWord(word);
        this.setUrl(url);
    }

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     * @throws IllegalArgumentException if argument word is not correct
     */
    public void setWord(String word) throws IllegalArgumentException {
        if (word == null){
            throw new IllegalArgumentException("Parameter word must not be null");
        } else if (word.length()==0){
            throw new IllegalArgumentException("Parameter word must not be an empty String");
        } else if (word.matches("\\s+")){
            throw new IllegalArgumentException("Parameter word must be a word");
        } else {
            this.word = word;
        }
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the URL to set
     * @throws IllegalArgumentException argument url is not correct
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
     * @return the String representation of this object
     */
    @Override
    public String toString() {
        return this.word+", "+this.url;
    }
}
