import java.util.Stack;

// 多压入一个0代表该'('内的数值，并更新该数值

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();

        stack.push(0);
        for(int i = 0; i < n; i ++){
            Character ch = s.charAt(i);
            if(ch == '('){
                stack.push(0);
            } else {
                int v = stack.pop();
                int top = stack.pop() + Math.max(2 * v, 1);
                stack.push(top);
            }
        }

        return stack.peek();
    }
}