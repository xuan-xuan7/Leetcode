import java.util.Arrays;

public class BullsandCows {
    public String getHint(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        int[] nums = new int[10];
        Arrays.fill(nums, 0);


        for(int i = 0; i < secret.length(); i ++){
            nums[secret.charAt(i) - '0'] ++;
        }

        for(int i = 0; i < secret.length(); i ++){
            if(secret.charAt(i) == guess.charAt(i)){
                nums[secret.charAt(i) - '0'] --;
                bull ++;
            }
        }

        for(int i = 0; i < guess.length(); i ++){
            if(secret.charAt(i) != guess.charAt(i) && nums[guess.charAt(i) - '0'] > 0){
                nums[guess.charAt(i) - '0'] --;
                cow ++;
            }
        }

        return Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
    }
}
