class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int cnt = 0;
        Character a = ' ';
        Character b = ' ';


        for(int i = 0; i < n; i ++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt ++;
                if(cnt == 1){
                    a = s1.charAt(i);
                    b = s2.charAt(i);
                }
                if(cnt == 2){
                    if(s1.charAt(i) != b || s2.charAt(i) != a){
                        return false;
                    }
                }
            }
        }
        if(cnt == 0 || cnt == 2){
            return true;
        }
        return false;
    }
}