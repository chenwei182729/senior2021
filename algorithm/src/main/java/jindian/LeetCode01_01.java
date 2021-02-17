package jindian;

/**
 * @author chenxinwei
 * @date 2020/12/30 17:48
 **/
public class LeetCode01_01 {
    /**
     * 判读字符是否唯一
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
        int[] charCount = new int[256];
        for (char c : astr.toCharArray()) {
            if(charCount[c]>0){
                return false;
            }
            charCount[c]++;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode01_01 leetCode01_01 = new LeetCode01_01();
        System.out.println(leetCode01_01.isUnique("leetcode01"));
        System.out.println(leetCode01_01.isUnique("abc"));
    }
}
