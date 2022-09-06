package tictactoe;

import java.util.Arrays;

public class Grid {
    char[] x3 = {'X', 'X', 'X'};
    char[] o3 = {'O', 'O', 'O'};
    private final char[] line_repr;
    private boolean move_x = true;

    Grid(String repr) {
        line_repr = repr.toCharArray();
    }
    public char[][] win_lines() {
        return new char[][]{{line_repr[0], line_repr[1], line_repr[2]},
                {line_repr[3], line_repr[4], line_repr[5]},
                {line_repr[6], line_repr[7], line_repr[8]},
                {line_repr[0], line_repr[3], line_repr[6]},
                {line_repr[1], line_repr[4], line_repr[7]},
                {line_repr[2], line_repr[5], line_repr[8]},
                {line_repr[0], line_repr[4], line_repr[8]},
                {line_repr[2], line_repr[4], line_repr[6]}};
    }
    public void printGame() {
        System.out.println("---------");
        System.out.println("| " + line_repr[0] + " " + line_repr[1] + " " + line_repr[2] + " |");
        System.out.println("| " + line_repr[3] + " " + line_repr[4] + " " + line_repr[5] + " |");
        System.out.println("| " + line_repr[6] + " " + line_repr[7] + " " + line_repr[8] + " |");
        System.out.println("---------");
    }
    public boolean new_move(int num1, int num2) {
        if (num1 > 0 && num1 <= 3 && num2 <= 3 && num2 > 0) {
            int pos = (num1 - 1) * 3 + num2 - 1;
            if (line_repr[pos] == '_') {
                if(move_x) {
                    line_repr[pos] = 'X';
                } else {
                    line_repr[pos] = 'O';
                }
                move_x = !move_x;
                return true;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }
        }
        System.out.println("Coordinates should be from 1 to 3!");
        return false;
    }

    public boolean result() {
        if(x_wins()) {
            System.out.println("X wins");
            return true;
        }
        if(o_wins()) {
            System.out.println("O wins");
            return true;
        }
        if(draw()) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
    private boolean x_wins() {
        boolean ans = false;
        for (char[] line: win_lines()) {
            ans |= Arrays.equals(line, x3);
        }
        return ans;
    }
    private boolean o_wins() {
        boolean ans = false;
        for (char[] line: win_lines()) {
            ans |= Arrays.equals(line, o3);
        }
        return ans;
    }
    private boolean draw() {
        boolean ans = false;
        for (char elem: line_repr) {
            ans |= elem == '_';
        }
        return !ans;
    }
}
