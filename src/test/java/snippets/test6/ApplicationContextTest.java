package snippets.test6;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import snippets.test6.entity.Student;

import java.util.Date;

public class ApplicationContextTest {

    @Test
    public void parse2JSON() {
        Student student = new Student("Wang", 18, new Date(System.currentTimeMillis()));
        System.out.println(JSON.toJSON(student));
    }
}