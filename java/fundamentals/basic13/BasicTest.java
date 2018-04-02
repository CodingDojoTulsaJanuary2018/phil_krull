/**
 * BasicTest
 */
import java.util.ArrayList;

public class BasicTest {
    public static void main(String[] args) {
        Basic test = new Basic();
        int[] myArr = {1,-4,7,2,-5,9};
        String myStr = "Java";
        ArrayList result = test.swapValues(myArr);
        ArrayList result2 = test.swapValues(myArr, myStr);
        System.out.println(result);
        System.out.println(result2);
    }
}