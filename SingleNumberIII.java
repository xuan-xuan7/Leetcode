// 位运算，异或的性质：a异或b异或b=a
// 将数组异或，结果为x1和x2的异或和x
// x&-x可以找到x最低位的1，则在该位上x1和x2分别为0和1，这样对数组进行分组，x1和x2分别在两个分组中，在进行异或求出

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xorSum = 0;
        for(int i=0; i<nums.length; i++){
            xorSum ^= nums[i];
        }
        int low = xorSum & (-xorSum);
        int num1 = 0;
        int num2 = 0;
        for(int num: nums){
            if((num & low) != 0){
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return  new int[]{num1, num2};
    }
}
