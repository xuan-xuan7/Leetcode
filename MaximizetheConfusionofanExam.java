// 滑动窗口
// 记录左端点和右端点，用sum记录中间另一种字符的数量
// 当sum>k时左端点右移，返回滑动窗口最大长度

public class MaximizetheConfusionofanExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int sum = 0;
        int n = answerKey.length();
        int maxLen = 0;
        int left = 0;
        int right = 0;
        // T
        for(right = 0; right < n; right ++){
            if(answerKey.charAt(right) == 'F'){
                sum ++;
            }
            while(sum > k){
                left ++;
                if(answerKey.charAt(left) == 'F'){
                    sum --;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        // F
        left = 0;
        sum = 0;
        for(right = 0; right < n; right ++){
            if(answerKey.charAt(right) == 'T'){
                sum ++;
            }
            while(sum > k){
                left ++;
                if(answerKey.charAt(left) == 'T'){
                    sum --;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
