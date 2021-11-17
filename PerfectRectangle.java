// 小矩形合成的大矩形的四个顶点只能出现一个，小矩形的顶点只出现2次或4次，是紧凑排列的
// 若面积之和等于大矩形面积则没有重叠

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PerfectRectangle {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        Map<Point, Integer> count = new HashMap<>();
        long area = 0;

        for(int i = 0; i < rectangles.length; i ++){
            minX = Math.min(minX, rectangles[i][0]);
            minY = Math.min(minY, rectangles[i][1]);
            maxX = Math.max(maxX, rectangles[i][2]);
            maxY = Math.max(maxY, rectangles[i][3]);
            area += (long) (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);

            Point p1 = new Point(rectangles[i][0], rectangles[i][1]);
            Point p2 = new Point(rectangles[i][2], rectangles[i][1]);
            Point p3 = new Point(rectangles[i][0], rectangles[i][3]);
            Point p4 = new Point(rectangles[i][2], rectangles[i][3]);

            count.put(p1, count.getOrDefault(p1, 0) + 1);
            count.put(p2, count.getOrDefault(p2, 0) + 1);
            count.put(p3, count.getOrDefault(p3, 0) + 1);
            count.put(p4, count.getOrDefault(p4, 0) + 1);
        }

        Point peek1 = new Point(minX, minY);
        Point peek2 = new Point(maxX, minY);
        Point peek3 = new Point(minX, maxY);
        Point peek4 = new Point(maxX, maxY);

        if(area != (long)(maxX - minX) * (maxY - minY) || count.getOrDefault(peek1, 0) != 1 || count.getOrDefault(peek2, 0) != 1 || count.getOrDefault(peek3, 0) != 1 || count.getOrDefault(peek4, 0) != 1){
            return false;
        }

        count.remove(peek1);
        count.remove(peek2);
        count.remove(peek3);
        count.remove(peek4);


        for(Map.Entry<Point, Integer> entry: count.entrySet()){
            int cnt = entry.getValue();
            if(cnt != 2 && cnt != 4){
                return false;
            }
        }

        return true;
    }
}
