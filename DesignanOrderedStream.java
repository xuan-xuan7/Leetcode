class OrderedStream {
    private String[] ptr;
    private int p;

    public OrderedStream(int n) {
        ptr = new String[n];
        p = 0;
    }
    
    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList<String>();
        int index = idKey - 1;
        ptr[index] = value;
        if(index == p){
            while(index < ptr.length && ptr[index] != null){
            ans.add(ptr[index]);
            index ++;
            }
            p = index;
        }
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */