class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        String[] words = sentence.split(" ");

        for(int i = 0; i < words.length; i ++){
            for(int j = 0; j < searchWord.length(); j ++){
                if(j >= words[i].length()){
                    break;
                }
                if(words[i].charAt(j) != searchWord.charAt(j)){
                    break;
                }
                if(j == searchWord.length() - 1){
                    ans = i + 1;
                }
            }
            if(ans != -1){
                break;
            }
        }
        return ans;
    }
}