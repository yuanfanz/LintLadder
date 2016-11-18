package Math;

/**
 * Created by Frank on 2016/11/13.
 */
public class PlusOne {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if (digits == null || digits.length == 0) {
            return null;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry > 0; --i) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry == 0) return digits;
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; ++i) {
            result[i] = 0;
        }
        return result;
    }
}