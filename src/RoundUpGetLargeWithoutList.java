
/**
 * Created by Frank on 16/10/13.
 */
public class RoundUpGetLargeWithoutList {

    public static int getLarge (int x) {
        String input = Integer.toString(x);
        int[] re = new int[input.length()];
        boolean flag = false;

        for (int i = 0; i < input.length(); ++i) {
            re[i] = input.charAt(i) - 48;
        }

        if (re.length == 0 || re.length == 1) {
            return 0;
        }

        if (re[0] < re[1]) {
            re[1] = Math.round(((float)re[0] + (float)re[1]) / (float)2);
            re[0] = -1;
            flag = true;
        } else {
            for (int i = 1; i < re.length - 1; ++i) {
                if (re[i] < re[i + 1]) {
                    flag = true;
                    if ((re[i] == re[i - 1]) || (re[i] == re[i - 1] - 1)) {
                        re[i] = -1;
                    } else {
                        System.out.println(re[i] = Math.round(((float)re[i] + (float)re[i + 1]) / (float)2));
                        re[i + 1] = -1;
                    }
                    break;
                }
            }
        }

        if (!flag) {
            re[re.length - 2] = Math.round(((float)re[re.length - 2] + (float)re[re.length - 1]) / (float)2);
            re[re.length - 1] = -1;
        }

        int result = re[0];
        if (re[0] == -1) {
            result = re[1];
            for (int i = 2; i < re.length; ++i) {
                result = result * 10 + re[i];
            }
        } else {
            for (int i = 1; i < re.length; ++i) {
                if (re[i] != -1) {
                    result = result * 10 + re[i];
                }
            }
        }
        return result;
    }


    public static void main(String args[]) {
        int test = 9;
        System.out.print(getLarge(test));
    }
}
