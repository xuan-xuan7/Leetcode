class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int num0 = 0;
        int num1 = 0;
        int n = sandwiches.length;

        for(int i = 0; i < n; i ++){
            if(students[i] == 0){
                num0 ++;
            } else {
                num1 ++;
            }
        }

        for(int i = 0; i < n; i ++){
            if(sandwiches[i] == 0){
                if(num0 == 0){
                    return n - i;
                } else {
                    num0 --;
                }
            } else {
                if(num1 == 0){
                    return n - i;
                } else {
                    num1 --;
                }
            }
        }

        return 0;
    }
}