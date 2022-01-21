// 广度优先搜索

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> index = new HashMap<>();
        for(int i = 0; i < arr.length; i ++){
            if(index.containsKey(arr[i])){
                index.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> newIndex = new ArrayList<>();
                newIndex.add(i);
                index.put(arr[i], newIndex);
            }
        }

        // 记录可遍历的节点和步数
        Queue<int[]> queue = new ArrayDeque<>();

        // 记录已经被访问的节点
        Set<Integer> visited = new HashSet<>();

        queue.offer(new int[]{0, 0});
        visited.add(0);

        while(!queue.isEmpty()){
            // 取队列中元素
            int[] indexStep = queue.poll();
            int idx = indexStep[0];
            int step = indexStep[1];
            if(idx == arr.length - 1){
                return step;
            }

            int value = arr[idx];
            step ++;

            if(index.containsKey(value)){
                for(int i: index.get(value)){
                    if(visited.add(i)){
                        queue.offer(new int[]{i, step});
                    }
                }
                index.remove(value);
            }

            if (idx + 1 < arr.length && visited.add(idx + 1)) {
                queue.offer(new int[]{idx + 1, step});
            }
            if (idx - 1 >= 0 && visited.add(idx - 1)) {
                queue.offer(new int[]{idx - 1, step});
            }
        }

        return -1;
    }
}
