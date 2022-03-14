import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumofTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n1 = list1.length;
        int n2 = list2.length;
        Map<String, Integer> index = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int sum;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n1; i ++){
            index.put(list1[i], i);
        }
        for(int i = 0; i < n2; i ++){
            sum = i + index.getOrDefault(list2[i], Integer.MAX_VALUE);
            if(sum < 0){
                continue;
            }
            if(sum < min){
                min = sum;
                ans.clear();
                ans.add(list2[i]);
            } else if(sum == min){
                ans.add(list2[i]);
            }
        }
        String[] strArray = ans.toArray(new String[ans.size()]);
        return strArray;
    }
}
