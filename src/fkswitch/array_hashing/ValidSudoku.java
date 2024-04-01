package fkswitch.array_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        Map<Character, List<Integer>> boardMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                char val = row[j];
                if (val != '.') {
                    if (!boardMap.containsKey(val)) {
                        boardMap.put(val, new ArrayList<>());
                    }

                    for(int k = 0; k < boardMap.get(val).size(); k++) {
                        int index = boardMap.get(val).get(k);
                        if(index / 9 == i || index % 9 == j || (index / 9 / 3 == i / 3 && index % 9 / 3 == j / 3)) {
                            return false;
                        }
                    }
                    boardMap.get(val).add(i * 9 + j);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(validSudoku.isValidSudoku(board));
    }
}
