class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int mid;
        int left = 0;
        int right = nums.length - 1;

        for(; left < right; ){
            mid = (left + right) / 2;
            if(nums[mid] < nums[mid+1]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] arg){
        FindPeakElement s = new FindPeakElement();
        int nums[] = {1,2,3,1};
        int num = s.findPeakElement(nums);
        System.out.println(num);
    }
}

