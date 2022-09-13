class Solution {
    public int maximumSwap(int num) {
        char[] charArray = String .valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIndex = n - 1;
        int idx1 = -1;
        int idx2 = -1;

        for(int i = n - 1; i >= 0; i --){
            if(charArray[i] > charArray[maxIndex]){
                maxIndex =  i;
            } else if(charArray[i] < charArray[maxIndex]){
                // 确保是最小的和最大的换
                idx1 = i;
                idx2 = maxIndex;
            }
        }
        if(idx1 >= 0){
            char tmp = charArray[idx1];
            charArray[idx1] = charArray[idx2];
            charArray[idx2] = tmp;
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }
}