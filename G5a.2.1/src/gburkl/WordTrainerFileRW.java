package gburkl;

import java.io.*;

/**
 * @author Georg Burkl
 * @version 2019-10-01
 */
public class WordTrainerFileRW {

    private WordTrainer trainer;

    /**
     * Creates the new {@link WordTrainerFileRW}
     * @param trainer the trainer associated with this {@link WordTrainerFileRW}
     */
    public WordTrainerFileRW(WordTrainer trainer) {
        this.trainer = trainer;
    }

    /**
     * Saves the associated {@link WordTrainer} to the specified path
     * @param path the path to save to
     * @throws IOException -> {@see {@link FileWriter#write(String)}}
     */
    public void save(String path) throws IOException {
        File f = new File(path);
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(this.trainer.toSaveString());
        }
    }

    /**
     * Saves the associated {@link WordTrainer} to the default path
     * @throws IOException -> {@see {@link FileWriter#write(String)}}
     */
    public void save() throws IOException {
        this.save(Constants.DEFAULT_FILE);
    }

    /**
     * Loads the associated {@link WordTrainer}'s values from the specified path
     * @param path the path to load from
     * @throws IOException -> {@see {@link FileReader#read(char[])}}
     */
    public void load(String path) throws IOException {
        File f = new File(path);
        String s = "";
        try (FileReader fr = new FileReader(f)) {
            char[] data = new char[(int) f.length()];
            fr.read(data);
            s = new String(data);
        }
        this.trainer.fromSaveString(s);
    }

    /**
     * Loads the associated {@link WordTrainer}'s values from the default path
     * @throws IOException -> {@see {@link FileReader#read(char[])}}
     */
    public void load() throws IOException {
        this.load(Constants.DEFAULT_FILE);
    }
}
