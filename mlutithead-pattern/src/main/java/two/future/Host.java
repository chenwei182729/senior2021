package two.future;


/**
 * @author chenxinwei
 * @date 2021/2/22 18:32
 **/
public class Host {
    public Data request(final int count, final char c) {
        System.out.println("\t request(" + count + "," + c + ") BEGIN");
        final FutureData futureData = new FutureData();
        new Thread(() -> {
            RealData readdata = new RealData(count, c);
            futureData.setRealData(readdata);
        }).start();

        System.out.println("\t request(" + count + "," + c + ") END");
        return futureData;
    }
}
