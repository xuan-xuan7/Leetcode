// 欧拉筛：筛出范围内所有的质数
// 遍历nums，将每个数和它的质因数连接，如果有多个质因数，质因数也进行连接
// 便利数组，进行计数       
// java创建int数组会自动初始化为0

class Solution {
    public static int n = (int)1e5 + 7;
    // 是否是质数
    public static int[] isPrime = new int[n];
    // 记录质数
    public static int[] primes = new int[n];
    //查并集，记录每个数的上一个父节点，连接位置
    public static int[] parent = new int[n];
    // 注意静态函数不能访问非静态对象，所以euler()前不能加static
    int k = 0;


    public void euler(){
        for(int i = 2; i < n; i ++){
            if(isPrime[i] == 0){
                primes[k ++] = i;
            }
            // 和已经找到的质数相乘，剔除合数，因为i在递增，在此过程中等于质数和每个数相乘
            for(int j = 0; primes[j] * i < n; j ++){
                isPrime[primes[j] * i] = 1;
                if(i % primes[j] == 0){
                    break;
                }
            }
        }
    }

    // 路径压缩, 找到最上层父节点
    public static int find(int x){
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }


    // 连接，即把一个数的父节点设置为另一个数
    public static void union(int a, int b){
        int parentX = find(a);
        int parentY = find(b);
        if(parentX != parentY){
            parent[parentX] = parentY;
        }
    }

    public int largestComponentSize(int[] nums) {
        int ans = 0;
        
        euler();
        
        // 初始化查并集
        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }

        // 将nums中的每个数和他们的质因数相连
        for(int num: nums){
            int temp = num;
            // 遍历primes中的质因数，只需遍历到num的平方根
            for(int j = 0; j < k && primes[j] * primes[j] <= temp; j ++){
                // prime[j]是它的质因数，则将二者相连
                if(temp % primes[j] == 0){
                    union(num, primes[j]);
                    // 剔除当前质因数，因为是从小到大寻找，所以剔除没有影响
                    while(temp % primes[j] == 0){
                        temp /= primes[j];
                    }
                }
            }
            // 最后不为1，temp则为另一个质因数，也需要进行连接
            if(temp > 1){
                union(temp, num);
            }
        }
        
        // 遍历搜索最大集合
        int[] cnt = new int[n];
        for(int num: nums){
            ans = Math.max(ans, ++cnt[find(num)]);
        }

        return ans;
    }
}