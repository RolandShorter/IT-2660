import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayTest {

    @Test
    public void testGetSize() {
        MyArray<Integer> array = new MyArray<>();
        assertEquals(0, array.getSize());
    }

    @Test
    void testAdd() {
        MyArray<Integer> array = new MyArray<>();
        array.add(5);
        assertEquals(1, array.getSize());
    }

    @Test
    void testInsert() {
        MyArray<Integer> array = new MyArray<>();
        array.add(3);
        array.add(1);
        array.add(1);
        array.add(4, 2);
        assertEquals(4, array.get(2));
        System.out.println(array.printArray());
    }

    @Test
    void testRemove() {
        MyArray<Integer> array = new MyArray<>();
        array.add(3);
        array.add(1);
        array.add(4);
        array.add(1);
        int rem = array.remove(2);
        assertEquals(4, rem);
        MyArray<Integer> expected = new MyArray<>();
        expected.add(3); expected.add(1); expected.add(1);
        assertEquals(expected.printArray(), array.printArray());
        System.out.println(array.printArray() + " removed " + rem);
    }

    @Test
    void testGet() {
        MyArray<Integer> array = new MyArray<>();
        array.add(3);
        array.add(1);
        array.add(4);
        array.add(1);
        assertEquals(4, array.get(2));
    }

    @Test
    void testResize() {
        MyArray<Integer> array = new MyArray<>();
        for ( int i = 0; i < 10; i++ ) {
            array.add(i+1);
        }
        array.add(1);
        assertEquals(11, array.getSize());
        System.out.println(array.printArray());
    }
}