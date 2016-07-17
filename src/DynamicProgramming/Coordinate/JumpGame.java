package DynamicProgramming.Coordinate;

/**
 * Created by yuanf on 2016/7/16.
 */
public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0){
            return false;
        }
        int n = A.length;
        boolean[] can = new boolean[n];
        can[0] = true;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < i; ++j){
                if(can[j] && j + A[j] >= i){
                    can[i] = true;
                }
            }
        }
        return can[A.length - 1];
    }
}

