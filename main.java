import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class main {

    // TODO: 14/05/18 Make main function

    public static void parseConceptNetDataDump(String corpXML) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(corpXML), "UTF-8"))) {
            String line;
            ArrayList<Word> words = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if (line.contains("/r/IsA")){
                    int indexWord = line.indexOf("surfaceStart");
                    int indexWordInit = line.indexOf('"', indexWord+13);
                    int indexWordFin = line.indexOf('"', indexWordInit+1);
                    String word = line.substring(indexWordInit+1, indexWordFin);
                    // TODO: 14/05/18 Check if word already in array
                    int indexRelationWord = line.indexOf("surfaceEnd");
                    int indexRelationWordInit = line.indexOf('"', indexRelationWord+10);
                    int indexRelationWordFin = line.indexOf('"', indexRelationWordInit+1);
                    String relationWord = line.substring(indexRelationWordInit+1, indexRelationWordFin);
                    int indexRelationWeight = line.indexOf("weight");
                    int indexRelationWeightInit = line.indexOf(" ", indexRelationWeight);
                    int indexRelationWeightFin = line.indexOf("}",indexRelationWeightInit);
                    String relationWeight = line.substring(indexRelationWeightInit+1,indexRelationWeightFin);
                    Word newWord = new Word(word);
                    newWord.addRelation(relationWord, relationWeight);
                    words.add(newWord);
                }
            }
            // TODO: 14/05/18 Make TXT writer and write array list into txt
        } catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

}
