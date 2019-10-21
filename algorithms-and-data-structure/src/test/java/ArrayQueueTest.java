import org.junit.Test;

public class ArrayQueueTest {
    @Test
    public void testQueue() {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
