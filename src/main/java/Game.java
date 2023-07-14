import java.util.ArrayList;
import java.util.List;

public class Game {
    private final static Word word = new Word();
    private final List<String> listDash = new ArrayList<>();
    private List<String> errorLetter = new ArrayList<>();
    private int count;
    private Gallows gallows = new Gallows();
    public void gameLoop(){
        ConsoleMenu consoleMenu = new ConsoleMenu();
        InputLetter inputLetter = new InputLetter();
        createDash();
        boolean winIsOver = true;
        while (winIsOver){
            String letter = inputLetter.input();
            gallows.outGallows();
            menuGame(letter);
            correctLetter(letter);
            winIsOver = winIsLoss();
        }
        consoleMenu.menu();
    }

    private boolean winIsLoss(){
        if(count == 6){
            gallows.outGallows();
            System.out.println("Вы проиграли!");
            return false;
        }
        if(!listDash.contains("_")){
            System.out.println("Вы победили!!!");
            return false;
        }
        return true;
    }
    private List<String> createDash(){
        for (int i = 0; i < word.listLetter().size(); i++) {
            listDash.add("_");
        }
        return listDash;
    }

    private void menuGame(String letter){
        System.out.print("Слово:" );
        listDash.forEach(System.out::print);
        System.out.println();
        System.out.print("Ошибка(" + count + ")");
        outErrorLetter();
        System.out.println();
        System.out.println("Буква: " + letter);
    }

    private void outErrorLetter(){
        for(String s: errorLetter){
            System.out.print(s + " ");
        }
    }

    private void setLetterInDash(int index, String letter){
        listDash.set(index, letter);
    }
    private void correctLetter(String letter){
        if(word.isLetterInWord(letter)){
            setLetterInDash(word.getIndexLetter(letter), letter);
        }else{
            errorLetter.add(letter);
            count++;
            new Gallows(count);
        }
    }

}
