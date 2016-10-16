import java.util.ArrayList;

/**
 * Created by Frank on 16/10/12.
 */
public class ReplaceGetSmallWithoutList {

    public static int getSmall (int x) {
        String input = Integer.toString(x);
        int[] re = new int[input.length()];
        boolean flag = false;

        for (int i = 0; i < input.length(); ++i) {
            re[i] = input.charAt(i) - 48;
        }

        if (re.length == 0 || re.length == 1) {
            return 0;
        }

        for (int i = 0; i < re.length - 1; ++i) {
            if (re[i] > re[i + 1]) {
                flag = true;
                re[i + 1] = -1;
                break;
            }
        }

        if (!flag) {
            re[re.length - 2] = re[re.length - 1];
            re[re.length - 1] = -1;
        }

        int result = re[0];
        for (int i = 1; i < re.length; ++i) {
            if (re[i] != -1) {
                result = result * 10 + re[i];
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int test = 0;
        System.out.print(getSmall(test));
    }
}
