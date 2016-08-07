package Basic;

/**
 * Created by Frank on 16/8/3.
 */
public class FindSubstring2 {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null){
            return 0;
        }
        int m = A.length();
        int n = B.length();
        int maxLen = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int len = 0;
                while(i + len < m && j + len < n
                        && A.charAt(i + len) == B.charAt(j + len)){
                    len++;
                    if(len > maxLen){
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }
}