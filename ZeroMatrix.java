// 只用一个flag记录第一列是否有0
// 第一列的第一个元素就能够代表第一行是否有0
// 用第一行和第一列记录每行和每列有0的情况
// 这样只用到1个标记位的额外空间
// 但为了防止每列第一个元素（即第一行最后更新）提前被更新，需要从最后一行开始遍历

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagCol0 = false;
        for(int i = 0; i < m; i ++){
            if(matrix[i][0] == 0){
                flagCol0 = true;
            }
            for(int j = 1; j < n; j ++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = m - 1; i >= 0; i --){
            for(int j = 1; j < n; j ++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if(flagCol0){
                matrix[i][0] = 0;
            }
        }
    }
}