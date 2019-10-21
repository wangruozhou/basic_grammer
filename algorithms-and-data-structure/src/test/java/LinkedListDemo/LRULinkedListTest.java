package LinkedListDemo;

import org.junit.Test;

import java.util.Random;

public class LRULinkedListTest {
    @Test
    public void testLRU() {
        LRULinkedList lru = new LRULinkedList();
        Random random = new Random();
        int a;
        for(int i=0;i<10;i++) {
            a = random.nextInt(20);
            System.out.println(a);
            lru.addData(a+"");
        }
        System.out.println(lru.printList());

    }

}
