import javax.swing.plaf.PanelUI;

public class HashCodeCracker {
   //hashCode Data collision
//        int sum = 0;
//        public static void checkDataCollision(int lastIndex, int findHash, StringBuilder s){
//            if(lastIndex == 0){
//                for(int i = 0; i < 256; i++){
//                    s.append(((char)i));
//                    if(s.hashCode() == findHash){
//                        System.out.println(s);
//                    }
//                    s.deleteCharAt(lastIndex);
//                }
//            }else {
//                for (int i = 0; i < 256; i++) {
//                    s.append((char)i);
//                    checkDataCollision(--lastIndex,findHash,s);
//                    s.deleteCharAt(0);
//                }
//            }
//        }
        public static void main(String[] args) {
            int generateCode = 2347;
            for (int i = 0; i < 256; i++) {
                for (int j = 0; j < 256; j++) {
                    if (31 * i + j == generateCode) {
                        char a = (char)i;
                        char b = (char)j;
                        System.out.println(a +" " + b);
                    }
                }
            }
            System.out.println("ABC".length());
//            checkDataCollision(2,2347, new StringBuilder());
        }
}
