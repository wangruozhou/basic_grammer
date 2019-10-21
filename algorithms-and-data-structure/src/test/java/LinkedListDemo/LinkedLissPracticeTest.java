package LinkedListDemo;

import org.junit.Test;

public class LinkedLissPracticeTest {
    @Test
    public void test_has_circle() {
        LinkedListPractice linkedList = new LinkedListPractice();
        Node[] node = new Node[5];
        for(int i=0;i<node.length;i++) {
            node[i] = new Node(i+"");
        }
        for(int i=0;i<node.length-1;i++) {
            node[i].next = node[i+1];
        }
        node[node.length-1].next = null;


        linkedList.add(node[0]);
        boolean hasCicle = linkedList.hasCircle();
        System.out.println(hasCicle);
//        System.out.println(linkedList.toString());
//        System.out.println(linkedList.toString());

    }

}
