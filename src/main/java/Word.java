import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Word {

    private final static Random random = new Random();
    private String secretWord = getListWordIsFile()
            .get(random.nextInt(getListWordIsFile().size()));
    public List<String> listLetter(){
        return List.of(secretWord.split(""));
    }

    private static List<String> getListWordIsFile(){
        File file = new File("src/main/resources/russian_nouns.txt");
        List<String> words = new ArrayList<>();

        try (Scanner sc = new Scanner(file, StandardCharsets.UTF_8))
        {
            while (sc.hasNextLine()) {
                words.add(sc.nextLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }
    public int getIndexLetter(String l){
        int res = 0;
        for (int i = 0; i < listLetter().size(); i++) {
                if(listLetter().get(i).equals(l)){
                res = i;
                break;
            }
        }
        return res;
    }
    public boolean isLetterInWord(String letter){
        boolean s = false;
        for(String list: listLetter()){
            if(list.contains(letter)){
                s = true;
                break;
            }
        }
        return s;
    }
}
