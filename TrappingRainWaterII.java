// 用数组water记录每个格子接水后的高度
// water[i][j]=max(heightMap[i],min(water[i−1][j],water[i+1][j],water[i][j−1],water[i][j+1]))
// 不断调整water，知道water没变化，用队列记录改变的位置，进行下一次处理

import java.util.LinkedList;
import java.util.Queue;

public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        int maxHeight = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxHeight = Math.max(maxHeight, heightMap[i][j]);
            }
        }
        int[][] water = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j){
                water[i][j] = maxHeight;
            }
        }

        Queue<int[]> qu = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || i==m-1 || j==0 || j==n-1){
                    if(water[i][j] > heightMap[i][j]) {
                        water[i][j] = heightMap[i][j];
                        qu.offer(new int[]{i, j});
                    }
                }
            }
        }

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0; i<4; i++){
                int nx = x + dirs[i];
                int ny = y + dirs[i+1];
                if(nx<0 || nx>=m || ny<0 || ny>=n){
                    continue;
                }
                if(water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]){
                    water[nx][ny] = Math.max(water[x][y], heightMap[nx][ny]);
                    qu.offer(new int[]{nx, ny});
                }
            }
        }

        int vol = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                vol += water[i][j] - heightMap[i][j];
            }
        }
        return vol;
    }
}
