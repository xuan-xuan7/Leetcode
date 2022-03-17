import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestWordinDictionary {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) ->  {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);
            }
        });
        int maxLen = 0;
        Map<String, Integer> wordDic = new HashMap<>();
        int n = words.length;
        String ans = "";
        for(int i = 0; i < n; i ++){
            String word = words[i];
            if(word.length() == 1){
                wordDic.put(word, i);
            } else {
                if(wordDic.containsKey(word.substring(0, word.length() - 1))){
                    wordDic.put(word, i);
                }
            }
            if(wordDic.containsKey(word)){
                if(word.length() >= maxLen){ // 排序完后相同长度数组是字典序倒序
                    maxLen = word.length();
                    ans = word;
                }
            }
        }
        return ans;
    }
}
