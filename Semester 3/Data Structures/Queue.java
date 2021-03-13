// Roll # 19sw 05
// Name Faraz Ahmed
//  Reverse method is implemented in both type of queues

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
    private final int DEFAULT_SIZE = 10;
    public ArrayQueue(){
        data = new Object[DEFAULT_SIZE];
        size = 0;
    }
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
    public void reverse(){
        Object obj[] = new Object[size];
        for(int i = 0; i < size; i++){
            obj[i] = this.data[(size-1) - i];
        }
        this.data = obj;
    }
    public String toString(){
        String s ="[ ";
        for(int i = 0; i < size; i++){
            s += data[i] + ", ";
        }
        s += "]";
        return s;
    }
    public boolean equals(ArrayQueue l2){
        boolean isEqual = true;
        if(this.size() == l2.size()){
            for(int i = 0; i < size; i++){
                if(!(data[i].equals(l2.data[i]))){
                    isEqual = false;
                    break;
                }
            }
            return isEqual;
        }
        else return false;
    }
    public ArrayQueue clone(){
        ArrayQueue duplicated = new ArrayQueue();
        if(size != 0){
            for(int i = 0; i < size; i++){
                duplicated.add(data[i]);
            }
        }
        return duplicated;
    }
    public LinkedQueue toLinkedQueue(){
        LinkedQueue duplicated = new LinkedQueue();
        if(size != 0){
            for(int i = 0; i < size; i++){
                duplicated.add(data[i]);
            }
        }
        return duplicated;
    }
    public ArrayStack toStack(){    // first element becomes bottom element and vice versa
        ArrayStack duplicated = new ArrayStack();
        if(size != 0){
            for(int i = 0; i < size; i++){
                duplicated.push(data[i]);
            }
        }
        return duplicated;
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
            return size;
        }

        public void reverse(){
            NodeQ current = head;
            NodeQ temp;
            do{
                temp = current.next;
                current.next = current.prev;
                current.prev = temp;
                current = current.prev;
            }while (current != head);
        }
//        public void pakInsert(Object obj, int index){
//            int count = 0;
//            NodeQ curr = head.next;
//            while()
//        }
    public String toString(){
            String s = "[ ";
            for(NodeQ curr = head.next; curr != head; curr = curr.next){
                s += curr.data + ", ";
            }
            s += " ]";
            return s;
    }
    public boolean equals(LinkedQueue l2){
            boolean isEqual = true;
            if(this.size() == l2.size()){
                for(NodeQ curr = head.next, curr2 = l2.head.next; curr != head; curr = curr.next, curr2 = curr2.next){
                    if(!(curr.data.equals(curr2.data))){
                        isEqual = false;
                        break;
                    }
                }
                return isEqual;
            }
            else return false;
    }
    public LinkedQueue clone(){
            LinkedQueue duplicated = new LinkedQueue();
            for(NodeQ curr = head.next; curr != head; curr = curr.next){
                duplicated.add(curr.data);
            }
            return duplicated;
    }
    public ArrayQueue toArrayQueue(){
        ArrayQueue duplicated = new ArrayQueue();
        for(NodeQ curr = head.next; curr != head; curr = curr.next){
            duplicated.add(curr.data);
        }
        return duplicated;
    }
    public LinkedStack toStack(){  // first element becomes bottom element and vice versa
        LinkedStack duplicated = new LinkedStack();
        for(NodeQ curr = head.next; curr != head; curr = curr.next){
            duplicated.push(curr.data);
        }
        return duplicated;
    }
    public Object[] toArray(){
            Object[] array = new Object[size];
            int index = 0;
        for(NodeQ curr = head.next; curr != head; curr = curr.next){
            array[index++] = curr.data;
        }
        return array;
    }
}

class TestQueue {
    public static void main(String[] args) {
        LinkedQueue aq = new LinkedQueue();
        aq.add("faraz");
        aq.add("Haris");
        aq.add("noor");
        aq.add("ritik");
        System.out.println(aq);
        Object[] names;
        names = aq.toArray();
        System.out.println(names[1]);
        LinkedQueue a = new LinkedQueue();
        System.out.println(a);
        a = aq.clone();
        System.out.println(a);
        System.out.println();

        Stack s;
        s = aq.toStack();
        System.out.println(s.pop());
        System.out.println(s.pop());
        s = a.toStack();
        System.out.println(s);

    }
}
