package snippets.test3;

import org.junit.Test;
import snippets.test2.Sequence;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class SequenceGeneratorTest {
    @Test
    public void next() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            SequenceGenerator sg = new SequenceGenerator();
            for (int i = 0; i < 10; ++i) {
                    System.out.println("key - " + sg.next(1, 10));
            }
        });
        executorService.execute(() -> {
            SequenceGenerator sg = new SequenceGenerator();
            for (int i = 0; i < 10; ++i) {
                System.out.println(sg.next(3, 9));
            }
        });
        executorService.shutdown();
    }

}