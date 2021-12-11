import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnlineElection {
    Map<Integer, Integer> vote;
    int[] top;
    int[] times;

    public void TopVotedCandidate(int[] persons, int[] times) {
        vote = new HashMap<Integer, Integer>();
        top = new int[times.length];
        Arrays.fill(top, 0);
        int max = 0;
        for(int i = 0; i < persons.length; i ++){
            vote.put(persons[i], vote.getOrDefault(persons[i], 0) + 1);
            if(vote.get(persons[i]) >= vote.get(persons[max])){
                max = persons[i];
            }
            top[i] = max;
        }
        this.times = times;
    }

    public int q(int t) {
        int left = 0;
        int right = times.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(times[mid] <= t){
                left = mid;
            } else {
                right = mid;
            }
        }
        return top[left];
    }
}
