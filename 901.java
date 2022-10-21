import java.util.Stack;

// 单调栈

class StockSpanner {

    Stack<int[]> stack;
    int cnt;

    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        cnt = -1;
    }
    
    public int next(int price) {
        cnt  ++;
        while(price >= stack.peek()[1]){
            stack.pop();
        }
        int day = cnt - stack.peek()[0];
        stack.push(new int[]{cnt, price});
        return day;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */