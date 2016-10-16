import java.util.Stack;

/**
 * Created by Frank on 16/10/15.
 */
public class GetLongestDirectoryStack2 {

    public class Solution {
        public int longestPath(String files) {
            if(files == null || files.length() == 0){
                return 0;
            }

            String[] strs = files.split("\n");
            Stack<String> stack = new Stack<>();
            stack.push(strs[0]);
            int count = strs[0].length()+1;
            int max = count;
            int space = 0;
            for(int i=1; i < strs.length; i++) {
                String cur = strs[i];
                for(int j = 0; j < strs.length; j++) {
                    if(cur.charAt(j) == ' ') {
                        space++;
                    }
                    else break;
                }
                if(space == stack.size()) {
                    if(cur.contains(".")) {
                        max = Math.max(max, (cur.contains("jpeg") || cur.contains("gif")) ? count + cur.length() - space : 0);
                    }
                    else {
                        stack.push(cur);
                        count += cur.length() + 1 - space;
                    }
                }
                else if(space < stack.size()) {
                    while(space < stack.size()) {
                        String temp = stack.pop();
                        count -= temp.length() + 1 - space;
                    }
                    stack.push(cur);
                    count += cur.length() + 1 - space;
                }
                space = 0;
            }
            return max;
        }
    }
}
