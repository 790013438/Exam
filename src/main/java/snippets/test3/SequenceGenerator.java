package snippets.test3;

import java.util.concurrent.atomic.AtomicLong;

final class SequenceGenerator {

    private AtomicLong key;

    String next(int start, int delta) {
        if (key == null) {
            key = new AtomicLong(start);
        }

        return Long.toString(key.getAndAdd(delta));
    }

}
