/**
 * Created by Frank on 16/10/15.
 */
public class DuplicateNumberInputNumber {

    public static int duplicate (int x) {
        String str = Integer.toString(x);
        int[] input = new int[str.length()];
        int[] res = new int[str.length() + 1];
        int i = 0;
        int j = 0;

        for (int k = 0; k < str.length(); ++k) {
            input[k] = str.charAt(k) - 48;
        }

        if (input.length == 0 || input.length == 1) {
            return 0;
        }

        while (i < input.length - 1) {
            if (input[i] <= input[i + 1]) {
                res[j++] = input[i++];
            } else {
                res[j++] = input[i];
                while (j < res.length) {
                    res[j++] = input[i++];
                }
                return getNumber(res);
            }
        }
        res[j] = input[input.length - 1];
        res[j + 1] = input[input.length - 1];

        return getNumber(res);
    }

    private static int getNumber (int[] res) {
        int result = res[0];
        for (int k = 1; k < res.length; ++k) {
            result = result * 10 + res[k];
        }
        return result;
    }

    public static void main(String args[]) {
        int test = 123;
        System.out.print(duplicate(test));
    }
}
