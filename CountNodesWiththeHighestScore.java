// DFS

import java.util.ArrayList;
import java.util.List;

public class CountNodesWiththeHighestScore {
    int nodeNum = 0;
    long maxScore = 0;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        int parent = 0;
        for(int i = 0; i < n; i ++){
            children[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < n; i ++){
            parent = parents[i];
            if(parent != -1){
                children[parent].add(i);
            }
        }
        dfs(0);
        return nodeNum;
    }

    public int dfs(int root){
        long score = 1;
        int size = n - 1;
        // 乘以子节点数量
        for(int child: children[root]){
            int subSize = dfs(child);
            score *= subSize;
            size -= subSize;
        }
        // 乘以父节点及上边节点数量
        if(root != 0){
            score *= size;
        }
        if(score == maxScore){
            nodeNum ++;
        } else if(score > maxScore){
            maxScore = score;
            nodeNum = 1;
        }
        // size为父及以上节点数量，n-size为子节点数量
        return n - size;
    }
}
