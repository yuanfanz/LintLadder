package Array.PartitionArray;

/**
 * Created by Frank on 16/8/17.
 */
public class SortLettersByCase {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length == 0){
            return;
        }
        int i = 0, j = chars.length - 1;
        while(i <= j){
            while(i <= j && Character.isLowerCase(chars[i])){
                i++;
            }
            while(i <= j && Character.isUpperCase(chars[j])){
                j--;
            }
            if(i <= j){
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
