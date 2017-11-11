package snippets.test5;

import org.junit.Test;

import java.io.IOException;

public class HTTPServerTest {

    @Test
    public void testDoGet() throws IOException {
        new HTTPServer().doGet();
    }
}