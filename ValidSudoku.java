import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int i, j, block;
        Set[] row = new Set[9];
        for(i=0; i<9; i++){
            row[i] = new HashSet();
        }
        Set[] col = new Set[9];
        for(i=0; i<9; i++){
            col[i] = new HashSet();
        }
        Set[] cube = new Set[9];
        for(i=0; i<9; i++){
            cube[i] = new HashSet();
        }
        for(i=0; i<9; i++){
            for(j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(row[i].contains(board[i][j])){
                        return false;
                    } else {
                        row[i].add(board[i][j]);
                    }
                    if(col[j].contains(board[i][j])){
                        return false;
                    } else {
                        col[j].add(board[i][j]);
                    }
                    if(i/3 == 0){
                        block = i/3 + j/3;
                    } else if(i/3 == 1){
                        block = i/3 + j/3 + 2;
                    } else {
                        block = i/3 + j/3 +4;
                    }
                    if(cube[block].contains(board[i][j])){
                        return false;
                    } else {
                        cube[block].add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] arg){
        ValidSudoku s = new ValidSudoku();
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        boolean result;
        result = s.isValidSudoku(board);
        System.out.println(result);
    }
}

