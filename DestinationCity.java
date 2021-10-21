//遍历一遍数组，把A元素存入，在遍历一遍数组，B中不在A集合中的元素即为答案

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> cityA = new HashSet<String>();
        for(List<String> path: paths){
            cityA.add(path.get(0));
        }
        for(List<String> path: paths){
            if(cityA.contains(path.get(1))){
                continue;
            } else {
                return path.get(1);
            }
        }
        return "";
    }
}
