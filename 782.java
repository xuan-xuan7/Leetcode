// 行和列的变换是相互独立的，在这种情况下，决定了行和列只能有两种才能最终到合法状态
// 同时，只需要保证第一行和第一列均达到最终状态，整个矩阵即变为最终状态
// 合法性检查：
// 1. 检查行和列的种类是否为两种
// 2. 检测每一行和每一列中的数字数目
// 3. 检测不同状态的行列数的个数
// 求最小交换次数：
// 1. n为偶数，可选择0或者1起始
// 2. n为奇数，此时只有一种合法状态、
// 用32位整数表示一行和一列，采用位运算


class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int rowMask = 0;
        int colMask = 0;

        // get the representation of the first row and column
        for(int i = 0; i < n; i ++){
            rowMask |= (board[0][i] << i);
            colMask |= (board[i][0] << i);
        }
        // XOR for another representation
        int reverseRowMask = ((1 << n) - 1) ^ rowMask;
        int reverseColMask = ((1 << n) - 1) ^ colMask;
        // count numbers of row and column
        int rowCnt = 0;
        int colCnt = 0;
        
        // legitimacy check
        for(int i = 0; i < n; i ++){
            int curRowMask = 0;
            int curColMask = 0;
            for(int j = 0; j < n; j ++){
                curRowMask |= (board[i][j] << j);
                curColMask |= (board[j][i] << j);
            }
            // row type check
            if(curRowMask != rowMask && curRowMask != reverseRowMask){
                return -1;
            } else if(curRowMask == rowMask){
                rowCnt ++;
            }
            // column type check
            if(curColMask != colMask && curColMask != reverseColMask){
                return -1;
            } else if(curColMask == colMask){
                colCnt ++;
            }
        }

        // move and check
        int rowMoves = getMoves(rowMask, rowCnt, n);
        int colMoves = getMoves(colMask, colCnt, n);
        return (rowMoves == -1 || colMoves == -1) ? -1 : (rowMoves + colMoves);
    }

    private int getMoves(int mask, int count, int n){
        // count numbers of 1 in bit number
        int one = Integer.bitCount(mask);
        // n is odd
        if((n & 1) == 1){
            // the different between number of 1 and number of 0 is 1
            // the different between number of row types is 1
            if(Math.abs(n - 2 * one) != 1 || Math.abs(n - 2 * count) != 1){
                return -1;
            }
            // start with 0 or start with 1
            if(one == (n >> 1)){
                // keep 1 in even pesition
                return n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            } else {
                // keep 1 in odd pesition
                return (n + 1) / 2  - Integer.bitCount(mask & 0x55555555);
            }
        } else {
            // number of 1 and number of 1 is equal
            // number of row type is equal
            if(one != (n >> 1) || count != (n >> 1)){
                return -1;
            }
            int count0 = n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            int count1 = n / 2 - Integer.bitCount(mask & 0x55555555);
            return Math.min(count0, count1);
        }
    }
}