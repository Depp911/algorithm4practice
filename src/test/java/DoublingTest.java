import com.jayne.book.ThreeSum;
import com.jayne.util.StdOut;
import com.jayne.util.StdRandom;
import com.jayne.util.Stopwatch;

/**
 * 测试ThreeSum的运行时间与数据规模的关系
 *
 * Created by Jayne on 2018/12/21.
 */
public class DoublingTest {

    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch stopwatch = new Stopwatch();
        ThreeSum.count(array);
        return stopwatch.elapsedTime();
    }

    public static void main(String[] args) {
        for(int N = 250; true; N += N){
            StdOut.printf("%7d %5.1f\n", N, timeTrial(N));
        }
    }
}
