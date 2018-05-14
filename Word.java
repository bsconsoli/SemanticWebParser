import java.util.LinkedList;

public class Word {

    private class Relation {
        String word;
        String weight;

        public Relation(String w, String wgt) {
            word = w;
            weight = wgt;
        }
    }
    private String word;
    private LinkedList<Relation> relations = new LinkedList<>();

    public Word (String w){
        word = w;
    }

    public String getWord() {
        return word;
    }

    public void addRelation(String w, String wgt){
        relations.add(new Relation(w, wgt));
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append(word + "|###");
        for(Relation r: relations){
            msg.append(r.word + " (" + r.weight + ")###");
        }
        return msg.toString();
    }
}