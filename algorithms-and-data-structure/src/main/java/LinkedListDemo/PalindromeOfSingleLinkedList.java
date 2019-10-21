package LinkedListDemo;

public class PalindromeOfSingleLinkedList {
    public Node head = new Node();
    public static void main(String[] args) {

    }

    /**
     * 生成单链表
     */
    public Node genSingleLinkedList(String str) {
        Node p = head;
        Node tmp;
        for (int i = 0; i < str.length(); i++) {
            tmp = new Node();
            tmp.data = String.valueOf(str.charAt(i));
            p.next = tmp;
            p = p.next;
        }
        return head;
    }

    /**
     * 单链表反转
     * @return
     */
    public Node reverseLinkedList(){
        Node p = head.next;
        Node pre = null;
        Node post = null;
        while(p != null){
            post = p.next;
            p.next = pre;
            pre = p;
            p = post;
        }
        head.next = pre;
        return head;

    }

    /**
     * 判断链表是否是回文串
     * @return
     * @throws Exception
     */
    public boolean isPalindrome() throws Exception{
        //快慢指针，快指针每次走两个node，慢指针每次走1个node
        Node fast = head.next;
        Node slow = head.next;
        Node pre=null,post;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            //慢指针还要负责反转单链表
            //  a1 --> a2 --> a3   |  a1 <-- a2 <-- a3
            post = slow.next;
            slow.next = pre;
            pre = slow;
            slow = post;
        }
        //这种情况下有奇数个节点，这种情况下慢节点要指向它的前1个节点
        if(fast.next == null){
            fast = slow.next;
            slow = pre;
        }else{
            fast = slow.next;
            slow.next = pre;
        }

        while(slow !=null && fast !=null) {
            if(!slow.data.equals(fast.data)){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        if(slow!=null || fast !=null){
            throw new Exception("程序错误！");
        }



        return true;
    }

    /**
     * 输出链表内容
     * @return
     */
    @Override
    public String toString() {
        Node p = head.next;
        StringBuilder sb = new StringBuilder();
        while (p!=null){
            sb.append(p.data);
            p= p.next;
        }
        return sb.toString();
    }
}

/**
 * 单链表节点
 */

class Node {
    String data;
    Node next;
    public Node(){}
    public Node(String data) {
        this.data = data;
    }
    public Node(String data,Node next) {
        this(data);
        this.next = next;
    }
}


