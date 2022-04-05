// 给定的范围不会超过19，在此范围内的质数有：2，3，5，7，11，13，17，19
// 可以用mask=665772的二进制表示这些质数

public class PrimeNumberofSetBitsinBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left; i <= right; i ++){
            if(((1 << Integer.bitCount(i)) & 665772) != 0){
                ++ ans;
            }
        }
        return ans;
    }
}
