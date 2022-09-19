import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

// class Solution {
//     public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
//         List<Integer> ans = new ArrayList<>();
//         // 哈希表保存每个words中的word有哪些字母
//         Map<String, Set<Integer>> wordIdx = new HashMap<>();
//         for(String word: words){
//             Set<Integer> alp = new HashSet<>();
//             for(int i = 0; i < word.length(); i ++){
//                 alp.add((int)(word.charAt(i) - 'a'));
//             }
//             wordIdx.put(word, alp);
//         }
//         // for(Map.Entry<String,Set<Integer>> entry: wordIdx.entrySet()){
//         //     System.out.println(entry.getKey() + " " + entry.getValue());
//         // }

//         for(String puzzle: puzzles){
//             int count = 0;
//             Set<Integer> alpPuzzle = new HashSet<>();
//             for(int i = 0; i < puzzle.length(); i ++){
//                 alpPuzzle.add((int)(puzzle.charAt(i) - 'a'));
//             }
//             // for(Object k: alpPuzzle){
//             //     System.out.print(k + " ");
//             // }
//             // System.out.println("\n");
//             for(String word: words){
//                 // 不含puzzle的第一个元素
//                 if(!wordIdx.get(word).contains((int)(puzzle.charAt(0) - 'a'))){
//                     continue;
//                 }
//                 // word的元素是否都在puzzle中
//                 for(int j = 0; j < word.length(); j ++){
//                     if(!alpPuzzle.contains((int)(word.charAt(j) - 'a'))){
//                         break;
//                     }
//                     if(j == word.length() - 1){
//                         count ++;
//                     }
//                 }
//             }
//             ans.add(count);
//         }

//         return ans;
//     }
// }


// 二进制状态压缩来记录word和puzzle的字母
// 枚举puzzle的二进制子集


class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        for(String word: words){
            int mask = 0;
            // 计算二进制状态压缩后的表示
            for(int i = 0; i < word.length(); i ++){
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            // puzzle.length不大于7，超过7的不需要考虑
            if(Integer.bitCount(mask) <= 7){
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(String puzzle: puzzles){
            int total = 0;
            
            // 先处理后6位
            int mask = 0;
            for(int i = 1; i < 7; i ++){
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do{
                // 首字母一定要有
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if(frequency.containsKey(s)){
                    total += frequency.get(s);
                }
                // 每次改变一位
                subset = (subset - 1) & mask;
            } while(subset != mask);

            ans.add(total);
        }

        return ans;
    }
}