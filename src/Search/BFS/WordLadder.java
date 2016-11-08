package Search.BFS;
import java.util.*;
/**
 * Created by Frank on 2016/11/2.
 */
public class WordLadder {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start == null || end == null || dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        queue.offer(start);
        map.put(start, 1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String s : getNextWords(word, dict)) {
                if (!map.containsKey(s)) {
                    if (s.equals(end)) {
                        return map.get(word) + 1;
                    } else {
                        queue.offer(s);
                        map.put(s, map.get(word) + 1);
                    }
                }
            }
        }
        return 0;
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}

