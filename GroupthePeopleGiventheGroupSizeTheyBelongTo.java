import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> group = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < groupSizes.length; i ++){
            group.putIfAbsent(groupSizes[i], new ArrayList<Integer>());
            group.get(groupSizes[i]).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry: group.entrySet()){
            int key = entry.getKey();
            List<Integer> index = entry.getValue();
            for(int i = 0; i < index.size();){
                List<Integer> newGroup = new ArrayList<>();
                for(int j = 0; j < key; j ++, i ++){
                    newGroup.add(index.get(i));
                }
                ans.add(newGroup);
            }
        }

        return ans;
    }
}