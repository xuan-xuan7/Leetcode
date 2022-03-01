public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int lenPerRow = 0;
        int strLen = s.length();
        int i = 0;
        int cnt = 1;
        while(i < strLen){
            if(cnt < numRows){
                if(cnt == 1){
                    i += numRows;
                } else {
                    i += 1;
                }
                lenPerRow ++;
            } else {
                cnt = 0;
            }
            cnt ++;
        }
        Character[][] str = new Character[numRows][lenPerRow + 1];
        i = 0;
        cnt = 1;
        lenPerRow = 0;
        while(i < strLen){
            if(cnt < numRows){
                if(cnt == 1){
                    for(int k = 0; k < numRows; k ++){
                        if(i + k < strLen){
                            str[k][lenPerRow] = s.charAt(i + k);
                        }
                    }
                    i += numRows;
                } else {
                    str[numRows - cnt][lenPerRow] = s.charAt(i);
                    i ++;
                }
                lenPerRow ++;
            } else {
                cnt = 0;
            }
            cnt ++;
        }
        String ans = "";
        for(int m = 0; m < numRows; m ++){
            for(int n = 0; n < lenPerRow; n ++){
                if(str[m][n] != null){
                    ans += str[m][n];
                }
            }
        }
        return ans;
    }
}
