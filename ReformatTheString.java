import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String reformat(String s) {
        Queue<Integer> str = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();

        for(int i = 0; i < s.length(); i ++){
            if(Character.isDigit(s.charAt(i))){
                num.offer(i);
            } else {
                str.offer(i);
            }
        }

        int numLen = num.size();
        int strLen = str.size();

        String ans = "";
        if(numLen - strLen == 0){
            for(int i = 0; i < numLen; i ++){
                ans += s.charAt(num.poll());
                ans += s.charAt(str.poll());
            }
        } else if(numLen - strLen == 1){
            for(int i = 0; i < strLen; i ++){
                ans += s.charAt(num.poll());
                ans += s.charAt(str.poll());
            }
            ans += s.charAt(num.poll());
        } else if(strLen - numLen == 1){
            for(int i = 0; i < numLen; i ++){
                ans += s.charAt(str.poll());
                ans += s.charAt(num.poll());
            }
            ans += s.charAt(str.poll());
        }

        return ans;
    }
}