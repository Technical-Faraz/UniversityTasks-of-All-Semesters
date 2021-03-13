//Created by 19sw05
//Faraz Ahmed


//Please create the following methods in both ArrayStack and LinkedStack
//toString(): to convert all data in one string.
//equals(): for comparing two stacks.
//findlast(): return the last element of s  tack.
//        Two more methods
//
//        ArrayStack toArrayStack() method in LinkedStack class which returns ArrayStack.
//        LinkedStack toLinkedStack() method in ArrayStack class which returns LinkedStack.

import java.util.Arrays;

public interface Stack{
    void push(Object obj);
    Object pop();
    Object peek();
    boolean isEmpty();
    int getLength();
}
class Node{
    Object data;
    Node next;
    Node(){
    }
    Node(Object data){
        this.data = data;
    }
    Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }
}
//---------------------------------------------------------------------------------------------------------------
class LinkedStack implements Stack{
    private int size;
    private Node top;
    LinkedStack(){
           size = 0;
           top = null;
    }
    @Override
    public boolean isEmpty(){
        return (this.top == null);
    }
    public void push(Object obj) {
        Node newNode = new Node(obj, top);
        top = newNode;
        size++;
    }

    @Override
    public Object pop() {
        if(this.top == null){throw new NullPointerException("Stack Empty");}
        else {
            Object obj = top.data;
            top = top.next;
            return obj;
        }
    }

    @Override
    public Object peek() {
        if(this.top == null){throw new NullPointerException("Stack Empty");}
        else {
            return top.data;
        }
    }

    @Override
    public int getLength() {
        return size;
    }
//    public String toString(){
//        String full ="";
//        full+="[ ";
//        for(Node n = top; n != null; n = n.next){
//            full+=n.data +" ,";
//        }
//        full += " ]";
//        return full;
//    }
    //Print like a stack
    public String toString(){
        String full ="";
        for(Node n = top; n != null; n = n.next){
            full += "|"+ n.data +"\t|\n";
        }
        full += "---------";
        return full;
    }
    public boolean equals(LinkedStack s){
        boolean isEqual = true;
        if(this.size == s.size) {
            for (Node n1 = top, n2 = s.top; n1 != null; n1 = n1.next, n2=n2.next) {
                if(n1.data != n2.data){
                    isEqual = false;
                    break;
                }
            }
            return isEqual;
        }else {
            return false;
        }
    }
    public Object findLast(){
        Node n;
        for(n = top; n.next != null; n = n.next){
        }
        return n.data;
    }
//    public ArrayStack toArrayStack(){
//        ArrayStack s = new ArrayStack();
//        Object[] arr = new Object[size];
//        int i =0;
//        for(Node n = top; n != null; n = n.next, i++){
//            arr[i] = n.data;
//        }
//        for(i = size-1 ; i > -1;i--){
//            s.push(arr[i]);
//        }
//        return s;
//    }
    public ArrayStack toArrayStack(){
        ArrayStack s = new ArrayStack();
        Object[] arr = new Object[size];
        int i =0;
        for(Node n = top; n != null; n = n.next, i++){
            arr[i] = n.data;
        }
        for(i = size-1 ; i > -1;i--){
            s.push(arr[i]);
        }
        return s;
    }
}
//---------------------------------------------------------------------------------------------------------------
class ArrayStack implements Stack {
    private int top;
    private Object[] data;
    ArrayStack() {
        top = -1;
        data = new Object[2];
    }
    @Override
    public void push(Object obj) {
        if(top == data.length-1){
            data = Arrays.copyOf(data,data.length*2);
        }
        data[++top] = obj;
    }

    @Override
    public Object pop() {
        if(this.isEmpty()){throw new NullPointerException("Stack Empty");}
        else{
            return data[top--];
        }
    }

    @Override
    public Object peek() {
        if(this.isEmpty()){
            return "Null";
        }
        else{
            return data[top];
        }
    }

    @Override
    public boolean isEmpty() {
        return(top == -1);

    }

    @Override
    public int getLength() {
        return top+1;
    }
//
//    public String toString(){
//        String full ="";
//        full+="[ ";
//        for(int i = top; i > -1; i--){
//            full += data[i] + ",";
//        }
//        full += " ]";
//        return full;
//    }

    //Print like Stack
    public String toString(){
        String full ="";
        for(int i = top; i > -1; i--){
            full += "|" + data[i] + "\t|\n";
        }
        full += "---------";
        return full;
    }

    public boolean equals(ArrayStack s){
        boolean isEqual = true;
        if(this.top == s.top) {
            for (int i = top ; i > -1;i--) {
                if(this.data[i] != s.data[i]){
                    isEqual = false;
                    break;
                }
            }
            return isEqual;
        }else {
            return false;
        }
    }
    public Object findLast(){
        if(isEmpty())return -1;
        return data[0];
    }
    public LinkedStack toLinkedStack(){
        LinkedStack s = new LinkedStack();
        for(int i = 0; i < top+1; i++){
           s.push(data[i]);
        }
        System.out.println(s);
        return s;
    }
    //return 2 stacks
    public ArrayStack[] divide(){
        ArrayStack[] stacks = new ArrayStack[2];
        stacks[0] = new ArrayStack();
        stacks[1] = new ArrayStack();
        int twoPart = top/2;
        for(int i = top; i > twoPart; i--){
            stacks[1].push(data[i]);
        }
        for(int i = twoPart; i > -1; i--){
            stacks[0].push(data[i]);
        }
        return stacks;
    }
}

class Main2 {
    public static void main(String[] args) {
        ArrayStack a = new ArrayStack();
        ArrayStack[] b;
        a.push("faraz");
        a.push("Saad");
        a.push("haris");
        a.push("noor");
        System.out.println(a);
        b = a.divide();
        System.out.println(b[0]);
        System.out.println(b[1]);

    }
}

