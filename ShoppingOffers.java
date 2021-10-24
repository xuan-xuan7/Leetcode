import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
    Map<List<Integer>, Integer> mem = new HashMap<List<Integer>, Integer>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        List<List<Integer>> usefulSp = new ArrayList<List<Integer>>();

        // 选择出有效的大礼包
        for(List<Integer> sp: special){
            int totalCount = 0;
            int totalPrice = 0;
            for(int i=0; i<n; i++){
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if(totalCount > 0 && totalPrice > sp.get(n)){
                usefulSp.add(sp);
            }
        }

        return dfs(price, usefulSp, needs, n);
    }

    //记忆化搜索
    public int dfs(List<Integer> price, List<List<Integer>> usefulSp, List<Integer> needs, int n){
        if(!mem.containsKey(needs)){
            int minPrice = 0;
            // 原价
            for(int i=0; i<n; i++){
                minPrice += needs.get(i) * price.get(i);
            }
            for(List<Integer> sp: usefulSp){
                int spPrice = sp.get(n);
                List<Integer> nxtNeeds = new ArrayList<Integer>();
                for(int i=0; i<n; i++){
                    if(sp.get(i) > needs.get(i)){
                        break;
                    }
                    nxtNeeds.add(needs.get(i) - sp.get(i));
                }
                if(nxtNeeds.size() == n){
                    minPrice = Math.min(minPrice, dfs(price, usefulSp, nxtNeeds, n) + spPrice);
                }
            }
            mem.put(needs, minPrice);
        }
        return mem.get(needs);
    }
}
