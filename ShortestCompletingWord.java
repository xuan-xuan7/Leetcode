public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] license = new int[26];
        int[] word = new int[26];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        String ans = words[0];
        for(char s: licensePlate.toCharArray()){
            if(Character.isLetter(s)){
                license[Character.toLowerCase(s) - 'a'] ++;
            }
        }
        for(String w: words){
            for(char s: w.toCharArray()) {
                if (Character.isLetter(s)) {
                    word[Character.toLowerCase(s) - 'a']++;
                }
            }
            for(int i = 0; i < 26; i ++){
                if(word[i] < license[i]){
                    sum = Integer.MAX_VALUE;
                    break;
                } else {
                    sum += word[i] - license[i];
                }
            }
            if(sum < min){
                min = sum;
                ans = w;
            }
            sum = 0;
            for(int i = 0; i < 26; i ++){
                word[i] = 0;
            }
        }
        return ans;
    }
}
