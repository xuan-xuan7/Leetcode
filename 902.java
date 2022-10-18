class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        // 获取n的位数
        int bitLen = s.length();
        int ans = 0;
        int digitNum = digits.length;
        
        // 在小于n位时的所有可能数字
        for(int i = 1; i < bitLen; i ++){
            ans += Math.pow(digitNum, i);
        }

        // 在等于n位时逐位分析
        wa: for(int i = 1; i <= bitLen; i ++){
            int ch = Character.getNumericValue(s.charAt(i - 1));
            wb: for(int j = 0; j < digitNum; j ++){
                if(Integer.valueOf(digits[j]) < ch){
                    ans += Math.pow(digitNum, bitLen - i);
                    if(j == digitNum - 1){
                        break wa;
                    }
                } else if(Integer.valueOf(digits[j]) == ch){
                    if(i == bitLen){
                        ans ++;
                    }
                    break wb;
                } else {
                    break wa;
                }
            }
        }

        return ans;
    }
}