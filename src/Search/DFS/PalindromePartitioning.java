package Search.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank on 2016/11/1.
 */
public class PalindromePartitioning {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        ArrayList<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        ArrayList<String> path = new ArrayList<>();
        helper(result, path, s, 0);
        return result;
    }
    private void helper(ArrayList<List<String>> result,
                        ArrayList<String> path, String s, int index) {

        if (index == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        for (int i = index + 1; i <= s.length(); ++i) {
            String sub = s.substring(index, i);
            if (!isPalindrome(sub)) {
                continue;
            }
            path.add(sub);
            helper(result, path, s, i);
            path.remove(path.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
