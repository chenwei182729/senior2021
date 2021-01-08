package jindian;

/**
 * @author chenxinwei
 * @date 2020/12/30 17:48
 **/
public class LeetCode01_03 {
    public String replaceSpaces(String S, int length) {
        if(S==null){
            return null;
        }
        final String str = S.substring(0, length);
        return str.replaceAll(" ","%20");
    }
    public static void main(String[] args) {
        LeetCode01_03 leetCode01_01 = new LeetCode01_03();
        System.out.println(leetCode01_01.replaceSpaces( "               ",5));

    }
}
