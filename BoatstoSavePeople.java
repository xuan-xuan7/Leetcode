// 贪心算法，每次选择最重的看是否能和最轻的匹配

import java.util.Arrays;

public class BoatstoSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int num = 0;
        int light = 0;
        int heavy = people.length - 1;

        Arrays.sort(people);
        while(light <= heavy){
            if(people[light] + people[heavy] <= limit){
                light ++;
            }
            heavy --;
            num ++;
        }

        return num;
    }
}
