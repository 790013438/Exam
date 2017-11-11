package snippets.test4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListTest {

    @Test
    public void testAdd() {
        MyArrayList list = new MyArrayList();
        System.out.println(list.add(3));
    }

    @Test
    public void testRemove() {
        MyArrayList list = new MyArrayList();
        list.add(3);
        list.remove(0);
    }

    @Test
    public void testInsert() {
        MyArrayList list = new MyArrayList();
        list.add(0, 3);
    }

    @Test
    public void testGet() {
        MyArrayList list = new MyArrayList();
        list.add(3);
        list.get(0);
    }

    @Test
    public void clear() {
        MyArrayList list = new MyArrayList();
        list.add(3);
        list.clear();
    }
}