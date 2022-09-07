import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reorderSpaces(String text) {
        String[] str = text.trim().split("\\s+");
        int space = 0;
        
        for(int i = 0; i < text.length(); i ++){
            if(text.charAt(i) == ' '){
                space ++;
            }    
        }

        int n = str.length;
        int mid;
        int end;
        if(n == 1){
            mid = 0;
            end = space;
        } else {
            mid = space / (n - 1);
            end = space % (n - 1);
        }
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n - 1; i ++){
            ans.append(str[i]);
            for(int j = 0; j < mid; j ++){
                ans.append(" ");
            }
        }
        ans.append(str[n - 1]);
        for(int i = 0; i < end; i ++){
            ans.append(" ");
        }
        return ans.toString();
    }
}