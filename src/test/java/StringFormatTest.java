/**
 * Created by Jayne on 2018/12/17.
 */
public class StringFormatTest {

    public static void main(String[] args) {
        System.out.println("**************");
        int d = 512;
        System.out.printf("%14d\n", d);
        System.out.printf("%-14d\n", d);
        double f = Math.PI;
        System.out.printf("%14.2f\n", f);
        System.out.printf("%.5f\n", f);
        System.out.printf("%14.4e\n", f);
        String s = "Hello, World";
        System.out.printf("%14s\n", s);
        System.out.printf("%-14s\n", s);
        System.out.printf("%14.5s\n", s);
    }
}
