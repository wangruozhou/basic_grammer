package LinkedListDemo;

/**
 * 链表的常用操作
 * 1. 链表反转
 * 2. 两个有序单链表的合并
 * 3. 检查链表是否有环      --找文档看一下
 * 4. 求链表的中间节点      --快慢指针
 * 5. 删除倒数第i个节点     --遍历一遍求出链表的个数，倒数第i个就是正数第(n-i)+1个
 */
public class LinkedListPractice {
    Node head;
    Node tail;

    public LinkedListPractice() {
        head = new Node();
        tail = head;
    }

    public LinkedListPractice add(Node node) {
        tail.next = node;
        tail = tail.next;
        return this;
    }

    /**
     * 1. 链表反转，遍历所有节点，然后把节点利用头插法重新插入到链表中
     */
    public void reverse() {
        Node p = head.next;
        Node tmp;
        while (null != p) {
            tmp = p.next;
            p.next = head.next;
            head.next = p;
            p = tmp;
        }
    }

    /**
     * 2. 两个有序单链表的合并
     * 以head1链表作为基底，把head2链表往head1上合
     *
     * @param head1
     * @param head2
     * @return
     */
    public Node merge2List(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2.next;
        Node tmp;
        while (p1.next != null && p2 != null) {
            if (p1.next.data.compareTo(p2.data) <= 0) {
                p1 = p1.next;
            } else {
                tmp = p2.next;
                p2.next = p1.next;
                p1.next = p2;
                p1 = p1.next;
                p2 = tmp;
            }
        }
        if (p2 != null) {
            p1.next = p2;
        }
        return head1;
    }

    /**
     * 删除倒数第i个节点
     *
     * @param i
     * @return
     */
    public boolean deleteNodeFromEnd(int i) {
        Node p = head.next;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        if (i > length) return false;
        int index = 0;
        p = head;
        while (index != length - i) {
            p = p.next;
        }
        p.next = p.next.next;
        return true;
    }

    /**
     * 判断是否有环
     * 快慢指针，p1每次走1格，p2每次走2格，如果有环两个指针必定相遇，并且时间复杂度为O(n)
     *
     * @return
     */
    public boolean hasCircle() {
        Node p1, p2;
        p1 = p2 =head;
        while (null != p1 && p2 !=null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node p = head.next;
        while (null != p) {
            sb.append(p.data).append(",");
            p = p.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
