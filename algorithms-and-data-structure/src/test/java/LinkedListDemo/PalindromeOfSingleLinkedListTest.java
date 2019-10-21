package LinkedListDemo;

import org.junit.Test;

public class PalindromeOfSingleLinkedListTest {
    @Test
    public void genLinkedListTest() {
        PalindromeOfSingleLinkedList linkedList = new PalindromeOfSingleLinkedList();
        Node head = linkedList.genSingleLinkedList("helloolleh");
        Node p = head.next;
        while(p != null) {
            System.out.print(p.data);
            p = p.next;
        }
    }

    @Test
    public void checkPalindrome() {
        PalindromeOfSingleLinkedList linkedList = new PalindromeOfSingleLinkedList();
        linkedList.genSingleLinkedList("zz");
        try {
            System.out.println(linkedList.isPalindrome());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void reverseLinkedListTest() {
        PalindromeOfSingleLinkedList linkedList = new PalindromeOfSingleLinkedList();
        linkedList.genSingleLinkedList("hello");
        linkedList.reverseLinkedList();
        System.out.println(linkedList.toString());
    }

}
