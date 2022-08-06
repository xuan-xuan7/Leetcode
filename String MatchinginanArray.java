import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<String>();
        for(int i = 0; i < words.length; i ++){
            for(int j = 0; j < words.length; j ++){
                if(i != j && words[j].contains(words[i])){
                    if(!ans.contains(words[i])){
                        ans.add(words[i]);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}