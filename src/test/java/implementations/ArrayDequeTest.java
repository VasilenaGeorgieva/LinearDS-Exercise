package implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        System.out.println(deque.remove(Integer.valueOf(22)));
    }
}