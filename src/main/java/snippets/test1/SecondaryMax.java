package snippets.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SecondaryMax {

    private static <T> T _secondaryMax(T[] array, CompareOperation<T> compareOperation) {
        @SuppressWarnings("unchecked")
        Set<T> set = new HashSet(Arrays.asList(array));
        List<T> list = new ArrayList<>(set);
        T maxT = list.get(0);
        T seT = list.get(1);
        if (compareOperation.compare(maxT, seT) < 0) {
            maxT = returnFirst(seT, seT = maxT);
        }
        for (int i = 3; i < list.size(); ++i) {
            if (compareOperation.compare(seT, list.get(i)) < 0) {
                seT = list.get(i);
            }
            if (compareOperation.compare(maxT, seT) < 0) {
                maxT = returnFirst(seT, seT = maxT);
            }
        }
        return seT;
    }

    static <T extends Comparable<T>> T secondaryMax(T[] array) {
        return _secondaryMax(array, Comparable::compareTo);
    }

    @SuppressWarnings("trick")
    private static <T> T returnFirst(T o1, T o2) {
        return o1;
    }

    static <T> T secondaryMax(T[] array, Comparator<T> comp) {
        return _secondaryMax(array, comp::compare);
    }

    @FunctionalInterface
    private interface CompareOperation<T> {
        int compare(T o1, T o2);
    }
}
