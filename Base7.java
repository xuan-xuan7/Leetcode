public class Base7 {
    public String convertToBase7(int num) {
        StringBuffer ans = new StringBuffer();
        int absNum = Math.abs(num);
        while(absNum >= 7){
            ans.append(absNum % 7);
            absNum = absNum / 7;
        }
        ans.append(absNum);
        if(num < 0){
            ans.append("-");
        }
        ans.reverse();
        return ans.toString();
    }
}
