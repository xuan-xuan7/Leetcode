// 主要用广度优先搜索计算出每个点到原点的最短路径

import java.util.*;

public class TheTimeWhentheNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int second = 0;
        int dist = 1;
        int n = patience.length;
        int time = 0;
        boolean[] visited = new boolean[n];
        List<Integer>[] adj = new List[n];
        for(int i = 0; i < n; i ++){
            adj[i] = new ArrayList<Integer>();
        }
        // 建图
        for(int i = 0; i < edges.length; i ++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }

        Queue<Integer> move = new ArrayDeque<Integer>();
        move.offer(0);
        visited[0] = true;
        // BFS
        while(!move.isEmpty()){
            int size = move.size();
            for(int i = 0; i < size; i ++){
                int cur = move.poll();
                for(int v: adj[cur]){
                    if(visited[v]){
                        continue;
                    }
                    move.offer(v);
                    time = patience[v] * ((2 * dist - 1) / patience[v]) + 2 * dist + 1;
                    second = Math.max(time, second);
                    visited[v] = true;
                }
            }
            dist ++;
        }
        return second;
    }
}
