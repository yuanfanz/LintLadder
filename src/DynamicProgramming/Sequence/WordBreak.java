package DynamicProgramming.Sequence;

import java.util.Set;

/**
 * Created by Frank on 16/8/1.
 */
public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */

    private int getMaxLen(Set<String> dict){
        int maxLen = 0;
        for(String word : dict){
            maxLen = Math.max(maxLen, word.length());
        }
        return maxLen;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLen = getMaxLen(dict);
        int n = s.length();
        boolean[] f = new boolean[n + 1];

        f[0] = true;

        for(int i = 1; i <= n; i++){
            for(int lastWord = 1; lastWord <= i && lastWord <= maxLen;
                ++lastWord){
                if(!f[i - lastWord]){
                    continue;
                }
                String word = s.substring(i - lastWord, i);
                if(dict.contains(word)){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];
    }
}
