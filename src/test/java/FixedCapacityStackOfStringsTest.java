import com.jayne.book.FixedCapacityStackOfStrings;
import com.jayne.util.In;
import com.jayne.util.StdOut;

/**
 * Created by Jayne on 2018/12/19.
 */
public class FixedCapacityStackOfStringsTest {

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack
                = new FixedCapacityStackOfStrings(100);
        In in = new In("tobe.txt");
        while (!in.isEmpty()){
            String item = in.readString();
            if(!item.equals("-")){
                stack.push(item);
            }else if(!stack.isEmpty()){
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.printf("(" + stack.size() + " left on stack)");
    }
}
