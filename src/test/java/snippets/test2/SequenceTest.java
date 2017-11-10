package snippets.test2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceTest {
    @Test
    public void isSequence() {
        int[] array = new int[]{2, 3, 4, 5, 6};
        System.out.println(Sequence.isSequence(array));

        int[] array2 = new int[]{1, 2, 3, 4, 5, 8, 7};
        System.out.println(Sequence.isSequence(array2));
    }

}