package snippets.test2;

public class Sequence {

    public static boolean isSequence(int[] array) {
        int[] array2 = new int[array.length];
        System.arraycopy(array, 0, array2, 0, array2.length);
        int diff = array2[1] - array2[0];
        for (int i = 2; i < array2.length; ++i) {
            if (array2[i] - array2[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
