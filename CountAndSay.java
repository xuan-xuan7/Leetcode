public class CountAndSay {
    public String countAndSay(int n) {
        String ans = countNum(n);
        return ans;
    }

    public String countNum(int k){
        if(k == 1){
            return "1";
        } else {
            String s = countNum(k - 1);
            String ans = "";
            int count = 0;
            char pre = s.charAt(0);
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == pre){
                    count ++;
                } else {
                    ans += Integer.toString(count);
                    ans += pre;
                    pre = s.charAt(i);
                    count = 1;
                }
            }
            ans += Integer.toString(count);
            ans += pre;
            return ans;
        }
    }
}
