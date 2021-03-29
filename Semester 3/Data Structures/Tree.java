
public class Tree {
    Object data;
    Tree left;
    Tree right;
    Tree(Object data, Tree l, Tree r){
        this.data = data;
        left = l;
        right = r;
    }
    Tree(Object data){
        this(data,null, null);
    }

    @Override
    public String toString() {  //In Order
        StringBuffer inorder= new StringBuffer();
        inorder.append(this.data);
        if(this.left != null)inorder.append(left);
        if(this.right != null)inorder.append(right);
        return inorder.toString();
    }
    public String preOrder() {  //Pre Order
        StringBuffer preorder= new StringBuffer();
        if(this.left != null)preorder.append(left.preOrder());
        preorder.append(this.data);
        if(this.right != null)preorder.append(right.preOrder());
        return preorder.toString();
    }
    public String postOrder() {  //Post Order
        StringBuffer postorder= new StringBuffer();
        if(this.left != null)postorder.append(left.postOrder());
        if(this.right != null)postorder.append(right.postOrder());
        postorder.append(this.data);
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
        if(data == obj){
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
}
class testTree{
    public static void main(String[] args) {
        Tree td = new Tree("d");
        Tree te = new Tree("e");
        Tree tb = new Tree("b",td,te);
        Tree tc = new Tree("c");
        Tree ta = new Tree("a",tb,tc);
        System.out.println(ta.contains("b"));
        System.out.println(ta.contains("e"));
        System.out.println(ta.contains("s"));
        System.out.println(ta.contains("a"));
    }
}
