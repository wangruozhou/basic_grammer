package LinkedListDemo;

/**
 * 用linkedList实现LRU算法
 * LRU缓存算法：最近最少使用
 * 新加入节点，做如下判断
 * 1.新节点已存在，删除原来节点，在链表头部插入新节点；
 * 2. 新节点不存在，又分两种情况
 * 2.1 缓存已满，删除链表尾部节点，链表头部插入新节点
 * 2.2 缓存不满，链表头部插入新节点
 */
public class LRULinkedList {
    public Node head;
    public int size;
    public static final int MAX_LENGTH = 5;

    public LRULinkedList() {
        head = new Node();
    }

    /**
     * 检查链表中是否存在值为data的节点，然后返回其前驱节点
     * @param data
     * @return
     */
    public Node findDataPreNode(String data) {
        Node p = head;
        while (p.next != null) {
            if (p.next.data.equals(data)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     *
     * @param data
     * @return
     */
    public boolean dataExist(String data) {
        Node pre = findDataPreNode(data);
        if(pre == null) return false;
        return true;
    }
    /**
     * 在缓存中添加数据，按照LRU算法
     * @param data
     * @return
     */
    public boolean addData(String data) {
        if(dataExist(data)){
            delNode(data);
            insertDataFromHead(data);
        }else {
            if(size < MAX_LENGTH){
                insertDataFromHead(data);
            }else {
                delTailNode();
                insertDataFromHead(data);
            }
        }
        return true;
    }

    /**
     * 在头节点插入数据
     * @param data
     */
    public boolean insertDataFromHead(String data) {

        Node node = new Node(data);
        node.next = head.next;
        head.next = node;
        ++size;
        return true;
    }

    /**
     * 删除值为data的节点
     * @param data
     * @return
     */
    public boolean delNode(String data) {
        Node preNode = findDataPreNode(data);
        if(preNode == null){
            return false;
        }
        preNode.next = preNode.next.next;
        size--;
        return true;
    }

    /**
     * 删除尾节点
     * @return
     */
    public boolean delTailNode(){
        if(--size<0) return false;
        Node p = head;
        while(p.next != null && p.next.next != null){
            p = p.next;
        }

        p.next = null;

        return true;
    }

    public String printList() {
        Node p = head.next;
        StringBuilder sb = new StringBuilder();
        while(p!=null){
            sb.append(p.data+",");
            p = p.next;
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
