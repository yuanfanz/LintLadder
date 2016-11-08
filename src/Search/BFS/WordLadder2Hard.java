package Search.BFS;

import java.util.*;
/**
 * Created by Frank on 2016/11/7.
 */
public class WordLadder2Hard {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        ArrayList<List<String>> result = new ArrayList<>();
        if (start == null || end == null || dict == null) {
            return result;
        }
        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, ArrayList<String>> nextWords = new HashMap<>();
        queue.offer(start);
        map.put(start, 1);
        for (String s : dict) {
            nextWords.put(s, new ArrayList<String>());
        }
        while (!queue.isEmpty()) {
            String word = queue.poll();
            ArrayList<String> list = getNextWords(word, dict);
            for (String nextWord : list) {
                nextWords.get(nextWord).add(word);
                if (!map.containsKey(nextWord)) {
                    if (nextWord.equals(end)) {
                        map.put(nextWord, map.get(word) + 1);
                        break;
                    } else {
                        queue.offer(nextWord);
                        map.put(nextWord, map.get(word) + 1);
                    }
                }
            }
        }
        //DFS
        int step = map.get(end);
        ArrayList<String> list = new ArrayList<>();
        helper(result, list, end, map, start, nextWords);
        return result;
    }
    private void helper(ArrayList<List<String>> result,
                        ArrayList<String> list, String end,
                        Map<String, Integer> map, String start,
                        Map<String, ArrayList<String>> nextWords) {

        list.add(end);
        if (end.equals(start)) {
            Collections.reverse(list);
            result.add(new ArrayList<String>(list));
            Collections.reverse(list);
        } else {
            for (String next : nextWords.get(end)) {
                if (map.containsKey(next) && map.get(end) == map.get(next) + 1) {
                    helper(result, list, next, map, start, nextWords);
                }
            }
        }
        list.remove(list.size() - 1);
    }


    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        if (word == null) {
            return result;
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            for (int i = 0; i < word.length(); ++i) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, c, i);
                if (dict.contains(nextWord)) {
                    result.add(nextWord);
                }
            }
        }
        return result;
    }
    private String replace(String word, char c, int index) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}