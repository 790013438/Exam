package snippets.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondaryMax {

    public static <T extends Comparable<T>> T secondaryMax(T[] array) {
        Set<T> set = new HashSet(Arrays.asList(array));
        List<T> list = new ArrayList<>(set);
        T maxT = list.get(0);
        T seT = list.get(1);
        if (maxT.compareTo(seT) < 0) {
            maxT = returnFirst(seT, seT = maxT);
        }
        for (int i = 3; i < list.size(); ++i) {
            if (seT.compareTo(list.get(i)) < 0) {
                seT = list.get(i);
            }
            if (maxT.compareTo(seT) < 0) {
                maxT = returnFirst(seT, seT = maxT);
            }
        }
        return seT;
    }

    public static <T> T returnFirst(T o1, T o2) {
        return o1;
    }

    public static <T> T secondaryMax(T[] array, Comparator<T> comp) {
        Set<T> set = new HashSet<>(Arrays.asList(array));
        List<T> list = new ArrayList<>(set);
        T maxT = list.get(0);
        T seT = list.get(1);
        if (comp.compare(maxT, seT) < 0) {
            maxT = returnFirst(seT, seT = maxT);
        }
        for (int i = 2; i < list.size(); ++i) {
            if (comp.compare(seT, list.get(i)) < 0) {
                seT = list.get(i);
            }
            if (comp.compare(maxT, seT) < 0) {
                maxT = returnFirst(seT, seT = maxT);
            }
        }
        return seT;
    }
}
