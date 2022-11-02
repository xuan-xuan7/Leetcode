// 遍历网格中所有点

class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int xMax = 0;
        int yMax = 0;
        
        // 寻找最大边界
        for(int i = 0; i < towers.length; i ++){
            if(towers[i][0] > xMax){
                xMax = towers[i][0];
            }
            if(towers[i][1] > yMax){
                yMax = towers[i][1];
            }
        }
        xMax += radius;
        yMax += radius;

        int qualityMax = 0;
        int xAns = 0;
        int yAns = 0;
        // 计算距离和信号强度
        for(int i = 0; i <= xMax; i ++){
            for(int j = 0; j <= yMax; j ++){
                int quality = 0;
                for(int k = 0; k < towers.length; k ++){
                    int distance = sqrtDistance(i, j, towers[k][0], towers[k][1]);
                    if(distance <= radius * radius){
                        quality += (int) Math.floor(towers[k][2] / (1 + Math.sqrt(distance)));
                    }
                }
                if(quality > qualityMax){
                    qualityMax = quality;
                    xAns = i;
                    yAns = j;
                }
            }
        }

        return new int[]{xAns, yAns};
    }

    private int sqrtDistance(int x, int y, int xtower, int ytower){
        return (x - xtower) * (x - xtower) + (y - ytower) * (y - ytower);
    }
}