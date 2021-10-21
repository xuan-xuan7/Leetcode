// 回溯，n个数字一共有n-1个间隙，每一个间隙可以插入空、+、-、*之中的一个
// 若添加*号，则res减少mul加上mul*val
// expr表示当前表达式，i表示当前位置，res表示当前值，mul表示最后一个连乘串的计算结果

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    int n;
    String num;
    int target;
    List<String> ans;

    public List<String> addOperators(String num, int target) {
        this.n = num.length();
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<String>();
        StringBuffer expr = new StringBuffer();
        operator(expr, 0, 0, 0);
        return ans;
    }

    public void operator(StringBuffer expr, int i, long res, long mul){
        if(i == n){
            if(res == target){
                ans.add(expr.toString());
            }
            return;
        }
        int index = expr.length();
        if(i > 0){
            expr.append(0);
        }
        long val = 0;
        for(int j = i; j < n && (j == i || num.charAt(i) != '0'); j ++){
            val = val * 10 + num.charAt(j) - '0';
            //枚举截取的数字长度（取多少位），注意数字可以是单个 0 但不能有前导零
            expr.append(num.charAt(j));
            if(i == 0){
                operator(expr, j+1, val, val);
                // 不能添加符号
            } else {
                expr.setCharAt(index, '+');
                operator(expr, j+1, res + val, val);
                expr.setCharAt(index, '-');
                operator(expr, j+1, res - val, -val);
                expr.setCharAt(index, '*');
                operator(expr, j+1, res - mul + mul * val, mul * val);
            }
        }
        expr.setLength(index);
    }
}
