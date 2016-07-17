package DynamicProgramming.Coordinate;

/**
 * Created by yuanf on 2016/7/16.
 */
public class ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */

    //1. 递归的方式：面试时首先尝试的办法。
    // public int climbStairs(int n) {
    //     if(n == 0){
    //         return 0;
    //     }
    //     if(n == 1){
    //         return 1;
    //     }
    //     if(n == 2){
    //         return 2;
    //     }
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }

    //2. 动态规划用数组的方式 但接下来还可以继续优化空间
    // public int climbStairs(int n) {
    //     // write your code here
    //     if(n == 0){
    //         return 1;
    //     }
    //     //state 有多少种方法？
    //     int[] sum = new int[n + 1];
    //     //initialization
    //     sum[0] = 1;
    //     sum[1] = 1;
    //     //function
    //     for(int i = 2; i < n + 1; ++i){
    //         sum[i] = sum[i - 1] + sum[i - 2];
    //     }
    //     //answer
    //     return sum[n];
    // }

    //3. 不用数组 直接用变量存储步数
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int last = 1;
        int lastlast = 1;
        int now = 0;
        for(int i = 2; i < n + 1; ++i){
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}