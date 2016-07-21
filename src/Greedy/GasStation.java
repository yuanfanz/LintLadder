package Greedy;

/**
 * Created by Frank on 16/7/21.
 */
public class GasStation {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0){
            return -1;
        }
        int sum = 0;
        int total = 0;
        int index = -1;
        for(int i = 0; i < gas.length; ++i){
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0){
                index = i;
                sum = 0;
            }
        }
        return total < 0 ? -1 : index + 1;
    }
}