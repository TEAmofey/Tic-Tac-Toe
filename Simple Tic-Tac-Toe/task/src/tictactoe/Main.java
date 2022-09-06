package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "_________";
        Grid game = new Grid(line);

        game.printGame();
        while (!game.result()) {
            String numbers = scanner.nextLine();
            String[] arr = numbers.split(" ");
            if (arr.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }
            try {
                int num1 = Integer.parseInt(arr[0]);
                int num2 = Integer.parseInt(arr[1]);
                if(game.new_move(num1, num2)) {
                    game.printGame();
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }

        }
    }

}

