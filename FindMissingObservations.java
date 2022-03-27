public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int cnt = m + n;
        int sum = mean * cnt;
        int sumRoll = 0;
        for(int i = 0; i < m; i ++){
            sumRoll += rolls[i];
        }
        int sumMiss = sum - sumRoll;
        int meanMiss = sumMiss / n;
        int modMiss = sumMiss % n;
        if(meanMiss > 6 || meanMiss <= 0){
            return new int[]{};
        }
        if(meanMiss == 6 && modMiss > 0){
            return new int[]{};
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i ++){
            ans[i] = meanMiss;
        }
        if(modMiss > 0){
            for(int i = 0; i < modMiss; i ++){
                ans[i] ++;
            }
        }
        return ans;
    }
}
