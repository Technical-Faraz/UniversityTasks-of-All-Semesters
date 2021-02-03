import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       LinkedQueue q = new LinkedQueue();
       q.add("faraz");
        q.add("Haris");
        q.add("noor");
        q.add("noos");

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

    }
}
