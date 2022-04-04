// 线段树
// 线段树 segmentTree 是一个二叉树，每个结点保存数组 nums 在区间 [s,e] 的最小值、最大值或者总和等信息

public class RangeSumQueryMutable {
    private int[] segmentTree;
    private int n;

    public RangeSumQueryMutable(int[] nums) {
        n = nums.length;
        segmentTree = new int[n * 4];
        bulid(0, 0, n - 1, nums);
    }

    public void update(int index, int val) {
        change(index, val, 0, 0, n - 1);
    }

    public int sumRange(int left, int right) {
        return range(left, right, 0, 0, n - 1);
    }

    // 建立线段树
    private void bulid(int node, int s, int e, int[] nums){
        if(s == e){
            segmentTree[node] = nums[s];
            return;
        }
        int m = s + (e - s) / 2;
        bulid(node * 2 + 1, s, m, nums);
        bulid(node * 2 + 2, m + 1, e, nums);
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    // 修改对应节点的值
    private void change(int index, int val, int node, int s, int e){
        if(s == e){
            segmentTree[node] = val;
            return;
        }
        int m = s + (e - s) / 2;
        if(index <= m){
          change(index, val, node * 2 + 1, s, m);
        } else {
            change(index, val, node * 2 + 2, m + 1, e);
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    // 求区间和
    private int range(int left, int right, int node, int s, int e){
        if(left == s && right == e){
            return segmentTree[node];
        }
        int m = s + (e - s) / 2;
        if(right <= m){
            return range(left, right, node * 2 + 1, s, m);
        } else if(left > m){
            return range(left, right, node * 2 + 2, m + 1, e);
        } else {
            return range(left, m, node * 2 + 1, s, m) + range(m + 1, right, node * 2 + 2, m + 1, e);
        }
    }

}
