import java.util.ArrayList;

/**
 * Created by Frank on 16/10/13.
 */
public class RoundUpGetLarge {

    public static int getLarge (int x) {

        float result = Integer.MIN_VALUE;
        ArrayList<Float> list = new ArrayList<>();
        while (x != 0) {
            list.add((float)x % 10);
            x /= 10;
        }

        if (list.size() <= 1) {
            return x;
        }
        for (int i = list.size() - 1; i > 0; --i) {
            float tmp = Math.round((list.get(i) + list.get(i - 1)) / 2);
            float a = list.get(i);
            float b = list.get(i - 1);
            list.remove(i);
            list.remove(i - 1);
            list.add(i - 1, tmp);
            float re = convert(list);
            if (result <= re) {
                result = re;
            }
            list.remove(i - 1);
            list.add(i - 1, b);
            list.add(i, a);
        }

        return (int)result;
    }

    private static float convert (ArrayList<Float> list) {
        if (list == null || list.size() == 0) {
            return -1;
        }
        float result = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; --i) {
            result = result * 10 + list.get(i);
        }
        return result;
    }

    private static void print (ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i));
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int test = 12227;
        System.out.print(getLarge(test));
    }
}
