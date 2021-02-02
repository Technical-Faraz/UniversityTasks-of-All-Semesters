
//Made by Faraz Ahmed 19sw05
//        1. int sum(NodeI list) : returns sum of all elements in list
//        2. NodeI copy(NodeI list): returns a new list with same elements
//        3. NodeI concat(NodeI list1, NodeI list2): a new list that contains elements from list1 and list2.
//        4. void swap(NodeI list, int i, int j): swap elements at ith and jth positions.
class NodeI{
    int data;
    NodeI next;
    NodeI(){
    }
    NodeI(int data){
        this.data = data;
    }
    NodeI(int data, NodeI next){
        this.data = data;
        this.next = next;
    }
}
public class LinkedList {
    private NodeI tail;
    private int length;
    private NodeI head;
    private String name;
    //Constructors
    LinkedList(){
    }
    LinkedList(String name){
        tail = new NodeI();
        head = tail;
        this.name = name;
    }
    //Methods
    public int getLength(){
        return length;
    }
    public void add(int val){
        length++;
            NodeI newNodeI = new NodeI();
            newNodeI.data = val;
            if(length == 1){
                tail = newNodeI;
                head = tail;
            }else
                {
                tail.next = newNodeI;
                tail = newNodeI;
            }
    }
    public void disp(){
        for(NodeI current =head; current != null; current = current.next){
            System.out.println(name+ ": "+current.data);
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------
//      1. int sum(NodeI list) : returns sum of all elements in list
    public int sum(){
        int sum=0;
        for(NodeI current =head; current != null; current = current.next){
            sum += current.data;
        }
        return sum;
    }
    //---------------------------------------------------------------------------------------------------------------------------------

//`````````````````````````````````````````````Copy Methods of LinkedList`````````````````````````````````````````````````
    //Copy method 3 forms
    public LinkedList copy(){       //returns linkedlist
        LinkedList dest = new LinkedList();
        for(NodeI current =head; current != null; current = current.next){
            dest.add(current.data);
        }
        return dest;
    }
//    public void copy(LinkedList src){       //can create a copy by taking input of another linkedlist
//        for(NodeI current =src.head; current != null; current = current.next){
//            this.add(current.data);
//        }
//    }
    public static void copy(LinkedList src, LinkedList dest){       //Simply it is a class method used to copy linkedlist
        for(NodeI current =src.head; current != null; current = current.next){
            dest.add(current.data);
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    //        2. NodeI copy(NodeI list): returns a new list with same elements
    public static LinkedList copy(LinkedList src){       //return LinkedList to dest
        LinkedList dest = new LinkedList();
        for(NodeI current =src.head; current != null; current = current.next){
            dest.add(current.data);
        }
        dest.name = "dest";
        return dest;
    }
//``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
    //        3. NodeI concat(NodeI list1, NodeI list2): a new list that contains elements from list1 and list2.
    public static LinkedList concat(LinkedList l1, LinkedList l2){
        LinkedList newList;
        newList = LinkedList.copy(l1);
        newList.tail.next = l2.head;
        newList.length += l2.length;
        newList.name = "concatenated";
        return newList;
    }
//        4. void swap(NodeI list, int i, int j): swap elements at ith and jth positions.
    public static LinkedList swap(LinkedList src, int i, int j) {
        NodeI n1 = null;
        NodeI n2 = null;
        int count=0;
        //swapping by index
        for (NodeI current = src.head; current != null; current = current.next) {
            count++;
            if (count-1 == i) {
                n1 = current;
            }
            if (count-1 == j) {
                n2 = current;
            }
            if (n1 != null && n2 != null) break;
        }
        n1.data += n2.data;
        n2.data = n1.data - n2.data;
        n1.data -= n2.data;
        return src;
    }


    public int accessByIndex(int i){
        int count=0;
        boolean found = false;
        for(NodeI current =head; current != null; current = current.next){
            if(count == i){
                found =true;
                return current.data;
            }
            count++;
        }
        return -1;
    }


    public void insert(int val){       //enter it by ascending
        NodeI newNodeI = new NodeI();
        newNodeI.data = val;
        newNodeI.next=null;
        NodeI current =head;
        while (current.next != null){
            if(current.next.data > val) break;
            current = current.next;
        }
        current.next =new NodeI(val, current.next);
    }

}
class Main1{
    public static void main(String[] args){
        //Intialization
        LinkedList src = new LinkedList("src");
       LinkedList l2 = new LinkedList("l2");
       LinkedList dest = new LinkedList("dest");
       LinkedList combinedList;
        for(int i = 7; i < 60; i += 7){
            src.add(i);
        }
        for(int i = 5; i < 50; i += 5){
            l2.add(i);
        }
        src.disp();
        System.out.println("Total # of elements is : " + src.getLength());

//`````````````````````````````````````````````Copy of LinkedList`````````````````````````````````````````````````
        //Implementation of 3 forms of copy method, uncomment to check it
        //dest = src.copy();
        dest = LinkedList.copy(src);
        //LinkedList.copy(src,dest);
        dest.disp();

//`````````````````````````````````````````````Sum of LinkedList's Elements`````````````````````````````````````````````````
        System.out.println("Sum of dest elements is : " + dest.sum());

//`````````````````````````````````````````````Concat 2 LinkedLists`````````````````````````````````````````````````
        combinedList = LinkedList.concat(src,l2);
        combinedList.disp();
        System.out.println("Total # of elements is : " + combinedList.getLength());

//`````````````````````````````````````````````Swapping of elements of LinkedList`````````````````````````````````````````````````
        System.out.println("After swapping of src elements");
        src = LinkedList.swap(src,1,4);
        src.disp();


        System.out.println(src.accessByIndex(2));

//`````````````````````````````````````````````Insertion of element in a LinkedList`````````````````````````````````````````````````
        System.out.println("Before Insertion");
        dest.disp();
        dest.insert(12);
        System.out.println("After Insertion");
        dest.disp();
    }
}