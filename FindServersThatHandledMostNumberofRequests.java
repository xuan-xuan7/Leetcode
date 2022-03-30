// 优先队列

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindServersThatHandledMostNumberofRequests {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requests = new int[k];
        // 记录可用的服务器，保证每次能取到的服务器是从i开始
        PriorityQueue<Integer> available = new PriorityQueue<>();
        // 0为结束时间，1为服务器编号，队首服务器的处理结束时间最小
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        // 初始化available
        for(int i = 0; i < k; i ++){
            available.offer(i);
        }

        for(int i = 0; i < arrival.length; i ++){
            // 将该时间结束的可用服务器均加入available
            while(!busy.isEmpty() && busy.peek()[0] <= arrival[i]){
                int id = busy.peek()[1];
                busy.poll();
                // 保证该服务器的编号大于i且和id同余
                available.offer(i + ((id - i) % k + k) % k);
            }

            if(available.isEmpty()){
                continue;
            }

            int server = available.poll() % k;
            requests[server] ++;
            busy.offer(new int[]{arrival[i] + load[i], server});
        }

        int maxServer = Arrays.stream(requests).max().getAsInt();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i ++){
            if(requests[i] == maxServer){
                ans.add(i);
            }
        }

        return ans;

    }
}
