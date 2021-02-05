//Before submitting this file add definition of NodeQ from Queue class
interface Iterator{
    boolean hasNext();
    Object next();
    boolean remove();

}
public interface Collection{
    boolean add(Object object);
    void clear();
//    boolean contains(Object object);
    boolean isEmpty();
    Iterator iterator();
    boolean remove(Object object);
    int size();
}

abstract class AbstractCollection implements Collection{
    protected AbstractCollection(){

    }
    public boolean add(Object object){
        throw new UnsupportedOperationException();
    }
    public boolean isEmpty(){
        return(size()==0);
    }
    public abstract Iterator iterator();

    public boolean remove(Object object){
        Iterator it=iterator();
        if(object==null)
            while(it.hasNext()){
                if(it.next()==null){
                    it.remove();
                    return true;

                }
            }
        else
            while (it.hasNext())
                if(object.equals(it.next())){
                    it.remove();
                    return true;
                }
        return false;


    }
    public abstract int size();
//    public boolean contains(Object object){
//
//    }
    public String toString(){
        if (isEmpty()) return "[]";
        Iterator it=iterator();
        StringBuffer buf=new StringBuffer("[" + it.next());
        while(it.hasNext())
            buf.append("," + it.next());
        return (buf+"]");
    }
    public void clear(){
        for(Iterator it=iterator(); it.hasNext();){
            it.next();
            it.remove();}
    }
}

class ArrayCollection extends AbstractCollection{
    private final int INITIAL_LENGTH=15;
    private int size;
    private Object[] a= new Object[INITIAL_LENGTH];

    public boolean add(Object object){
        if(size==a.length) resize();
        a[size++]= object;
        return true;
    }
    public int size(){
        return size;
    }
    public Iterator iterator(){
        return new Iterator()
        {
            private int i=0; //index of current element
            private boolean okToRemove=false;

            public boolean hasNext(){
                return(i<size);
            }
            public Object next(){
                if (i==size) throw new RuntimeException();
                okToRemove=true;
                return a[i++];
            }
            public boolean remove(){
                if(!okToRemove) throw new IllegalStateException();
                a[--i]=a[--size];
                a[size]=null;
                okToRemove=false;
                return true;
            }
        };
    }
    private void resize(){
        Object[] aa =a;
        a= new Object[2*aa.length];
        System.arraycopy(aa,0,a,0,size);
    }
}
class LinkedCollection extends AbstractCollection{
    private int size;
    private NodeQ head;         //This class definition is in other file
    LinkedCollection(){
        size = 0;
        head = new NodeQ();
    }
    public boolean add(Object obj) {
        head.prev.next = new NodeQ(obj, head.prev, head);
        head.prev = head.prev.next;
        ++size;
        return true;
    }
    @Override
    public Iterator iterator() {
        return new Iterator() {
            int count = 0;
            NodeQ current = head.next;
            Boolean okToRemove = false;
            @Override
            public boolean hasNext() {
                return (count < size);
            }

            @Override
            public Object next() {
                if(size == count) throw new RuntimeException("Collection hasn't anything in next");
                okToRemove = true;
                Object data = current.data;
                current = current.next;
                count++;
                return data;
            }

            @Override
            public boolean remove() {
                if(!okToRemove)throw new RuntimeException("Not ok to remove");
                NodeQ last = head.prev;
                current = current.prev;
                current.prev.next = last;
                current.next.prev = last;
                head.prev = head.prev.prev;
                last.prev = current.prev;
                last.next = current.next;
                current = current.prev;
                size--;
                return true;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }
}

class TestCollection{
    public static void main(String[] args) {
        Collection c = new LinkedCollection();
        c.add("faraz");
        c.add("ritik");
        c.add("Haris");
        c.add("Noor");
        c.add("saad");
        c.remove("Haris");
        System.out.println(c);
        Iterator i = c.iterator();
        System.out.println(i.next());
        System.out.println(i.remove());
        System.out.println(c);

    }
}
