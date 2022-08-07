// 栈结构
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class  ExclusiveTimeofFunctions{
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<String[]> proc = new Stack<>();

        for(int i = 0; i < logs.size(); i ++){
            String[] log = new String[4]; 
            String[] ele = logs.get(i).split(":");
            for(int j = 0; j < 3; j ++){
                log[j] = ele[j];
            }
            log[3] = "0";
            if(log[1].equals("start")){
                // System.out.println(log[0] + " " + log[1] + " " + log[2] + " " + log[3]);
                proc.push(log);
            } else {
                // if(i == 2){
                //     while(!proc.isEmpty()){
                //         preLog = proc.pop();
                //         for(int k = 0; k < 4; k ++){
                //             System.out.println(preLog[k]);
                //         }
                //     }
                // }
                String[] preLog = new String[4];
                preLog = proc.pop();
                System.out.println(preLog[3]);
                ans[Integer.parseInt(log[0])] += Integer.parseInt(log[2]) + 1 - Integer.parseInt(preLog[2]) - Integer.parseInt(preLog[3]);
                if(!proc.isEmpty()){
                    String[] top = new String[4];
                    top = proc.pop();
                    int subTime = Integer.parseInt(top[3]);
                    subTime += Integer.parseInt(log[2]) + 1 - Integer.parseInt(preLog[2]);
                    top[3] = String.valueOf(subTime);
                    proc.push(top);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        List<String> logs = new ArrayList<String>();
        String[] test = {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
        for (String t: test){
            logs.add(t);
        }
        int[] ans = exclusiveTime(1, logs);
        for(int i = 0; i < 1; i ++){
            System.out.println(ans[i]);
        }
    }
}