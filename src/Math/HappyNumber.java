package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Frank on 16/8/27.
 */
public class HappyNumber {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        if (n < 0) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int mod = n % 10;
                sum += mod * mod;
                n /= 10;
            }
            n = sum;
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
        }
        return true;
    }
}