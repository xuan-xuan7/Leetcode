//动态规划
//当前状态f[i]和状态f[i-1]及f[i-2]有关

public class DecodeWays2 {
    public int numDecodings(String s) {
        int length = s.length();
        long[] f = new long[length];
        int i;
        if(length == 0){
            return 1;
        } else {
            if(length == 1){
                f[0] = numberForOne(s.charAt(0));
            } else if(length == 2){
                f[1] = numberForTwo(s.charAt(0), s.charAt(1)) + numberForOne(s.charAt(1)) * numberForOne(s.charAt(0));
            } else {
                f[0] = numberForOne(s.charAt(0));
                f[1] = numberForTwo(s.charAt(0), s.charAt(1));
                for(i=2; i<length; i++){
                    f[i] = numberForOne(s.charAt(i)) * f[i-1] + numberForTwo(s.charAt(i-1), s.charAt(i)) * f[i-2];
                    f[i] = f[i] % 1000000007;
                }
            }
        }
        return (int) f[length-1];
    }

    public int numberForOne(char ch){
        if(ch == '0') {
            return 0;
        } else {
            return ch == '*' ? 9 : 1;
        }
    }

    public int numberForTwo(char chOne, char chTwo){
        if(chOne == '*' && chTwo == '*'){
            return 15;
        } else if(chOne == '*'){
            if(chTwo <= '6'){
                return 2;
            } else {
                return 1;
            }
        } else if(chTwo == '*'){
            if(chOne == '1'){
                return 9;
            } else if(chOne == '2'){
                return 6;
            } else {
                return 0;
            }
        } else {
            if(chOne != '0' && (chOne - '0') * 10 + (chTwo - '0') <= 26){
                return 1;
            } else {
                return 0;
            }
        }
    }
}

