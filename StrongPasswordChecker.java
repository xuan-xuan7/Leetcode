public class StrongPasswordChecker {
    public int strongPasswordChecker(String password) {
        int isContendUpper = 0;
        int isContendLower = 0;
        int isContendDigit = 0;
        int ans = 0;
        int n = password.length();

        for(int i = 0; i < n; i ++){
            if(Character.isDigit(password.charAt(i))){
                isContendDigit = 1;
            }
            if(Character.isUpperCase(password.charAt(i))){
                isContendUpper = 1;
            }
            if(Character.isLowerCase(password.charAt(i))){
                isContendLower = 1;
            }
        }

        int categories = isContendDigit + isContendUpper + isContendLower;

        // 当字符长度小于6时，操作次数等于6-n和3-(字符种类)两者的较大值
        if(n < 6) {
            ans = Math.max(6 - n, 3 - categories);
        }

        // 当字符长度在6到20之间时，操作次数为替换次数和3-(字符种类)两者的较大值
        if(n >= 6 && n <= 20){
            char ch = ' ';
            int cnt = 0;
            int replace = 0;

            for(int i = 0; i < n; i ++){
                if(ch == password.charAt(i)){
                    cnt ++;
                } else {
                    replace += cnt / 3;
                    cnt = 1;
                    ch = password.charAt(i);
                }
            }
            replace += cnt / 3;
            ans = Math.max(replace, 3 - categories);
        }

        // 对连续k个字符，根据mod值0，1，2，删除操作对替换操作可以产生替代
        // 删除操作为n-20，替换操作要减去删除操作的影响，最后和3-(字符种类)比较
        if(n > 20){
            // 替换次数和删除次数
            int replace = 0, remove = n - 20;
            // k mod 3 = 1 的组数，即删除 2 个字符可以减少 1 次替换操作
            int rm2 = 0;
            int cnt = 0;
            char cur = '#';

            for (int i = 0; i < n; ++i) {
                char ch = password.charAt(i);
                if (ch == cur) {
                    ++cnt;
                } else {
                    if (remove > 0 && cnt >= 3) {
                        if (cnt % 3 == 0) {
                            // 如果是 k % 3 = 0 的组，那么优先删除 1 个字符，减少 1 次替换操作
                            --remove;
                            --replace;
                        } else if (cnt % 3 == 1) {
                            // 如果是 k % 3 = 1 的组，那么存下来备用
                            ++rm2;
                        }
                        // k % 3 = 2 的组无需显式考虑
                    }
                    replace += cnt / 3;
                    cnt = 1;
                    cur = ch;
                }
            }
            if (remove > 0 && cnt >= 3) {
                if (cnt % 3 == 0) {
                    --remove;
                    --replace;
                } else if (cnt % 3 == 1) {
                    ++rm2;
                }
            }
            replace += cnt / 3;

            // 使用 k % 3 = 1 的组的数量，由剩余的替换次数、组数和剩余的删除次数共同决定
            int use2 = Math.min(Math.min(replace, rm2), remove / 2);
            replace -= use2;
            remove -= use2 * 2;
            // 由于每有一次替换次数就一定有 3 个连续相同的字符（k / 3 决定），因此这里可以直接计算出使用 k % 3 = 2 的组的数量
            int use3 = Math.min(replace, remove / 3);
            replace -= use3;
            remove -= use3 * 3;
                ans = (n - 20) + Math.max(replace, 3 - categories);
        }
        return  ans;
    }
}
