import java.text.DecimalFormat;
import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int left = (int) (0.05 * n);
        int right = (int) (0.95 * n);
        double sum = 0;
        for(int i = left; i < right; i ++){
            sum += arr[i];
        }
        return sum / (right - left);
    }
}