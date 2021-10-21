//因为先手条件的存在，只有在最后剩4块的时候无法取胜
//通过分析可以知道，只有在上一轮也剩4块的时候无法避免最后剩4块
//则只要是4的倍数就无法获胜

public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
