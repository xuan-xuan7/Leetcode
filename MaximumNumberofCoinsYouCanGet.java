// 每次选择剩余堆中最多的2堆和最少的1堆

import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        int coin = 0;
        int index = piles.length - 1;

        Arrays.sort(piles);

        for(int i=0; i<index; i++){
            coin += piles[index-1];
            index -= 2;
        }

        return coin;
    }
}
