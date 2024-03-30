package fkswitch.array_hashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++)    {
            String key = String.valueOf(s.charAt(i));
            if(map.containsKey(key))    {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        for(int i = 0; i< t.length(); i++)    {
            String key = String.valueOf(t.charAt(i));
            if(map.containsKey(key) && map.get(key) > 0)    {
                map.put(key, map.get(key) - 1);
            } else {
                return false;
            }
        }
        for(Map.Entry<String,Integer> entry:map.entrySet())    {
            if(entry.getValue() != 0)   {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "naagram"));
    }


}
