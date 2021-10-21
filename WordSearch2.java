import java.util.*;

//要点1：迭代搜索
//要点2：不成功路径标志位要回溯


class WordSearch2 {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, ArrayList<int[]>> alpha = new HashMap<>();
        int i = 0;
        int j;
        int m = board.length;
        int n = board[0].length;
        for(; i<m; i++){
            for(j=0; j<n; j++){
                if(alpha.containsKey(board[i][j])){
                    ArrayList<int[]> where;
                    where = alpha.get(board[i][j]);
                    where.add(new int[] {i, j});
                    alpha.put(board[i][j], where);
                }else{
                    ArrayList<int[]> where = new ArrayList<>();
                    where.add(new int[] {i, j});
                    alpha.put(board[i][j], where);
                }
            }
        }
        int wordLen = words.length;
        String ch;
        char[] str;
        int size, x, y;
        for(i=0; i<wordLen; i++){
            ch = words[i];
            str = ch.toCharArray();
            if(alpha.containsKey(str[0])){
                ArrayList<int[]> where;
                where = alpha.get(str[0]);
                size = where.size();
                for(j=0; j<size; j++){
                    x = where.get(j)[0];
                    y = where.get(j)[1];
                    int[][] flag = new int[m][n];
                    for(int a=0; a<m; a++){
                        for(int b=0; b<n; b++){
                            flag[a][b] = 0;
                        }
                    }
                    searchStep(x, y, flag, str, 0, board);
                    for(int a=0; a<m; a++){
                        for(int b=0; b<n; b++){
                            flag[a][b] = 0;
                        }
                    }
                }
            }
        }
        return result;
    }

    public Boolean searchStep(int x, int y, int[][] flag, char[] str, int index, char[][] board){
        if(str[index] != board[x][y]) {
            return Boolean.FALSE;
        } else {
            if(index == str.length-1){
                String re;
                re = String.valueOf(str);
                if(!result.contains(re)) {
                    result.add(re);
                }
                return Boolean.TRUE;
            } else {
                Boolean res = Boolean.FALSE;
                index++;
                flag[x][y] = 1;
                for(int[] dir: dirs){
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if(i>=0 && i<flag.length && j>=0 && j<flag[0].length && flag[i][j]!=1){
                        res = searchStep(i, j, flag, str, index, board);
                    }
                }
                if(!res){
                    flag[x][y] = 0;
                }
                return Boolean.FALSE;
            }
        }
    }

    public static void main(String[] arg){
        WordSearch2 s = new WordSearch2();
        List<String> result;
        char[][] board = {{'a','b','c'},{'a','e','d'},{'a','b','g'}};
        String[] words = {"abcdefg","gfedcbaaa","eaabcdgba","befa","dgc","ade"};
        result = s.findWords(board, words);
        System.out.println(result);
    }
}