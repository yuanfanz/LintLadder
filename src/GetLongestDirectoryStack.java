import java.util.Stack;

/**
 * Created by Frank on 16/10/14.
 */
public class GetLongestDirectoryStack {

    public static int getLongest (String S) {
        int n = S.length();
        if(n==0) return 0;

        String[] strs = S.split("\n");
        Stack<String> stack = new Stack<>();

        int len=0;
        int maxlen=0;

        for (int i = 0; i < strs.length; ) {
            String cur = strs[i];

            int spaceNum = 0;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) == '\t') {
                    spaceNum++;
                } else {
                    break;
                }
            }

            String filename = cur.substring(spaceNum);

            if (spaceNum == stack.size()) {

                if (cur.contains(".jpeg") || cur.contains(".png") || cur.contains(".gif")) {

                    stack.push(filename);
                    len += filename.length() + 1;
                    maxlen = Math.max(maxlen, len);
//                    if(len == maxlen){
//                        for(String ss: stack){
//                            System.out.print("/" + ss);
//                        }
//                        System.out.println();
//                    }

                } else {
                    len += filename.length() + 1;
                    stack.push(filename);
                }
                i++;

            } else if (spaceNum < stack.size()) {
                while (spaceNum < stack.size()) {
                    String tmpName = stack.pop();
                    len -= (tmpName.length() + 1);
                }
            }
        }
        return maxlen;
    }
    public static void main(String args[]) {
        String s = "dir1\n\tdir11\n\tdir12\n\t\tpic.jpeg\n\t\tdir121\n\t\tfile.txt\ndir2\n\tfile.gif\n";

        System.out.print("***" + " " + getLongest(s) + " " + "***");
    }

}
