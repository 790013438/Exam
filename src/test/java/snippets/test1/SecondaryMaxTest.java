package snippets.test1;

import org.junit.Assert;
import org.junit.Test;
import snippets.test1.SecondaryMax;

import java.util.Comparator;

public class SecondaryMaxTest {

    @Test
    public void testSecondaryMax() {
        String[] str = {"Zero", "pineapple", "tomato", "spell", "apache", "zero", "zoo"};
        Assert.assertEquals("zero", SecondaryMax.secondaryMax(str));

        Integer[] src = new Integer[]{5,22,22,5};
        System.out.println(SecondaryMax.secondaryMax(src));

        Dry[] dryArray = {new Dry(5, "ha"), new Dry(22, "ta"), new Dry(22, "ta")};
        System.out.println(SecondaryMax.secondaryMax(dryArray, new Comparator<Dry>() {
            @Override
            public int compare(Dry o1, Dry o2) {
                if (o1.id == o2.id)
                    return o1.name != null ? o1.name.compareTo(o2.name) : -1;

                return o1.id - o2.id;
            }
        }));
    }

    class Dry {
        int id;
        String name;

        public Dry() {
        }

        public Dry(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Dry dry = (Dry) o;

            if (id != dry.id) return false;
            return name != null ? name.equals(dry.name) : dry.name == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Dry{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
