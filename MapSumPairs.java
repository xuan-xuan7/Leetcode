import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {
    Map<String, Integer> pre;
    Map<String, Integer> count;

    public void MapSum() {
        pre = new HashMap<String, Integer>();
        count = new HashMap<String, Integer>();
    }

    public void insert(String key, int val) {
        int add = val - pre.getOrDefault(key, 0);
        pre.put(key, val);
        for(int i=1; i<=key.length(); i++){
            String subStr = key.substring(0, i);
            count.put(subStr, count.getOrDefault(subStr, 0) + add);
        }
    }

    public int sum(String prefix) {
        return count.getOrDefault(prefix, 0);
    }
}
