package gburkl;

public class Main {
    public static void main(String[] args) {
        int c = 0;
        try {
            WordEntry wrongWord = new WordEntry(null, "google.com");
            c++;
        } catch (IllegalArgumentException ignored){
        }
        try {
            WordEntry wrongWord2 = new WordEntry("", "google.com");
            c++;
        } catch (IllegalArgumentException ignored){
        }
        try {
            WordEntry wrongURL = new WordEntry("Test", null);
            c++;
        } catch (IllegalArgumentException ignored){
        }
        try {
            WordEntry wrongURL = new WordEntry("Test", "");
            c++;
        } catch (IllegalArgumentException ignored){
        }
        try {
            WordEntry wrongURL = new WordEntry("Test", "hi");
            c++;
        } catch (IllegalArgumentException ignored){
        }
        System.out.println(c);
        try {
            WordEntry correct = new WordEntry("Test", "www.google.com");
            c++;
            System.out.println(correct.getUrl());
            c++;
            System.out.println(correct.getWord());
            c++;
            WordList l = new WordList(correct);
            c++;
            l.add(new WordEntry("Hello", "www.tgm.ac.at"));
            c++;
            System.out.println(l.delete("Test"));
            c++;
            l.get(0);
            c++;
            System.out.println(l.toString());
            c++;
            WordTrainer t = new WordTrainer(l);
            c++;
            System.out.println(t.selectRandom());
            c++;
            System.out.println("hello "+t.checkIgnoreCase("hello"));
            c++;
            System.out.println("hi "+t.checkIgnoreCase("hi"));
            c++;
            System.out.println("Hello "+t.check("Hello"));
            c++;
            System.out.println("hello "+t.check("hello"));
            c++;
            System.out.println("hi "+t.check("hi"));
            c++;
            System.out.println(t.getCurrent());
            c++;
            t.getList().add(new WordEntry("Wow", "www.google.com"));
            c++;
            System.out.println(t.getList().toString());
            c++;
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        System.out.println(c);
    }
}
