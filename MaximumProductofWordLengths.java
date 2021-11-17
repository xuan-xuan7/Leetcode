// 位运算

public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] wordIndex = new int[n];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < words[i].length(); j ++){
                wordIndex[i] = wordIndex[i] | (1 << words[i].charAt(j) - 'a');
            }
        }

        int maxLen = 0;
        for(int i = 0; i < n; i ++){
            for(int j = i + 1; j < n; j ++){
                if((wordIndex[i] & wordIndex[j]) == 0){
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }

        return maxLen;
    }
}
