import java.util.Scanner;

public class InputLetter {
    private final static Scanner scanner = new Scanner(System.in);

    public String input(){
        while (true){
            System.out.println("Введите одну букву");
            String line = scanner.nextLine();
            if(!line.matches("[а-яА-я]+")){
                System.out.println("Можно ввести только русскую букву");
                continue;
            }

            if(line.length() != 1){
                System.out.println("Можно ввести только одну букву");
                continue;
            }

            return line;
        }

    }
}
