public class RPN {
        Stacks stack = new ArrayStack();
    public RPN(String[] args){
        for(int i = 0; i < args.length; i++){
            String input = args[i];
            if(isOperator(input)){
                String z;
                double y = Double.parseDouble((String)stack.pop());
                double x = Double.parseDouble((String)stack.pop());
                z = evaluate(x,y,input);
                stack.push(z);
            }else {
                stack.push(input);
            }
        }
    }
    public boolean isOperator(String s){
        if(s.length() == 1 && "+-*/".indexOf(s)>=0){
            return true;
        }
        return false;
    }
    public String evaluate(double x , double y, String input){
        double z = 0;
        if(input.equals("+"))z = x + y;
        if(input.equals("-"))z = x - y;
        if(input.equals("*"))z = x * y;
        if(input.equals("/"))z = x / y;
        System.out.println(x + " " + input + " " + y + "=" + z);
        return Double.toString(z);
    }
}
class MainRPN {
    public static void main(String[] args) {
        String s = "2 3 + 5 6 2 / - *";
        String[] d = s.split(" ");
        new RPN(d);
    }
}
