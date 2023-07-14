import java.util.Scanner;

public class ConsoleMenu {
    private final Scanner scanner = new Scanner(System.in);

    public void menu(){
        Game game = new Game();
        boolean s = true;
        while (s){
            System.out.println("1. Новая игра");
            System.out.println("2. Выход");
            if(input() == 1){
                game.gameLoop();
            }else s = false;
        }

    }

    private int input(){
        while (true) {
            System.out.println("Введите пожалуйста цифру 1 или 2");
            String number = scanner.nextLine();
            if(number.isEmpty()){
                System.out.println("Нужно ввести хотя бы один символ!");
                continue;
            }
            if (!Character.isDigit(number.charAt(0))) {
                System.out.println("Можно ввести только цифру");
                continue;
            }
            if(Integer.parseInt(number) > 2 || Integer.parseInt(number) < 0){
                System.out.println("Цифра должна быть 1 или 2");
                continue;
            }
            return Integer.parseInt(number);
        }
    }
}
