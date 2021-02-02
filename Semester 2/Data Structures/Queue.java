import java.util.Arrays;
class NodeQ{
    Object data;
    NodeQ prev;
    NodeQ next;
    NodeQ(){
        this.prev = this.next = this;
    }
    NodeQ(Object data,NodeQ prev,NodeQ next){
        this.data =data;
        this.prev = prev;
        this.next = next;
    }
}
public interface Queue{
    void add(Object obj);
    Object first();
    Object remove();
    int size();
}
class ArrayQueue implements Queue {
    private Object[] data;
    private int size;

    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(Object obj) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = obj;
    }

    @Override
    public Object first() {
        return data[0];
    }

    @Override
    public Object remove() {
        if (size != 0) {
            size--;
            Object obj = data[0];
            System.arraycopy(data, 1, data, 0, size);
            return obj;
        }
        throw new NullPointerException("Queue is empty");
    }

    @Override
    public int size() {
        return size;
    }
}
class LinkedQueue implements Queue {

        private NodeQ head = new NodeQ(); // dummy node
        private int size;

        @Override
        public void add(Object obj) {
                head.prev.next = new NodeQ(obj, head.prev, head);
                head.prev = head.prev.next;
                ++size;
        }

        @Override
        public Object first() {
            if (size == 0) {
                throw new java.util.EmptyStackException();
            }
            return head.next.data;
        }

        @Override
        public Object remove() {

            if (size == 0) {
                throw new java.util.EmptyStackException();
             }
            Object element = head.next.data; // next <--> prev
            head.next = head.next.next; // next <--> prev
            head.next.prev = head; // next <--> prev
            --size;
            return element;
        }
        @Override
        public int size() {
            return 0;
        }
}