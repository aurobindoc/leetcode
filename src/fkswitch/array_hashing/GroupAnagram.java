package fkswitch.array_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        ValidAnagram validAnagram = new ValidAnagram();
        List<List<String>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j).get(0).length() == strs[i].length() && validAnagram.isAnagram(strs[i],
                        result.get(j).get(0))) {
                    result.get(j).add(strs[i]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                result.add(tmp);
            }
        }
        return result;
    }

    public List<List<String>> groupAnagramsBetter(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            map.computeIfAbsent(sortedWord, k -> new ArrayList<>());
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        GroupAnagram groupAnagram = new GroupAnagram();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagram.groupAnagramsBetter(strs));
    }
}
