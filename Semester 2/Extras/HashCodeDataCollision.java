public class HashCodeDataCollision {
    //hashCode Data collision
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
    }
}
