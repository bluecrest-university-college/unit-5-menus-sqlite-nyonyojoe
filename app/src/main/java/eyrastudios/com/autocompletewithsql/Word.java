package eyrastudios.com.autocompletewithsql;

public class Word {

    private int Id;
    private String correct;
    private String misspelt;

    public Word() {
    }

    public Word(int id, String correct, String misspelt) {
        Id = id;
        this.correct = correct;
        this.misspelt = misspelt;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getMisspelt() {
        return misspelt;
    }

    public void setMisspelt(String misspelt) {
        this.misspelt = misspelt;
    }
}
