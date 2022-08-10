// 遍历，遍历到=时系数变号，相当于把项从左边移到右边

class Solution {
    public String solveEquation(String equation) {
        int x = 0;
        int num = 0;
        int op = 1;
        int n = equation.length();

        char[] s = equation.toCharArray();
        
        for(int i = 0; i < n;){
            if(s[i] == '+'){
                op = 1;
                i ++;
            } else if(s[i] == '-'){
                op = -1;
                i ++;
            } else if(s[i] == '='){
                x *= -1;
                num *= -1;
                op = 1;
                i ++;
            } else {
                int j = i;
                while(j < n && s[j] != '+' && s[j] != '-' && s[j] != '='){
                    j ++;
                }
                if(s[j - 1] != 'x'){
                    num += Integer.parseInt(equation.substring(i, j)) * op;
                } else {
                    x += (i < j - 1) ? Integer.parseInt(equation.substring(i, j - 1)) * op : op;
                }
                i = j;
            }
        }

        if(x == 0 && num == 0){
            return "Infinite solutions";
        } else if(x == 0 && num != 0){
            return "No solution";
        } else {
            return "x=" + (num / -x);
        }
    }
}