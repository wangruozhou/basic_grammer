public class QueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue("a");
    }


}

class ArrayQueue {
    //要有数组 items，数组大小capacity
    String[] items;
    int capacity;
    //队头指针 head，队尾指针 tail
    int head, tail;

    //初始化，创建数组
    ArrayQueue(int capacity){
        items = new String[capacity];
        this.capacity = capacity;
        head = 0;
        tail = 0;
    }

    /**
     * 入队操作
     * 1. 判断队列是否已满
     */
    public boolean enqueue(String value){
        if(tail == capacity) return false;
        items[tail] = value;
        ++tail;
        return true;
    }
    /**
     * 出队操作
     * 1、判断队列中是否有元素
     */
    public String dequeue(){
        if(head == tail) return null;
        String result = items[head];
        ++head;
        return result;
    }
}
