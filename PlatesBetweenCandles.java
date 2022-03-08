public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] frontPlatesRight = new int[n];
        int[] frontPlateLeft = new int[n];
        int frontPlates = 0;
        for(int i = 0; i < n; i ++){
            if(s.charAt(i) == '*'){
                frontPlates ++;
            }
            frontPlatesRight[i] = frontPlates;
            frontPlateLeft[i] = frontPlates;
        }
        int leftPlates = 0;
        for(int i = 0; i < n; i ++){
            if(s.charAt(i) == '*'){
                frontPlateLeft[i] = leftPlates;
            } else {
                leftPlates = frontPlateLeft[i];
            }
        }
        int rightPlates = 0;
        for(int i = n - 1; i >= 0; i --){
            if(s.charAt(i) == '*'){
                frontPlatesRight[i] = rightPlates;
            } else {
                rightPlates = frontPlatesRight[i];
            }
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i ++){
            if(queries[i][0] == queries[i][1]){
                ans[i] = 0;
                continue;
            }
            ans[i] = frontPlateLeft[queries[i][1]] - frontPlatesRight[queries[i][0]];
            if(ans[i] < 0){
                ans[i] = 0;
            }
        }
        return ans;
    }
}
