package snippets.test3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public final class SequenceGenerator {

    private AtomicInteger key;

    public synchronized String next(int start, int delta) {
        if (key == null) {
            key = new AtomicInteger(start);
        }

        return Integer.toString(key.getAndAdd(delta));
    }

}
