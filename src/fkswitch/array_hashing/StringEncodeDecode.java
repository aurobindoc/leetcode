package fkswitch.array_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringEncodeDecode {
    public String encode(List<String> strs) {

        String result = "";
        String words = "";
        for (String str : strs) {
            result += str.length() + ",";
            words += str;
        }
        return result.length() + "," + result + words;
    }

    public List<String> decode(String str) {
        int index = str.split(",")[0].length() + 1;
        int length = Integer.parseInt(str.substring(0, index-1));
        String meta = str.substring(index, index+length-1);
        String words = str.substring(index+length);
        int[] lengths = Arrays.stream(meta.split(",")).mapToInt(Integer::parseInt).toArray();
        int start = 0;
        List<String> result = new ArrayList<>();

        for(int i = 0; i < lengths.length; i++) {
            result.add(words.substring(start, start+lengths[i]));
            start += lengths[i];
        }
        return result;
    }

    public static void main(String[] args) {

        StringEncodeDecode stringEncodeDecode = new StringEncodeDecode();
        List<String> strs = Arrays.asList("");
        System.out.println(stringEncodeDecode.encode(strs));
        System.out.println(stringEncodeDecode.decode(stringEncodeDecode.encode(strs)));
    }
}
