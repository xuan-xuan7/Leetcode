import java.util.Stack;

// 用单调栈维护当前位置右边更小的元素，从栈底到栈定元素递增
// 对每个元素，将栈中大于该元素的元素弹出，并将该元素压栈


class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i --){
            if(stack.empty()){
                ans[i] = 0;
                stack.add(prices[i]);
            } else {
                while(!stack.empty() && prices[i] < stack.peek()){
                    stack.pop();
                }
                if(stack.empty()){
                    ans[i] = 0;
                } else {
                    ans[i] = stack.peek();
                }
                stack.add(prices[i]);
            }
            
        }

        for(int i = 0; i < n; i ++){
            ans[i] = prices[i] - ans[i];
        }

        return ans;
    }
}