import java.util.ArrayList;

/**
 * Created by Frank on 16/10/12.
 */
public class ReplaceGetSmall {

    public static int getSmall (int x) {


        int result = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        if (list.size() <= 1) {
            return x;
        }
        for (int i = list.size() - 1; i > 0; --i) {
            int re = 0  ;
            if (list.get(i) > list.get(i - 1)) {
                int tmp = list.remove(i - 1);
                re = convert(list);
                list.add(i - 1, tmp);
            } else {
                int tmp = list.remove(i);
                re = convert(list);
                list.add(i, tmp);
            }
            if (result >= re) {
                result = re;
            }
        }
        return result;
    }

    private static int convert (ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return -1;
        }
        int result = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; --i) {
            result = result * 10 + list.get(i);
        }
        return result;
    }

    public static void main(String args[]) {
        int test = 918987462;
        System.out.print(getSmall(test));
    }
}
