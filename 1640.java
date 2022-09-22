import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i < pieces.length; i ++){
            index.put(pieces[i][0], i);
        }
        for(int i = 0; i < arr.length;){
            if(!index.containsKey(arr[i])){
                return false;
            }
            int idx = index.get(arr[i]);
            int len = pieces[idx].length;
            for(int k = 0; k < len; k ++){
                if(arr[i + k] != pieces[idx][k]){
                    return false;
                }
            }
            i += len;
        }
        return true;
    }
}