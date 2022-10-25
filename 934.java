import java.util.ArrayDeque;
import java.util.Queue;

// 深度优先搜索+广度优先搜索

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 1){
                    Queue<int[]> queue = new ArrayDeque<>();
                    // dfs后可以找到第一座岛的集合，并记为-1
                    dfs(i, j, grid, queue);
                    int step = 0;
                    while(!queue.isEmpty()){
                        int sz = queue.size();
                        // 每一层向四个方向延伸
                        for(int k = 0; k < sz; k ++){
                            int[] cell = queue.poll();
                            int x = cell[0];
                            int y = cell[1];
                            for(int d = 0; d < 4; d ++){
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if(nx >= 0 && ny >= 0 && nx <n && ny < n){
                                    if(grid[nx][ny] == 0){
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if(grid[nx][ny] == 1){
                                        return step;
                                    }
                                }
                            }
                        }
                        step ++;
                    }
                }
            }
        }
        return 0;
    }

    private void dfs(int x, int y, int[][] grid, Queue<int[]> queue){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] != 1){
            return;
        }
        queue.offer(new int[]{x,y});
        grid[x][y] = -1;
        dfs(x - 1, y, grid, queue);
        dfs(x + 1, y, grid, queue);
        dfs(x, y - 1, grid, queue);
        dfs(x, y + 1, grid, queue);
    }
}