// 如果s2为s1旋转而成，那么s2为s1+s1连接而成字符串的字串

class Solution {
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        String s1New = s1 + s1;
        return s1New.contains(s2);
    }
}