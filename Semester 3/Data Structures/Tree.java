//Made by 19sw05 Faraz Ahmed
//GitHub@ Technical-Faraz
//YouTube@ TechnicalFarazOfficial
//TechnicalFaraz.com

public class Tree {
    Tree left;
    Tree right;
    Entry e;
    public class Entry{
        Object data;
        String key;
        Entry(Object data, String key){
            this.data = data;
            this.key = key;
        }
    }
    Tree(Object data,String k, Tree l, Tree r){
        e = new Entry(data,k);
        left = l;
        right = r;
    }
    Tree(Object data,String k){
        this(data,k,null, null);
    }

    @Override
    public String toString() {  //In Order
        StringBuffer inorder= new StringBuffer();
        inorder.append(e.data + "\n");
        if(this.left != null)inorder.append(left);
        if(this.right != null)inorder.append(right);
        return inorder.toString();
    }
    public String preOrder() {  //Pre Order
        StringBuffer preorder= new StringBuffer();
        if(this.left != null)preorder.append(left.preOrder());
        preorder.append(e.data);
        if(this.right != null)preorder.append(right.preOrder());
        return preorder.toString();
    }
    public String postOrder() {  //Post Order
        StringBuffer postorder= new StringBuffer();
        if(this.left != null)postorder.append(left.postOrder());
        if(this.right != null)postorder.append(right.postOrder());
        postorder.append(e.data);
        return postorder.toString();
    }
    public int size(){
        if(this.left != null && this.right != null)
            return 1 + this.left.size() + this.right.size();
        if(this.left != null)return 1 + this.left.size();
        if(this.right != null)return 1 + this.right.size();
        return 1;
    }
    public int height(){
        int leftH=0 , rightH=0;
        if(this.left != null)leftH = 1 + this.left.height();
        if(this.right != null)rightH = 1 + this.right.height();
        return (leftH > rightH)?leftH:rightH;
    }
    public boolean contains(Object obj){
        if(e.data == obj){
            return true;
        }
        boolean containing = false;
        if(this.left != null){
            containing = left.contains(obj);
        }
        if(this.right != null && containing == false){
            containing = right.contains(obj);
        }
        return containing;
    }
    public boolean isLeaf(){
        return (this.right == null && this.left == null)?true:false;
    }
    public void insert(Object d,String k){
        if(e.key.compareTo(k) > 0){
            if(left == null)left = new Tree(d,k);
            left.insert(d,k);
        }
        else if(e.key.compareTo(k) < 0){
            if(right == null)right = new Tree(d,k);
            right.insert(d,k);
        }
    }
    public void insert(Tree t){      //Node insert
        if(e.key.compareTo(t.e.key) > 0){
            if(left == null)left = new Tree(t.e.data,t.e.key);
            left.insert(t);
        }
        else if(e.key.compareTo(t.e.key) < 0){
            if(right == null)right = new Tree(t.e.data,t.e.key);
            right.insert(t);
        }
    }
    public Tree delete(Tree t, String k){
        if(t == null)return null;

        if((t.e.key).compareTo(k)  >0){
            t.left = delete(t.left,k);
        }
        else if((t.e.key).compareTo(k) < 0){
            t.right = delete(t.right,k);
        }
        else {
            if (t.left == null || t.right == null) {
                Tree temp;
                temp = t.left == null ? t.right : t.left;
                if (temp == null)return null;
                else return temp;
            }
            else{
                Tree successor = getSuccessor(t);
                t.e.data = successor.e.data;
                t.right = delete(t.right,successor.e.key);
            }
        }
        return t;
    }
    public Tree getSuccessor(Tree t){
        if(t == null)return null;
        Tree temp = t.right;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }
    public Object search(Tree t,String k){
        if(this == null)return null;

        if((t.e.key).compareTo(k)  >0){
            if(t.left != null)
                return search(t.left,k);
            else
                return null;
        }
        else if((t.e.key).compareTo(k) < 0){
            if(t.right != null)
                return search(t.right,k);
            else
                return null;
        }
        else{
            return t.e.data;
        }
    }
}
class testTree{
    public static void main(String[] args) {
        Tree te = new Tree("eon","e");
        Tree tc = new Tree("can","c");
//        Tree tb = new Tree("ban","b",null,tc);
//        Tree ta = new Tree("ant","a",null,tb);
        Tree tb = new Tree("ban","b");
        Tree ta = new Tree("ant","a");
        Tree td = new Tree("den","d");

//        System.out.println(ta.contains("man"));
//        System.out.println(ta.contains("set"));
//        System.out.println(ta.contains("ban"));
//        System.out.println(ta.contains("a"));
        td.insert(tb);
        td.insert(ta);
        td.insert(tc);
        td.insert(te);

        System.out.println(td);
        td.insert("hen","h");
        td.insert("fan","f");
        td.insert("gun","g");
        td.insert("ion","i");

        System.out.println("starting");
        System.out.println(td);
        td.delete(td,"c");
        System.out.println(td);
//        td.delete(td,"h");
//        System.out.println(td);

        td.delete(td,"d");
        System.out.println(td);

        td.delete(td,"i");
        System.out.println(td);

        System.out.println(td.search(td,"f"));

    }
}
