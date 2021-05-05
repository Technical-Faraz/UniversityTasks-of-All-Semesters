public class avltree{
    private int key,height;
    private avltree left,right;
    public static final avltree NIL= new avltree();

    public avltree(int key){
        this.key=key;
        left=right=NIL;
    }

    public avltree(){
        left=right=this;
        height=-1;
    }
    public avltree(int key, avltree left, avltree right){
        this.key=key;
        this.left=left;
        this.right=right;
        height= 1+ Math.max(left.height,right.height);
    }
    public int size()
    {
        if(this==NIL) return 0;
        return 1+ left.size() +right.size();
    }
    public String toString(){
        if(this==NIL) return "";
        return  left + " " + key + " " +right;  //inorder
//        return key + " " + left + " " + right; //preorder
    }

    public boolean add(int key){
        int oldSize= size();
        grow(key);
        return size()>oldSize;
    }
    public avltree grow(int key){
        if(this==NIL) return new avltree(key);
        if(key==this.key) return this; //avoid key duplication
        if(key<this.key) left=left.grow(key);
        else
            right=right.grow(key);
        rebalance();
        height= 1+ Math.max(left.height, right.height);
        return this;
    }
    public void rebalance(){
        if(this.left.height > this.right.height + 1){
            if(left.right.height > left.left.height){
                left.rotateLeft();
            }
            this.rotateRight();
        }
        else if(this.right.height > this.left.height + 1){
            if(left.right.height > left.left.height){
                left.rotateRight();
            }
            this.rotateLeft();
        }
    }
    public void rotateLeft(){
        this.left = new avltree(this.key, this.left, this.right.left);
        this.key = right.key;
        right = right.right;

    }
    public void rotateRight(){
        this.right = new avltree(this.key, this.left.right,this.right);
        this.key = left.key;
        left = left.left;
    }
}
class test{
    public static void main(String[] args) {
        avltree f = new avltree(6);
        avltree d = new avltree(1);
        avltree c = new avltree(3);
        avltree b = new avltree(2,d,c);
        avltree a = new avltree(5,b,f);

//        avltree f = new avltree(6);
//        avltree c = new avltree(3);
//        avltree e = new avltree(4);
//        avltree b = new avltree(2);
//        avltree d = new avltree(1);
//        a.add(2);
//        a.add(6);
//        a.add(1);
//        a.add(3);
//        a.add(4);
        System.out.println(a);
        a.add(4);
        System.out.println(a);

    }
}
