
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author chenxinwei
 * @date 2020/12/30 16:30
 **/
public class ForDemo {
    public static void main(String[] args) {
        List<Integer> integerList = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        for (Integer integer : integerList) {
            System.out.println(integer);
        }

        int i = 0;
        while (true) {
            if (i >= integerList.size()) {
                break;
            }
            System.out.println(integerList.get(i));
            i++;
        }
    }
}
