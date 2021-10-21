import java.util.HashMap;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans = new StringBuilder();
        long mod;
        long res;
        HashMap<Long, Integer> loop = new HashMap<Long, Integer>();
        int count;

        if(numerator == 0){
            return "0";
        }

        // 是否是负数
        if(numerator < 0 ^ denominator < 0){
            ans.append("-");
        }

        // 整数部分
        res = numerator / denominator;
        if(res < 0){
            res = -res;
        }
        mod = numerator % denominator;
        ans.append(res);
        if(mod != 0){
            ans.append(".");
        }
        count = ans.length();
        int flag = 0;

        // 小数部分
        while(mod != 0){
            count ++;
            if(!loop.containsKey(mod)){
                loop.put(mod, count);
            } else {
                flag = 1;
                break;
            }
            mod = mod * 10;
            res = (int) (mod / denominator);
            if(res < 0){
                res = -res;
            }
            mod = mod %denominator;
            ans.append(res);
        }

        //添加括号
        if(flag == 1){
            int start = loop.get(mod);
            int end = count - 1;
            ans.insert(start - 1, "(");
            ans.insert(end + 1, ")");
        }

        return ans.toString();
    }

}
