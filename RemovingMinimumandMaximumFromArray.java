public class RemovingMinimumandMaximumFromArray {
    public int minimumDeletions(int[] nums) {
        int maxIndex = 0;
        int minIndex = 0;
        int op = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
        }

        int maxToFront = maxIndex + 1;
        int minToFront = minIndex + 1;
        int maxToEnd = nums.length - maxIndex;
        int minToEnd = nums.length - minIndex;
        int min = maxToFront;

        if(min > minToFront){
            min = minToFront;
        }
        if(min > maxToEnd){
            min = maxToEnd;
        }
        if(min > minToEnd){
            min = minToEnd;
        }

        if(min == maxToFront){
            op += min;
            minToFront = minToFront - maxToFront;
            if(minToFront < minToEnd){
                return op + minToFront;
            } else {
                return op + minToEnd;
            }
        } else if(min == maxToEnd){
            op += min;
            minToEnd = minToEnd - maxToEnd;
            if(minToFront < minToEnd){
                return op + minToFront;
            } else {
                return op + minToEnd;
            }
        } else if(min == minToFront){
            op += min;
            maxToFront = maxToFront - minToFront;
            if(maxToFront < maxToEnd){
                return op + maxToFront;
            } else {
                return op + maxToEnd;
            }
        } else {
            op += min;
            maxToEnd = maxToEnd - minToEnd;
            if(maxToFront < maxToEnd){
                return op + maxToFront;
            } else {
                return op + maxToEnd;
            }
        }

    }
}
