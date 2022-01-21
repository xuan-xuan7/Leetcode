public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        long aNum = 1;
        long eNum = 1;
        long iNum = 1;
        long oNum = 1;
        long uNum = 1;
        long aTemp = 0;
        long eTemp = 0;
        long iTemp = 0;
        long oTemp = 0;
        long uTemp = 0;
        int k = 1;
        long sum = 0;
        long mod = 1000000007;

        if(n == 1){
            return 5;
        }

        while(k < n){
            sum = (aNum + 2 * eNum + 4 * iNum + 2 * oNum + uNum) % mod;
            aTemp = (eNum + uNum + iNum) % mod;
            eTemp = (aNum + iNum) % mod;
            iTemp = (eNum + oNum) % mod;
            oTemp = (iNum) % mod;
            uTemp = (iNum + oNum) % mod;
            aNum = aTemp;
            eNum = eTemp;
            iNum = iTemp;
            oNum = oTemp;
            uNum = uTemp;
            k ++;
        }
        return (int) sum;
    }
}
