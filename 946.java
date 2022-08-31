import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> tmp = new Stack<>();
        int j = 0;

        for(int i = 0; i < pushed.length; i ++){
            tmp.push(pushed[i]);
            while(!tmp.empty() && tmp.peek() == popped[j]){
                tmp.pop();
                j ++;
            }
        }

        return tmp.empty();
    }
}